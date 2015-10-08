/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.arithmeticinjava.p4;

import java.io.Serializable;


/**
 * 基于链表实现的优先级queue
 * 迭代器模式的实现
 * 
 * @author: qiang.chen
 * @since: 2012-7-4
 * @version : 1.0
 * @param <T>
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class PriorityQueue<T extends Comparable<T>> implements QueueIterable<T> {
    
    private static class Entry<T extends Comparable<T>>{
        
        Entry() {
        }
        
        T data;
        
        Entry next;
        
        Entry pre;
    }
    
    private final Entry front;
    
    private final Entry rear;
    
    private int size = 0;
    
    /**
     * 
     */
    public PriorityQueue() {
        front = new Entry();
        rear = new Entry();
        front.next = rear;
        rear.pre = front;
    }
    
    /**
     * @return
     */
    public int getSize() {
        return size;
    }
    
    /**
     * 插入一个元素
     * 
     * @param t
     */
    public void insert(T t) {
        Entry ele = new Entry();
        ele.data = t;
        Entry curEntry = front;
        while (true) {
            if (curEntry.pre == null) {
                curEntry = curEntry.next;
                continue;
            }
            if (curEntry.next == null || curEntry.data.compareTo(t) > 0) {// 新插入的值小于该节点的值，插在该节点的前面
                Entry preEntry = curEntry.pre;
                ele.next = curEntry;
                curEntry.pre = ele;
                preEntry.next = ele;
                ele.pre = preEntry;
                size++;
                break;
            }
            curEntry = curEntry.next;
        }
    }
    
    public int size() {
        return size;
    }
    
    /**
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    public T remove() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Entry toRemoveEle = front.next;
        front.next = toRemoveEle.next;
        toRemoveEle.next.pre = front;
        size--;
        return (T) toRemoveEle.data;
    }
    
    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return (T) front.next.data;
    }
    
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.insert(5);
        q.insert(2);
        QueueIterator iterator = q.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
    /**
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public QueueIterator<T> iterator() {
        // 
        return new QueueIterator<T>() {
             Entry cur = front;
            @Override
            public boolean hasPre() {
                // TODO Auto-generated method stub
                return (cur.pre!=front && cur.pre!=null) ;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T pre() {
                // TODO Auto-generated method stub
                cur = cur.pre;
                return (T) cur.data;
            }

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return (cur.next!=rear && cur.next!=null);
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                // TODO Auto-generated method stub
                cur = cur.next;
                return (T) cur.data;
            }
            @Override
            public void remove() {//不能随意删除
                throw new UnsupportedOperationException();
            }
        };
    }
}
