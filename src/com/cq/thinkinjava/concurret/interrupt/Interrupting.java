
package com.cq.thinkinjava.concurret.interrupt;

import static net.mindview.util.Print.print;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * 線程在阻塞狀態下被intterrupt，都會拋出intterruptException
 * 本類是可中斷的阻塞實例
 * 
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
class SleepBlocked implements Runnable {
    
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {//在此处中断会抛出异常
            print("cathch SleepBlocked InterruptedException-- "+ Thread.interrupted());
        } 
        print("Exiting SleepBlocked.run()");
    }
}
/**
 * 不可中斷的阻塞示例，I/o阻塞
 * 
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
class IOBlocked implements Runnable {
    
    private InputStream in;
    
    public IOBlocked(InputStream is) {
        in = is;
    }
    
    public void run() {
        try {
            print("Waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                print("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        print("Exiting IOBlocked.run()");
    }
}

/**
 * 对此线程调用interrupt无用
 * 
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
class RunningBlocked implements Runnable {
    
    public RunningBlocked() {
    }
    public void run() {
       int i = 0;
       while(i< Integer.MAX_VALUE){
           System.out.println(i++);
           Thread.yield();
       }        
       print("Exiting IOBlocked.run()");
    }
}

/**
 * 不可中断的阻塞示例，在synchronized块上面等待，意思即是要中断一个线程，必须要能获取到需要的锁或者，该线程对象未被其他对象锁住
 * 
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
class SynchronizedBlocked implements Runnable {
    
    public synchronized void f() {
        while (true)
            // Never releases lock
            Thread.yield();
    }
    
    public SynchronizedBlocked() {
        new Thread() {
            
            public void run() {
                f(); //在线程的构造器中启动了新线程，由于f()是同步方法，新线程获取了本对象的锁，且是死循环，同步方法不会退出，故一直占用本对象锁
                    //所以在run方法中调用f()方法的时候，一直处于阻塞等待状态
            }
        }.start();
    }
    
    public void run() {
        print("Trying to call f()");
        f();
        print("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    
    private static ExecutorService exec = Executors.newCachedThreadPool();
    
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        print("Interrupting " + r.getClass().getName());
        f.cancel(true); // Interrupts if running
        print("Interrupt sent to " + r.getClass().getName());
    }
    
    public static void main(String[] args) throws Exception {
       // test(new SleepBlocked());
        //test(new RunningBlocked());
        //test(new IOBlocked(System.in));
        //test(new SynchronizedBlocked());
        Thread t = new Thread(new RunningBlocked());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
        t.interrupt();
        System.out.println("t is interrupted");
        TimeUnit.SECONDS.sleep(1);
        print("Aborting with System.exit(0)");
        System.exit(0); // ... since last 2 interrupts failed
    }
}
