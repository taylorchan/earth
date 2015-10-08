/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


/**
 * 线程中的异常捕获
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class UncaughtException {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exe.execute(new ExceptionThread());
    }
}
class ExceptionThread implements Runnable{

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run by "+ t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
        
    }
    
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    /* (non-Javadoc)
     * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable)
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught "+e);
    }
}
/**
 * 线程工厂的使用方法，可以对线程进行在包装
 * 
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r){
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        return t;
    }
} 