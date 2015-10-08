/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/

package com.cq.thinkinjava.concurret.semaphore;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author: qiang.chen
 * @since: 2012-10-23
 * @version : 1.0
 */
class CheckoutTask<T> implements Runnable {
    
    private static int counter = 0;
    
    private final int id = counter++;
    
    private Pool<T> pool;
    
    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }
    
    public void run() {
        try {
            T item = pool.checkOut();
            print(this + "checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            print(this + "checking in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            // Acceptable way to terminate
        }
    }
    
    public String toString() {
        return "CheckoutTask " + id + " ";
    }
}

public class SemaphoreDemo {
    
    final static int SIZE = 25;
    
    public static void main(String[] args) throws Exception {
        final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++)
            exec.execute(new CheckoutTask<Fat>(pool));
        print("All CheckoutTasks created");
        List<Fat> list = new ArrayList<Fat>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkOut();
            printnb(i + ": main() thread checked out ");
            f.operation();
            list.add(f);
        }
        Future<?> blocked = exec.submit(new Runnable() {
            
            public void run() {
                try {
                    // Semaphore prevents additional checkout,
                    // so call is blocked:
                    System.out.println("block is attempt to get object!");
                    pool.checkOut();
                    System.out.println("block has get object!");
                } catch (InterruptedException e) {
                    print("checkOut() Interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        System.out.println("main thread sleep finished");
        pool.checkIn(list.get(0));
        list.remove(0);
        //blocked.cancel(true); // Break out of blocked call
        print("Checking in objects in " + list);
        for (Fat f : list)
            pool.checkIn(f);
        for (Fat f : list)
            pool.checkIn(f); // Second checkIn ignored
        exec.shutdown();
    }
}
