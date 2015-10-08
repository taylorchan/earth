/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-18
 * @version : 1.0
 */
public class Join {
    
    public Join() {
        super();
    }
    
    public static void main(String args[]) {
        Thread t1 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished");
            }
        });
        t1.start();
        t2.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
