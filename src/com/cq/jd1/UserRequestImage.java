/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.jd1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-8
 * @version : 1.0
 */
public class UserRequestImage {
    
    public UserRequestImage() {
        super();
    }
    
    public static void main(String args[]) {
        System.out.println("----------now begin to gen user reuqest!----------------");
        BlockingQueue<Job> bl = new ArrayBlockingQueue<Job>(1024);  
        Thread t1 = new Thread(new PutOp(bl));
        t1.start();
        int i =0;
        while(i<3){
            new Thread(new Eat(bl, "" + i)).start();
            i++;       
        }      
    }
}

class Eat implements Runnable{   
    BlockingQueue<Job> qu ;  
    String name = "";
    Eat(BlockingQueue<Job> bl, String _name){       
        name= _name;
        this.qu = bl;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            Job job = null;
            try {
                job = qu.take();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
           System.out.println(this.toString() + " " + job.idx);      
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
        }
    }
    
    @Override
    public String toString(){
        return "Eat thread# " + name; 
    }
    
}

class Job{
    int idx;
    
    Job(int _idx){
        idx = _idx;
    }
    
}

class PutOp implements Runnable{

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    BlockingQueue<Job> qu ;
    
    PutOp(BlockingQueue<Job> que){
        this.qu = que;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int idx = 1;
        while(true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           if(!qu.offer(new Job(idx++))){
                 System.out.println("the queue is full");
           }        
            
        }
      
    }
    
    
    
}
