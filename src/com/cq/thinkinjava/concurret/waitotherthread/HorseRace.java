/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.waitotherthread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-7-27
 * @version : 1.0
 */
class Horse implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    
    /**
     * 
     */
    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    public synchronized int getStrides(){
        return strides;
    }
    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this) {
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        }catch(InterruptedException e){
            
        }catch(BrokenBarrierException e){
            throw new RuntimeException(e);
        }
       
    }
   public String toString(){
       return "Horse " + id + "  ";
   } 
   public String tracks(){
       StringBuilder sb = new StringBuilder();
       for(int i = 0;i<getStrides();i++)
           sb.append("*");
       sb.append(id);
       return sb.toString();
   }
}
public class HorseRace{
    static final int FINISH_LINE  = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    
    /**
     * @throws InterruptedException 
     * 
     */
    public HorseRace(int nHorse,final int pause)  {
        barrier = new CyclicBarrier(nHorse, new Runnable(){
            
            
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<FINISH_LINE;i++)
                    sb.append('=');
                System.out.println(sb);    
                
                for(Horse horse: horses){
                    System.out.println(horse.tracks());
                }
                for(Horse horse: horses){
                    if(horse.getStrides() >= FINISH_LINE){
                        System.out.println(horse+" win!");
                        exec.shutdown();
                        return ;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                   System.out.println("barrier-action sleep interrupt");
                }
            }
        });
        
    for(int i = 0;i<nHorse;i++){
        Horse horse = new Horse(barrier);
        horses.add(horse);
        exec.execute(horse);
    }
    
    }
    public static void main(String[] args) {
        int n = 7;
        int pause = 200;
        new HorseRace(n, pause);
        
    }
}
