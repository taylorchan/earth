/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-14
 * @version : 1.0
 */
public class BlockingBuffer<E> {
    
    public static final int CA = 32;    
    
    private int num = CA;
    
    private List<E> list;
    
    Lock lock = new ReentrantLock();
    
    Condition not_empty = lock.newCondition();
    
    Condition not_full = lock.newCondition();
    
    public BlockingBuffer() {
        super();
        list = new ArrayList<E>();
    }
    
    public BlockingBuffer(int ca) {
        super();
        list = new ArrayList<E>(ca);
        num = ca;
    }
    
    public E put(E e){
        lock.lock();
        try{
           while(list.size() == num){
               System.out.println(Thread.currentThread().getName() +  "is waiting, num is" + list.size());
                this.not_full.await();
           }
           list.add(e);
           this.not_empty.signal();           
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }finally{
            lock.unlock();
        }
        return e;
    }
    
    public E pop(){
        E e = null;
        lock.lock();
        try{
           while(list.size() == 0){
               System.out.println(Thread.currentThread().getName() +  "is waiting");
                this.not_empty.await();
           }
           e = list.remove(0);
           this.not_full.signal();           
        }catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }finally{
            lock.unlock();
        }
        return e;
    }
    
    public static void main(String args[]) {
        final BlockingBuffer bb = new BlockingBuffer(8);
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    bb.pop();
                }
            }}).start();
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    bb.put(new Object());
                }
            }}).start();
    }
}
