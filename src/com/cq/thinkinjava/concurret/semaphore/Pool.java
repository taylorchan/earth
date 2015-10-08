/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


/**
 * pool的简单实现
 * @author:   qiang.chen
 * @since:    2012-10-23
 * @version : 1.0
 */
public class Pool<T> {
    private int size;
    private List<T> items;
    //跟踪借出的对象
    private volatile boolean[] checkedOut;
    //信号量
    private Semaphore available;
    public Pool(Class<T> classObject, int size) {
      this.size = size;
      checkedOut = new boolean[size];
      items = new ArrayList<T>(size);
      available = new Semaphore(size, true);
      // Load pool with objects that can be checked out:
      for(int i = 0; i < size; ++i)
        try {
          // Assumes a default constructor:池初始化的时候加载及初始化对象
          items.add(classObject.newInstance());
        } catch(Exception e) {
          throw new RuntimeException(e);
        }
    }
    /**
     * 通过此方法获取一个对象,当不存在可用对象的时候，线程会在此处阻塞，直到有对象可用。设计池的好方法
     *
     * @return
     * @throws InterruptedException
     */
    public T checkOut() throws InterruptedException {
      available.acquire();
      return getItem();
    }
    public void checkIn(T x) {
      if(releaseItem(x))
        available.release();
    }
    private synchronized T getItem() {
      for(int i = 0; i < size; ++i)
        if(!checkedOut[i]) {
          checkedOut[i] = true;
          return items.get(i);
        }
      return null; // Semaphore prevents reaching here
    }
    private synchronized boolean releaseItem(T item) {
      int index = items.indexOf(item);
      if(index == -1) return false; // Not in the list
      if(checkedOut[index]) {
        checkedOut[index] = false;
        return true;
      }
      return false; // Wasn't checked out
    }
  } ///:~
