/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.resourcevisit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class EventChecker implements Runnable {
    
    private IntGenerator generator;
    private final int id;
    
    /**
     * 
     */
    public EventChecker(IntGenerator g,int ident) {
        generator = g;
        id = ident;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
       while(!generator.isCanceled()){
           int val = generator.next();
           if(val % 2 != 0){
               System.out.println(val + "not even!");
               generator.cancel();
           }
       }
    }
    public static void test(IntGenerator gp,int count){
        System.out.println("Press control-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EventChecker(gp,i));
        }
        exec.shutdown();
    }
    
}
