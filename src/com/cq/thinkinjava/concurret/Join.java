/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret;

import java.util.concurrent.TimeUnit;


/**
 * join的使用
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class Join {
    
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("sleepy", 1500);
        Sleeper grumpy = new Sleeper("grumpy", 1500);
        
        Joiner dopey = new Joiner("dopey", sleepy);
        Joiner doc = new Joiner("doc", grumpy);
        grumpy.interrupt();
    }
    
}
class Sleeper extends Thread{
    private int duration;
    
    /**
     * 
     */
    public Sleeper(String name,int duration) {
        super(name);
        this.duration = duration;
        start();
    }
    @Override
    public void run(){
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {//interrupted is false? why
            System.out.println(getName()+" is interrupted!   Interrupted: "+isInterrupted());
        }
        System.out.println(getName()+" has finished!");
    }
}

class Joiner extends Thread{
    
    private final Sleeper sleeper;
    

    /**
     * 
     */
    public Joiner(String name,Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {//本线程将在线程sleeper执行完成后才开始执行
            sleeper.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(getName()+" join completed!");
    }

    /**
     * @return the sleeper
     */
    public Sleeper getSleeper() {
        return sleeper;
    }
}
