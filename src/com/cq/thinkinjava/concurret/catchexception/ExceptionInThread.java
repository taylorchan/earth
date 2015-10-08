/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.catchexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-10-16
 * @version : 1.0
 */
public class ExceptionInThread {
    
    static class ExceptionThread implements Runnable{

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            Thread t = Thread.currentThread();
            System.out.println("runing thread: " + t);
            System.out.println("exeption handler: " + t.getUncaughtExceptionHandler());
            throw new RuntimeException();
        }
        
    }
    /**
     * 自定义线程的exception handlder,可通过此异常捕捉器捕捉异常，使线程中的异常不至于直接抛到控制台
     * 
     * @author:   qiang.chen
     * @since:    2012-10-16
     * @version : 1.0
     */
    static class MyThreadExcepitonHandler implements Thread.UncaughtExceptionHandler{

        /* (non-Javadoc)
         * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable)
         */
        @Override
        public void uncaughtException(Thread t, Throwable e) {
           System.out.println("cause: " + e);
            
        }
        
    }
    
    static class HandlerExceptionThreadFactory implements ThreadFactory{

        /* (non-Javadoc)
         * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
         */
        @Override
        public Thread newThread(Runnable r) {
           System.out.println("thread Factory creat a new Thread");
           Thread t = new Thread(r);
           t.setUncaughtExceptionHandler(new MyThreadExcepitonHandler());
           return t;
        }
        
    } 
    public static void main(String[] args) {
        //Executors.newCachedThreadPool().execute(new ExceptionInThread().new ExceptionThread());
        ExecutorService exe = Executors.newCachedThreadPool(new HandlerExceptionThreadFactory());
        exe.execute(new ExceptionThread());
    }
    
}
