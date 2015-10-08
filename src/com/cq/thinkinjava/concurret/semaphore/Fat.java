/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.semaphore;


/**
 * 大对象，创建代价较高
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
public class Fat {
    private volatile double d; // Prevent optimization
    private static int counter = 0;
    private final int id = counter++;
    public Fat() {
      // Expensive, interruptible operation:
      for(int i = 1; i < 10000; i++) {
        d += (Math.PI + Math.E) / (double)i;
      }
    }
    public void operation() { System.out.println(this); }
    public String toString() { return "Fat id: " + id; }
}