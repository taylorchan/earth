/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.waitone;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-7-15
 * @version : 1.0
 */

public class QueueBuffer {
    int n;
    boolean valueSet = false;
    public int get() {
        synchronized (this) {
               if (!valueSet){
                 try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException caught");
                    }
                }
                System.out.println("Got: " + n);
                valueSet = false;
                notify();
                return n;
            }
    }

    public void put(int n) {
        synchronized (this) {
                if (valueSet){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException caught");
                    }
                }
                this.n = n;
                valueSet = true;
                System.out.println("Put: " + n);
                notify();
        }
    }
}

class Producer implements Runnable {
    private QueueBuffer q;
    Producer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    private QueueBuffer q;
    Consumer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    public void run() {
        while (true) {
            q.get();
        }
    }
}

