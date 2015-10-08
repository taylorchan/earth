/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.customandproducer;


/**
 * 
 * @author:   taylor
 * @since:    2013-1-28
 * @version : 1.0
 */
public class Mutex {
    
    private static final int size = 10;
    public static void main(String[] args) {
        
        Pool p = new Pool(size);
        Thread t = new Thread(new Producer(p), "producer");
        t.start();
        t =  new Thread(new Consumer(p), "consumer");
        t.start();
    }
    
}

class Producer implements Runnable{
    
    Pool p;
    
    
    /**
     * 
     */
    public Producer(Pool p) {
        this.p = p;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true)
            p.produce(new Object());
    }
    
}

class Consumer implements Runnable{
    Pool p;
   
    
    /**
     * 
     */
    public Consumer( Pool p) {
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

class Pool{
    int full = 0;
    int size;
    Object[] buffs;
    /**
     * 
     */
    public Pool(int size) {
        this.size = size;
       buffs = new Object[size];
    }
    
    /**
     * 条件是  buffer==size的时候会通知到这边
     * 
     *
     *
     * @param obj
     */
    public void produce(Object obj){
        synchronized (this) {
            if(full == size)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int index = full++;
                buffs[index] = obj;
                System.out.println(Thread.currentThread().getName() + "  produced  " + index);
                if(full == size)
                    this.notify();
        }
    }
    /**
     * 开始消费了,当缓冲区填满的时候会通知consumer
     */
    public void consume(){
        synchronized (this) {
            while(full == 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            int index = --full;
            buffs[index] = null;
            System.out.println(Thread.currentThread().getName() + "  consumed " + index);
            if(full == 0)
                this.notify();
        }
    }
}
