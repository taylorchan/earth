/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.customandproducer;


/**
 * first readers-writers problem,
 * no reader should wait for other readers to finish simply because a writer is waiting.
 * @author:   taylor
 * @since:    2013-1-28
 * @version : 1.0
 */
public class ReaderAndWriter {
    public static void main(String[] args) {
        Context c = new Context();
       
        Thread t = new Thread(new Writer(c),"writer1");;
        t.start();
        t = new Thread(new Reader(c),"reader2");
        t.start();
        
       // t.start();
    }
}


class Reader implements Runnable{
    
    Context c;
    /**
     * 
     */
    public Reader(Context c) {
        this.c = c;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true)
            c.read();
    }
    
}

class Writer implements Runnable{
    Context c;
    
    
    /**
     * 
     */
    public Writer(Context c) {
        this.c = c;
    }
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        int index = 0;
        while(true){
           c.write("" + index++);
           try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
        
    }
    
}


class Context{
    /**
     * writeLock functions as a mutual-exclusion semaphore forthe writers.
     * it was shared by write and read threads.
     */
    private final Object writeLock = new Object();
    /**
     * lock for readCount
     */
    private final  Object readCountLock = new Object();
    /**
     * to keep the count of reader thread
     */
    int readCount = 0;
    
    boolean writable = false;
    
    private StringBuilder sb;
    
    /**
     * 
     */
    public Context() {
        sb = new StringBuilder(64);
    }
    
    public void read(){
        System.out.println(Thread.currentThread().getName() + " begin to read");
        synchronized (readCountLock) {
            readCount++;
            synchronized (writeLock) {//when there are readers,write is forbidden
                if(readCount >=1)
                    writable = false;
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished reading ---- " + sb.toString());
        synchronized (readCountLock) {
            readCount--;
            if(readCount == 0){
                System.out.println("no readers,can do write!");
                synchronized (writeLock) {
                    writable = true;
                    writeLock.notify();
                }
            }
        }
    }
    
    public void write(String s){
        synchronized (writeLock) {
           while(!writable){
               try {
                writeLock.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           }
           sb.append(s);
           System.out.println(Thread.currentThread().getName() + " finished writing --- "+ sb.toString());
           writeLock.notify();
        }
    }
    
    
    
}
