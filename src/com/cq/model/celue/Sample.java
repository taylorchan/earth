
package com.cq.model.celue;


public class Sample {
    
    private int number = 0;
    
    private Object lock = new Object();
    
    public void A() {
        synchronized (lock) {
            while (number != 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number = 1;
            System.out.print("A");
            lock.notify();
        }  
    }
    
    public  void B() {
        synchronized (lock) {
            while (number != 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number = 2;
            System.out.print("B");
            lock.notify();
        }
    }
    
    public void C() {
        synchronized (lock) {
            while (number != 2) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number = 0;
            System.out.print("C");
            lock.notify();
        }
    }    
}

