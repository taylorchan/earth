/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.multithread.latch;

import java.util.concurrent.CountDownLatch;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-26
 * @version : 1.0
 */
public class LatchDemo {
    
    public LatchDemo() {
        super();
    }
    
    public long timeTasks(int nThreads, final Runnable task){
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(nThreads);
        int i = 0;
        while(i<nThreads){
            Thread  t = new Thread(){
                @Override
                public void run() {
                    try {
                        start.await();//所有的线程都到这个点来集结
                        task.run();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        end.countDown();
                    }
                }
            };
            i++;
            t.start();
        }
        
        start.countDown();
        try {
            end.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return 0;
    }
    
    public static void main(String args[]) {
        
    }
}
