/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.customandconsumer;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-7-26
 * @version : 1.0
 */
public class Consumer implements Runnable{
    
    private MyArray array;
    /**
     * 
     */
    public Consumer(MyArray array) {
        this.array = array;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
               
                Thread.sleep(50);
                array.consume();
            }
        }catch(InterruptedException e){
            System.out.println("be Interrupted!");
        }
        
    }
    
}
