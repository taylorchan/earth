/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.synchron;


import static net.mindview.util.Print.print;
/**
 * 不同的同步对象之间不会相互影响
 * yield：Running -> Runable
 * sleep：Running -> Blocked -> Runable，调用sleep()方法线程进入阻塞状态
 * suspend，resume，stop方法均被废止了
 * 任务进入阻塞状态的情况：
 * 1.调用sleep()方法
 * 2.调用wait()使线程挂起
 * 3.任务试图在某个对象上调用其同步方法，但对象锁已经被另外一个任务所占用
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
class DualSynch {
  private Object syncObject = new Object();
  public  void f() {
      synchronized(this){
          for(int i = 0; i < 5; i++) {
             print("f()");
             Thread.yield();
         }
      }
  }
  public void g() {
    synchronized(syncObject) {
      for(int i = 0; i < 5; i++) {
        print("g()");
        Thread.yield();
      }
    }
  }
}

public class SyncObject {
  public static void main(String[] args) {
    final DualSynch ds = new DualSynch();
    new Thread() {
      public void run() {
        ds.f();
      }
    }.start();
    try {
        Thread.sleep(1);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    ds.g();
  }
} 
/** Output: (Sample)*/
