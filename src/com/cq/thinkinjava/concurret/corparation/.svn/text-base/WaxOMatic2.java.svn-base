/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.corparation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 自己实现车子打蜡抛光的过程，抛光后打蜡，打蜡完成后再抛光
 * @author: qiang.chen
 * @since:    2012-7-26
 * @version : 1.0
 */
public class WaxOMatic2 {
    public static void main(String[] args) {
        Automatic car = new Automatic();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxProcess(car));
        exec.execute(new BuffProcess(car));
        try {
            TimeUnit.MILLISECONDS.sleep(5000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        exec.shutdownNow();
    }
}
class Automatic {
    /**
     * 是否抛光的状态标志
     */
    private boolean waxOn = false;
    
    
    private final Lock lock  = new ReentrantLock();
    
    private final Condition condition = lock.newCondition();
    /**
     * 车子抛光后，抛光标志为true，可以执行打蜡
     */
    public void waxed() {
        lock.lock();
        try{
            waxOn = true;
            condition.signal();
        }finally{
            lock.unlock();
        }
    }
    /**
     * 车子打蜡后，抛光条件为false
     */
    public void buffed() {
        lock.lock();
        try{
            waxOn = false;
            condition.signal();
        }finally{
            lock.unlock();
        }
     
    }
    /**
     * 打蜡完成等待抛光
     * @throws InterruptedException 
     */
    public void waitForWaxing() throws InterruptedException{
        lock.lock();
        try{
            while(!waxOn)
                condition.await();
        }finally{
            lock.unlock();
        }
    }
    /**
     * 抛光完成，等待打蜡
     *
     * @throws InterruptedException
     */
    public void waitForBuffing()
    throws InterruptedException {
        lock.lock();
        try{
            while(waxOn)
               condition.await(); 
        }finally{
            lock.unlock();
        }
    }
}
/**
 * 抛光的线程
 * 
 * @author: qiang.chen
 * @since:    2012-7-26
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
class WaxProcess implements Runnable{
    
    private final Automatic car;
    
    /**
     * 
     */
    public WaxProcess(Automatic car) {
        this.car = car;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                System.out.println("now Waxing a car!");
                TimeUnit.MILLISECONDS.sleep(100L);
                car.waxed();
                car.waitForBuffing();
                
            }
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("exiting var InterruptedException!");
        }
    }
    
}
/**
 * 上蜡的线程
 * 
 * @author: qiang.chen
 * @since:    2012-7-26
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
class BuffProcess implements Runnable{
    
    private final Automatic car;
    
    /**
     * 
     */
    public BuffProcess(Automatic car) {
        this.car = car;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){//抛光在打蜡之前，所以要先阻塞等待
                car.waitForWaxing();
                System.out.println("now Buffing a car!");
                TimeUnit.MILLISECONDS.sleep(100L);
                car.buffed();
            }
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("exiting var InterruptedException!");
        }
    }
}