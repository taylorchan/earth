/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;



/**
 *三个线程, 轮流打印A,B,C
 * @author:   Taylor Chan
 * @since:    2015-9-14
 * @version : 1.0
 */
public class PrintChange2 {
    
    Object lock = new Object();
    
    private int num = 1;
    
    public PrintChange2() {
        super();
    }
    
    public void printA(){
        synchronized (lock) {
            while(num % 3 != 1){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("---------------A--------------- ");
            num++;
            lock.notifyAll(); //为什么这里一定要用notifyAll,需要唤醒所有的线程
        }             
    }
    
    public void printB(){
        synchronized (lock) {
            while(num % 3 != 2){//多个线程可以基于不同的条件谓词在同一个条件队列上等待
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("---------------B--------------- ");
            num++;//条件改变了,一定要发出通知
            lock.notifyAll();//为什么这里一定要用notifyAll
        }             
    }
    
    public void printC(){
        synchronized (lock) {
            while(num % 3 != 0){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("---------------C--------------- ");
            num++;
            lock.notifyAll();//为什么这里一定要用notifyAll
        }             
    }
    
    public static void main(String args[]) {
        final PrintChange2 pc = new PrintChange2();
        new Thread(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    pc.printA();
                }
            }
        }).start();
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    pc.printB();
                }
            }
        }).start();
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    pc.printC();
                }
            }
        }).start();
    }
    
}

