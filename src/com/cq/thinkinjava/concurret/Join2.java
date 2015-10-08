/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret;

import java.util.concurrent.TimeUnit;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-10-16
 * @version : 1.0
 */
public class Join2 {
    
    public static void main(String[] args) {
        System.out.println("main thread is starting!");
        Thread t = new Thread() {
            
            @Override
            public void run() {
                System.out.println("join thread is starting!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("join thread has ended!");
            }
        };
        t.start();//以线程池的方式调度线程则不行？
        try {//主线程中加入了t线程，需要等待t线程执行完毕，主线程才会继续向下执行
            t.join() ;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        
        System.out.println("main thread has ended!");
    }
}
