/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.resourcevisit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 序列产生器
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class EvenGenerator extends IntGenerator {
    
    private int currentEvenValue = 0;

    /* (non-Javadoc)
     * @see com.cq.thinkinjava.concurret.resourcevisit.IntGenerator#next()
     */
    @Override
    public int next() {//多个线程调用next方法，极有可能使current的状态不一致，在自增的过程中，即使使用volatile关键字也没用
        // TODO Auto-generated method stub
        currentEvenValue++;//danger here!
        currentEvenValue++;
        return currentEvenValue;
    }
    
    public static void main(String[] args) {
        EventChecker.test(new EvenGenerator(), 10);
    }
    
}
