/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;

import java.util.concurrent.atomic.AtomicReference;


/**
 * 当前线程不停地的在循环体内执行实现的，当循环的条件被其他线程改变时 才能进入临界区
 * @author:   Taylor Chan
 * @since:    2015-9-26
 * @version : 1.0
 */
public class SpinLock {
    
    private final AtomicReference<Thread> sign = new AtomicReference<Thread>();
    
    public void lock(){
        Thread current = Thread.currentThread();
        while(!sign.compareAndSet(null, current)){//第二个线程调用lock操作时由于owner值不为空，
            //导致循环一直被执行，直至第一个线程调用unlock函数将owner设置为null，第二个线程才能进入临界区
        }
    }
    
    public void unLock(){
        Thread current = Thread.currentThread();
        sign.compareAndSet(current,  null);
        
    }
    public SpinLock() {
        super();
    }
    
    public static void main(String args[]) {
        
    }
}
