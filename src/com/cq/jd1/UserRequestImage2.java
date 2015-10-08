/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.jd1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-8
 * @version : 1.0
 */
public class UserRequestImage2 {
    
    public UserRequestImage2() {
        super();
    }
    
    public static void main(String args[]) {
        System.out.println("----------now begin to gen user reuqest!----------------");
        WorkerPool wp = new WorkerPool();
        Thread t1 = new Thread(new PutOp2(wp));
        t1.start();     
    }
}

class PutOp2 implements Runnable{
    
    private WorkerPoolI pool;
    
    PutOp2(WorkerPoolI pool){
        this.pool = pool;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int idx = 1;
        while(true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pool.nextWorker().registerJob(new Job2(idx++));          
        }      
    }    
}


interface WorkerPoolI{
    int WORKER_NUM = 4;    
    Worker nextWorker();
}

class WorkerPool implements WorkerPoolI{    
    Worker[] worker  = new Worker[WORKER_NUM];
    AtomicInteger idx = new AtomicInteger(0);
    WorkerPool(){
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i< WORKER_NUM; i++){
            worker[i] = new Worker(es, "worker#" + i);
        }
    }

    /* (non-Javadoc)
     * @see com.cq.jd1.WorkerPoolI#nextWorker()
     */
    @Override
    public Worker nextWorker() {
        // TODO Auto-generated method stub
        return this.worker[idx.getAndIncrement() % worker.length];
    }
    
}
class Worker implements Runnable{   
    public static final int  CA = 2<<10;
    private final BlockingQueue<Job2> qu = new ArrayBlockingQueue<Job2>(CA) ;  
    private volatile boolean startFlag = false;    
    private String name = "";
    private ExecutorService es;    
    
    Worker(ExecutorService _es, String _name){       
        name= _name;  
        es = _es;     
    }
    
    public void registerJob(Job2 job){
        if(!startFlag){
            es.execute(this);
        }
        System.out.println("job#" + job.idx + " is append to " + this.name);
        boolean f = qu.offer(job);   
        if(!f){
            ////
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            Job2 job = null;
            try {
                job = qu.take();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
           job.run();           
        }
    }    
}

class Job2 implements Runnable{
    int idx;
    
    Job2(int _idx){
        idx = _idx;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
       System.out.println("job#" + idx + " is executed");   
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }    
}


