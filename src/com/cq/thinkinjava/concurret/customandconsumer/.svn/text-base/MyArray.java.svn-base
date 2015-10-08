/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.customandconsumer;

import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-7-26
 * @version : 1.0
 */
public class MyArray<T>{
    
    private static final int INITIALIZE_VALUE = 10;
    
    
    private int size = 0;
    
    private final Lock lock = new ReentrantLock();
    
    private final Condition con = lock.newCondition();
    T[] array;
    MyArray(){
        array = (T[])Array.newInstance(Object.class, INITIALIZE_VALUE);
    }
    
    public void produce(){
        lock.lock();
        try{//条件为先生产指定数目的产品
            array[size++] = (T)new Object();
            System.out.println("produce an object");
            while(size == INITIALIZE_VALUE){
                con.signal();
                con.await();
            }
            
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    
    public Object consume(){
        lock.lock();
        Object obj = null;
        try{//消耗掉指定数目的产品
            while(size == 0){
                con.signal();
                con.await();
            }
            obj = array[size-1];
            array[--size] = null;
            System.out.println("consume an object");
            
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        return obj;
    }
    public static void main(String[] args) throws InterruptedException {
        MyArray<String> array = new MyArray<String>();
        ExecutorService exec = Executors.newCachedThreadPool();
        //让消费者先运行，进入阻塞等待状态
        exec.execute(new Consumer(array));
        TimeUnit.MILLISECONDS.sleep(1);
        exec.execute(new Producer(array));
       
        
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
    
}
