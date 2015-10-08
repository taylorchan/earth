/**2012-6-27**/

package com.cq.effectivejava.p67;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-27 陈强新建
 */
public class Observable<E> {
    
    private final List<Observer<E>> observers = new ArrayList<Observer<E>>();
    
    private final Set<E> innerSet;
    
    /**
     * @param set
     */
    public Observable(Set<E> set) {
        this.innerSet = set;
    }
    
    public void addObserver(Observer<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }
    
    public void removeObserver(Observer<E> observer) {
        synchronized (observers) {
            observers.remove(observer);
        }
    }
    
    /**
     * 不能再同步块中调用外来的方法
     * 
     * @param element
     */
    private void notifyElementAdded(E element) {
        // 这种写法并不好
        // synchronized (observers) {// 防止并发的修改
        // for (Observer<E> observer : observers) {
        // observer.added(this, element);
        // }
        // }
        // 用这种写法较好
        List<Observer<E>> snapshot = null;
        synchronized (this.observers) {
            snapshot = new ArrayList<Observer<E>>(observers);
        }
        for (Observer<E> observer : snapshot) {// 目的是将外来的方法移出同步块，在同步区域做尽量少的事情
            observer.added(this, element);
        }
    }
    
    /**
     * 添加了元素，通知监视者
     * 
     * @param element
     * @return
     */
    public boolean add(E element) {
        boolean flag = this.innerSet.add(element);
        notifyElementAdded(element);
        return flag;
    }
    
    public static void main(String[] args) {
        Observable<Integer> obserable = new Observable<Integer>(new HashSet<Integer>());
        obserable.addObserver(new Observer<Integer>() {
            
            @Override
            public void added(Observable<Integer> observable, Integer element) {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                System.out.println(element);
                if (element == 23) {
                    observable.removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            obserable.add(i);
        }
        
        obserable.addObserver(new Observer<Integer>() {
            
            @Override
            public void added(final Observable<Integer> observable, Integer element) {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                System.out.println(element);
                if (element == 23) {
                    ExecutorService es = Executors.newSingleThreadExecutor();
                    final Observer<Integer> observer = this;
                    es.submit(new Runnable() {// 新开一个线程来做这件事情，由于原线程已经获得锁，
                        
                            // 所以新线程会一直等待，而原线程又等待新线程的结束，故而形成死锁
                            
                            @Override
                            public void run() {
                                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                                observable.removeObserver(observer);
                            }
                        });
                }
            }
        });
    }
}
