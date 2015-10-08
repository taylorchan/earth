/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



class Pair { // Not thread-safe
  private int x, y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public Pair() { this(0, 0); }
  public int getX() { return x; }
  public int getY() { return y; }
  /**
   * 操作非线程安全的，可是作为原子操作，两个变量同步增加的操作保证可以再pairManager中来保证
   */
  public void incrementX() { x++; }
  public void incrementY() { y++; }
  public String toString() {
    return "x: " + x + ", y: " + y;
  }
  public class PairValuesNotEqualException  extends RuntimeException {
    private static final long serialVersionUID = -6843352646489392400L;

    public PairValuesNotEqualException() {
      super("Pair values not equal: " + Pair.this);
    }
  }
  // Arbitrary invariant -- both variables must be equal:
  public void checkState() {
    if(x != y)
      throw new PairValuesNotEqualException();
  }
}

// Protect a Pair inside a thread-safe class:
abstract class PairManager {
    
  AtomicInteger checkCounter = new AtomicInteger(0);
  
  protected Pair p = new Pair();
  
  private List<Pair> storage =
    Collections.synchronizedList(new ArrayList<Pair>());
  
  public synchronized Pair getPair() {
    // Make a copy to keep the original safe:
    return new Pair(p.getX(), p.getY());
  }
  // Assume this is a time consuming operation
  protected void store(Pair pa) {
    storage.add(pa);
    try {
      TimeUnit.MILLISECONDS.sleep(50);
    } catch(InterruptedException ignore) {}
  }
  public abstract void increment();
}

//同步使用在整个方法中
class PairManager1 extends PairManager {
    /**
     * 方法级别的同步
     */  
  public synchronized void increment() {
    p.incrementX();
    p.incrementY();
    store(getPair());
  }
}

//使用同步块:吞吐量比方法级别的要高，注意非静态方法级别的同步，相当于同步块synchronizd(this)
//吞吐量 变量级别 > 同步块 > 方法级同步
class PairManager2 extends PairManager {
  public void increment() {
    Pair temp;
    /**
     * 块级别的同步
     */
    synchronized(this) {
      p.incrementX();
      p.incrementY();
      temp = getPair();
    }
    store(temp);
  }
}
/**
 * 显示的加锁方式
 * 
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
class ReentrantLockPairManager extends PairManager {
    private Lock lock = new ReentrantLock();
    public void increment() {
        lock.lock();
        Pair temp;
        try{
            p.incrementX();
            p.incrementY();
            temp = getPair();         
        }finally{
            lock.unlock();
        }
        store(temp);
    }
}

class ObjectLockPairManager extends PairManager{
    
    private final Object lock = new Object();

    /* (non-Javadoc)
     * @see com.cq.thinkinjava.concurret.PairManager#increment()
     */
    @Override
    public void increment() {
        Pair temp;
        /**
         * 块级别的同步
         */
        synchronized(lock) {
          p.incrementX();
          p.incrementY();
          temp = getPair();
        }
        store(temp);
    }
    
}

class PairManipulator implements Runnable {
  private PairManager pm;
  public PairManipulator(PairManager pm) {
    this.pm = pm;
  }
  public void run() {
    while(true)
      pm.increment();
  }
  public String toString() {
    return "Pair: " + pm.getPair() +
      " checkCounter = " + pm.checkCounter.get();
  }
}

class PairChecker implements Runnable {
  private PairManager pm;
  public PairChecker(PairManager pm) {
    this.pm = pm;
  }
  public void run() {
    while(true) {
      pm.checkCounter.incrementAndGet();
      pm.getPair().checkState();
    }
  }
}

public class CriticalSection {
  // Test the two different approaches:
  static void  testApproaches(PairManager pman1, PairManager pman2,PairManager pman3,PairManager pman4) {
    ExecutorService exec = Executors.newCachedThreadPool();
    PairManipulator pm1 = new PairManipulator(pman1);
    PairManipulator pm2 = new PairManipulator(pman2);
    PairManipulator pm3 = new PairManipulator(pman3);
    PairManipulator pm4 = new PairManipulator(pman4);
    PairChecker pcheck1 = new PairChecker(pman1);
    PairChecker pcheck2 = new PairChecker(pman2);
    PairChecker pcheck3 = new PairChecker(pman3);
    PairChecker pcheck4 = new PairChecker(pman4);
    exec.execute(pm1);
   // exec.execute(pm2);
    //exec.execute(pm3);
  exec.execute(pm4);
    exec.execute(pcheck1);
   // exec.execute(pcheck2);
    //exec.execute(pcheck3);
    exec.execute(pcheck4);
    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch(InterruptedException e) {
      System.out.println("Sleep interrupted");
    }
    System.out.println("pm1: " + pm1 + "\npm2: " + pm2+ "\npm3: " + pm3+ "\npm4: " + pm4);
    System.exit(0);
  }
  public static void main(String[] args) {
    PairManager pman1 = new PairManager1();
    PairManager pman2 = new PairManager2();
    PairManager pman3 = new ReentrantLockPairManager();
    PairManager pman4 = new ObjectLockPairManager();
    testApproaches(pman1, pman2,pman3,pman4);
  }
} /* Output: (Sample)
pm1: Pair: x: 15, y: 15 checkCounter = 272565
pm2: Pair: x: 16, y: 16 checkCounter = 3956974
*///:~
