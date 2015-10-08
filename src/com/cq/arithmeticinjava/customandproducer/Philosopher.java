/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.customandproducer;


/**
 * It is a simple representation of the need to allocate several resources 
 * among several processes in a deadlock- and starvation- free manner
 * @author:   taylor
 * @since:    2013-1-28
 * @version : 1.0
 */
public class Philosopher{
    State state = State.thinking;
    int num;
    /**
     * 
     */
    public Philosopher(int num) {
        this.num = num;
    }
    
    public static void main(String[] args) {
        Monitor m = new Monitor();
        for(int i = 0;i< 5;i++){
            m.philosophers[i] = new Philosopher(i);
        }
        Thread t = null;
        for (int i = 0; i < m.philosophers.length; i++) {
           t = new Thread(new Runner(m.philosophers[i],m));
           t.start();
        }
    }
}

class Runner implements Runnable{
    Philosopher p;
    Monitor m;
    /**
     * 
     */
    public Runner(Philosopher p,Monitor m) {
        this.p = p;
        this.m = m;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(true && p!=null){
            m.putUp(p.num);
            System.out.println("Philosopher " + p.num + "is eating,using sticks " + p.num + " with " + (p.num +4)%5);
            m.putDown(p.num);
        }
        
    }
    
}
enum State{
    thinking,
    eating,
    hungry;
}

class Monitor{
    Philosopher[] philosophers = new Philosopher[5];
    public void putUp(int i){
        philosophers[i].state = State.hungry;
        System.out.println("Philosopher " + i + "is hungry,ready to eat");
        test(i);
        synchronized (philosophers[i]) {
            if(philosophers[i].state != State.eating)
                try {
                    philosophers[i].wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
    
    public void putDown(int i){
        philosophers[i].state = State.thinking;
        System.out.println("Philosopher " + i + "finishes eating,falls into thinking");
        test((i+1)%5);
        test((i+4)%5);
  }
    
    
    private void test(int i){
        if( philosophers[(i +1)%5].state != State.eating &&  philosophers[(i +4)%5].state != State.eating &&  philosophers[i].state ==State.hungry){
            synchronized (philosophers[i]) {
                philosophers[i].state = State.eating;
                philosophers[i].notify();
            }
        }
    }
    
}
