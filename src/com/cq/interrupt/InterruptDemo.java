/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.interrupt;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-25
 * @version : 1.0
 */
public class InterruptDemo {
    
    public InterruptDemo() {
        super();
    }
    
    public static void main(String args[]) {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                   boolean f = Thread.currentThread().isInterrupted();
                   System.out.println("is interrupted:" + f);
                   Thread.currentThread().interrupt();//恢复被中断的状态
                   f = Thread.currentThread().isInterrupted();
                   System.out.println("is interrupted:" + f);
                   f = Thread.interrupted();
                   System.out.println("f si" + f);
                   // e.printStackTrace();
                }
            }});
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t.interrupt();
    }
}
