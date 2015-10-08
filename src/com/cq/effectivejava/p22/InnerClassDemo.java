/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.effectivejava.p22;

import java.util.concurrent.Executors;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-8-5
 * @version : 1.0
 */
public class InnerClassDemo {
    
    public InnerClassDemo() {
        super();
    }
    
    public static void main(String args[]) {
        Outer o = new Outer();
        o.startInner();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("main thread finish,  o must have been gc");
    }
}

class Outer{
    
    private int counter = 0;
    
    void get(){
        counter++;
        System.out.println("this is the  " + counter + "  index");    
    }
    
    void startInner(){
        Executors.newSingleThreadExecutor().execute(new Inner());        
    }
    
    private final class Inner implements Runnable{           
        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("inner class begin to run");
            int i = 0;
            try {
                while(i++ <=10){
                    Thread.sleep(2000);
                    get();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }    
            System.out.println("inner thread is over");            
        }
    }
}
