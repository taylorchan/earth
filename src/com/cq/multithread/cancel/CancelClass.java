/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.multithread.cancel;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-26
 * @version : 1.0
 */
public class CancelClass implements Runnable{
    
    private volatile boolean cancelFlag = false;
    public CancelClass() {
        super();
    }
    
    public static void main(String args[]) {
        
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(!cancelFlag){
            //do things util it is canceld
        }
    }
    
    public void cancelOper(){
        this.cancelFlag = true;
     }
}
