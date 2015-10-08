/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.customandproducer;


/**
 * there are three signals.
 * there are some problems
 * @author:   taylor
 * @since:    2013-1-29
 * @version : 1.0
 */
public class SignalAsC {
    private static final int size = 10;
    public static void main(String[] args) {
        Buffer p = new Buffer(size);
        Thread t = new Thread(new Creater(p), "creater");
        t.start();
        t =  new Thread(new Customer(p), "customer");
        t.start();
    }
}

class Creater implements Runnable{
    
    Buffer p;
    
    
    /**
     * 
     */
    public Creater(Buffer p) {
        this.p = p;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true)
            p.produce();
    }
    
}

class Customer implements Runnable{
    Buffer p;
   
    
    /**
     * 
     */
    public Customer (Buffer p) {
        this.p = p;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true)
            p.consume();
    }
    
    
}

class Buffer{
    Object[] objs;
    int size;
    private  Integer empty;
    private Integer full = 0;
    private final Object bufferLock = new Object();
    /**
     * 
     */
    public Buffer(int size) {
        this.size = size;
        this.empty = size;
        objs = new Object[size];
    }
    
    public void produce(){
        synchronized (empty) {
            if(empty == 0)
                try {
                    empty.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            empty--;
        }
        Object o = new Object();
        int index;
        synchronized (full) {
            index = full++;
            if(full == size)
                full.notify();
        }
        synchronized(bufferLock){
            objs[index] = o;
            System.out.println(Thread.currentThread().getName() +" add item in index "+ index);
        }
    }
    
    public void consume(){
        int index = -1;
        synchronized (full) {
            if(full == 0){
                try {
                    full.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            index = --full;
        }
        synchronized (bufferLock) {
            objs[index] = null;
            System.out.println(Thread.currentThread().getName() +" consume item in index "+ index);
        }
        
        synchronized (empty) {
            empty++;
            if(empty == size)
                empty.notify();
        }
    }
}
