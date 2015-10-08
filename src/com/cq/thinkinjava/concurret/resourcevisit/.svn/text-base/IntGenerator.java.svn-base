/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.resourcevisit;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public abstract class IntGenerator {
    
    private volatile boolean canceled;
    public abstract int next();
    
    public void cancel(){
        canceled   = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
