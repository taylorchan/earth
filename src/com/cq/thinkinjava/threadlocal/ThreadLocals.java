/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.threadlocal;


/**
 * we always use it in a thread context to keep some value
 * note that static or singleton is neccessary
 * @author:   taylor
 * @since:    2013-1-8
 * @version : 1.0
 */
public class ThreadLocals {
    
    
    private static class ThreadLocal1 extends ThreadLocal<String>{
    }
    
    private static ThreadLocal1 keeper = new ThreadLocal1();
    
    public static void keepValue(String value){
        keeper.set(value);
    }
    
    public static String getValue(){
        return keeper.get();
    }
    
    public static void main(String[] args) {
        keepValue("mainThread String");
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println("t2 started and ready to sleep 2s");
                keepValue("subThread String");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("in subThread  getValue：" + getValue());
                System.out.println("t1 finished");
            }
            
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                System.out.println("t2 started and ready to sleep 4s");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("t2 finished");
            }
            
        };
        
        Thread t3 = new Thread(){
            @Override
            public void run(){
                System.out.println("t3 started and ready to sleep 10s");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("t3 finished");
            }
            
        };
        t3.start();
        t2.start();
        t.start();
        try {
            t.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("in main Thread getValue：" + getValue());
        
    }
}
