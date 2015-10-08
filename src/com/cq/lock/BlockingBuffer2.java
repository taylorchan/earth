/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-14
 * @version : 1.0
 */
public class BlockingBuffer2<E> {
    
    public static final int CA = 32;    
    
    private int num = CA;
    
    private List<E> list;
    
    private final Object lock = new Object(); //一个监视器可以实现一个隐含条件
    
    private final Object empty_lock = new Object();
    
    public BlockingBuffer2() {
        super();
        list = new ArrayList<E>();
    }
    
    public BlockingBuffer2(int ca) {
        super();
        list = new ArrayList<E>(ca);
        num = ca;
    }
    
    public int getSize(){
        int size = 0;
        synchronized (lock) {
            size = list.size();
        }
        return size;
    }
    
    public E put(E e){
      synchronized (lock) {
           while(this.getSize() == CA){
           try {
                   System.out.println(Thread.currentThread().getName() +  "is waiting");
                    this.lock.wait();
            } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                     e1.printStackTrace();
              }
           }
           list.add(e);
           synchronized (empty_lock) {
               this.empty_lock.notify();
           }
     }
     return e;
    }
    
    public E pop(){
        E e = null;
        synchronized (lock) {
            while(this.getSize() == 0){
                synchronized (empty_lock) {
                     try {
                         System.out.println(Thread.currentThread().getName() +  "is waiting");
                         this.empty_lock.wait();
                     } catch (InterruptedException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     }
               }
            }  
            e = list.remove(0);
            lock.notify();
      }
      return e;
    }
    
    public static void main(String args[]) {
        final BlockingBuffer bb = new BlockingBuffer(1);
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
