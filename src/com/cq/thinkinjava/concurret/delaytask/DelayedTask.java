/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.delaytask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-8-1
 * @version : 1.0
 */
public class DelayedTask implements Runnable,Delayed {
    
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    
    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();
    
    
    /**
     * 
     */
    public DelayedTask(int delayedMillionseconds) {
        delta = delayedMillionseconds;
        trigger = System.nanoTime();
        sequence.add(this);
    }
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see java.util.concurrent.Delayed#getDelay(java.util.concurrent.TimeUnit)
     */
    @Override
    public long getDelay(TimeUnit unit) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Delayed o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
