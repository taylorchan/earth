/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 读写原子性的测试
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class AtomicTest implements Runnable {
    private int i = 0;
    public synchronized int getValue(){return i;}
    private synchronized void increment(){
        i++;
        i++;
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
        AtomicTest at = new AtomicTest();
        exec.execute(at);
        while(true){//虽然get是原子操作，但是仍然可能取到i的中间值
            int val = at.getValue();
            if(val == 2<<29){
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
