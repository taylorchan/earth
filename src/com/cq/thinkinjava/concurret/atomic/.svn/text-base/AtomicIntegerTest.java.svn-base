/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class AtomicIntegerTest  implements Runnable{
    /**
     * 原子操作性变量
     */
    private AtomicInteger atomic;

    /**
     * 
     */
    public AtomicIntegerTest() {
        atomic = new AtomicInteger(0);
    }
    public void increment(){
        //确保操作是原子的，不用同步即可
        atomic.addAndGet(2);
    }
    /**
     * @return the atomic
     */
    public int getValue() {
        return atomic.get();
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true)
            increment();
        
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest at = new AtomicIntegerTest();
        exec.execute(at);
        while(true){//虽然get是原子操作，但是仍然可能取到i的中间值
            int val = at.getValue();
            if(val == 2<<20){
                System.out.println(val);
                System.exit(0);
                
            }
            if(val % 2!= 0){
                System.out.println(val);
                System.exit(0);
            }
            
        }
    }

}
