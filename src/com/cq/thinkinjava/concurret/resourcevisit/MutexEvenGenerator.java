/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.resourcevisit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 适应多线程的序列生成器
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class MutexEvenGenerator extends IntGenerator {
    
    private int currentEvenValue = 0;

    /**
     * 显式的创建锁,等同于synchronized
     */
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {//多个线程调用next方法，极有可能使current的状态不一致，在自增的过程中，即使使用volatile关键字也没用
        lock.lock();
        try{
            currentEvenValue++;//danger here!
            currentEvenValue++;
            return currentEvenValue;
        }finally{
            lock.unlock();
        }
    }
}
