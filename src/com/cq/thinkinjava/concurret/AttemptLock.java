/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Lock对象尝试获取锁,可以试探对象是否被加锁
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class AttemptLock {
    private Lock lock = new ReentrantLock();
    
    public void untimed(){
        boolean captured  = lock.tryLock();
        try{
            System.out.println("tryLock(): " + captured);
        }finally{
            if(captured){
                lock.unlock();
            }
        }
    }
    public void timed(){
        boolean captured  = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);//持续两秒钟获取锁
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }   
        try{
            System.out.println("tryLock(2,seconds) "+ captured);
        }finally{
            if(captured)//通过标志位可以知道获取锁是否成功
                lock.unlock();
        }
    }
    public static void main(String[] args) {
        final  AttemptLock at = new AttemptLock();
        at.untimed();
        at.timed();
        new Thread(){
            {setDaemon(true);
            
            }
            @Override
            public void run(){
                at.lock.lock();
                System.out.println("acquired lock!");
            }
        }.start();
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        at.untimed();
        at.timed();
    }
}
