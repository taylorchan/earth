/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-14
 * @version : 1.0
 */
public class PrintChange {
    
    Lock lock = new ReentrantLock();
    
    Condition printA = lock.newCondition();
    
    Condition printB = lock.newCondition();
    
    Condition printC = lock.newCondition();
    
    private int num = 1;
    
    public PrintChange() {
        super();
    }
    
    public void printA(){
        lock.lock();
        try{
           while(num % 3 != 1){
                this.printA.await();
           }
           System.out.println("-------------A---------------");
           num++;
           this.printB.signal();           
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    
    public void printB(){
        lock.lock();
        try{
           while(num % 3 != 2){
                this.printB.await();
           }
           System.out.println("-------------B---------------");
           num++;
           this.printC.signal();           
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    
    public void printC(){
        lock.lock();
        try{
           while(num % 3 != 0){
                this.printC.await();
           }
           System.out.println("-------------C---------------");
           num++;
           this.printA.signal();           
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    
    public static void main(String args[]) {
        final PrintChange pc = new PrintChange();
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
    
    public static int[] sort(int[] array){
        int[] tmpArray = Arrays.copyOf(array, 10); //前面10个
        Arrays.sort(tmpArray);//排序
        int i = 10;
        while(i< array.length){ //从第11个开始遍历
            int outer = array[i];
            int j  = 0;
            loop2:
            while(j < 10){
                if(outer > tmpArray[j]){
                    for(int k = j + 1; k<10; k++){
                        tmpArray[k] = tmpArray[k-1]; //临时数组依次向后移动
                    }
                    tmpArray[j] = outer; //在该位置插入这数字
                    break loop2;
                }
                j++;
            }
            i++;
        }
        return tmpArray;
        
    }
}

