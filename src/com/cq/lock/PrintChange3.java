/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/**
 * 三个线程,轮流打印A,B,C, 第二种实现
 * @author:   Taylor Chan
 * @since:    2015-9-14
 * @version : 1.0
 */
public class PrintChange3 {
    
    Lock obj = new ReentrantLock();
    
    Lock printA = new ReentrantLock();
    
    Lock printB = new ReentrantLock();
    
    Lock printC = new ReentrantLock();
    
    
    private int num = 1;
    
    public PrintChange3() {
        super();
    }
    
    public void printA(){
        if(obj.tryLock()){
            if(printA.tryLock()){}
        }
        synchronized (obj) {
            while(num % 3 != 1){
                synchronized (printA) {
                    try {
                        printA.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("---------------A--------------- ");
            num++;
            synchronized (printB) {
                printB.notify(); //
            }
        }             
    }
    
    public void printB(){
        synchronized (obj) {
            while(num % 3 != 2){
                synchronized (printB) {
                    try {
                        printB.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("---------------B--------------- ");
            num++;
            synchronized (printC) {
                printC.notify();
            }
        }             
    }
    
    public void printC(){
        synchronized (obj) {
            while(num % 3 != 0){
                synchronized (printC) {
                    try {
                        printC.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("---------------C--------------- ");
            num++;
            synchronized (printA) {
                printA.notify();//
            }
           
        }             
    }
    
    public static void main(String args[]) {
        final PrintChange3 pc = new PrintChange3();
        new Thread(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true)
                    pc.printA();
            }
        }).start();
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true)
                    pc.printB();
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

