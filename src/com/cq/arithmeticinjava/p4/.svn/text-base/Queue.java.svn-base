/**2012-7-2**/

package com.cq.arithmeticinjava.p4;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 循环队列，解决假溢出的问题，提高效率
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-7-2 陈强新建
 * @param <E>
 */
public class Queue<E> {
    
    private static final int INITIALVALUE = 10;
    
    private int maxSize;
    
    private E[] ele;
    
    /**
     * 队头指针
     */
    private int front;
    
    /**
     * 队尾指针
     */
    private int rear;
    
    private int itemLen;
    
    /**
     * @param size
     */
    public Queue(int size) {
        @SuppressWarnings("unchecked")
        E[] newInstance = (E[]) new Object[size];
        ele = newInstance;
        this.itemLen = 0;
        this.maxSize = size;
        this.front = 0;
        this.rear = -1;
    }
    
    /**
     * 
     */
    public Queue() {
        @SuppressWarnings("unchecked")
        E[] newInstance = (E[]) new Object[INITIALVALUE];
        ele = newInstance;
        this.itemLen = 0;
        this.maxSize = INITIALVALUE;
        this.front = 0;
        this.rear = -1;
    }
    
    /**
     * @param e
     */
    public void insert2(E e) {
        checkVolumn();
        if (rear + 1 == itemLen) {
            rear = -1;
        }
        ele[++rear] = e;
        itemLen++;
    }
    
    /**
     * @param e
     */
    public void insert(E e) {
        checkVolumn();
        ele[++rear % maxSize] = e;
        itemLen++;
    }
    
    /**
     * @return
     */
    public E remove() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        // 返回值
        E e = ele[front];
        ele[front] = null;
        front = (front + 1) % maxSize;
        itemLen--;
        return e;
    }
    
    /**
     * @return
     */
    public E peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        // 返回值
        return ele[front];
    }
    
    /**
     * @return
     */
    public int size() {
        return itemLen;
    }
    
    /**
     * @return
     */
    public boolean isFull() {
        return itemLen == maxSize;
    }
    
    /**
     * @return
     */
    public boolean isEmpty() {
        return itemLen == 0;
    }
    
    /**
     * 容量检查
     */
    private void checkVolumn() {
        if (isFull()) {// 扩容
            int newSize = maxSize * 2;
            E[] newInstance = Arrays.copyOf(ele, newSize);
            this.ele = newInstance;
            this.maxSize = newSize;
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        circleCount(13);
    }
    /**
     * 模拟n个人围成一圈报数，依次报1,2.报到1的出列
     * Linedlist为java中最常用的queue实现
     * @param n
     */
    public static void circleCount(int n){
       java.util.Queue<Integer> q = new LinkedList <Integer>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int status = 1;
        int temp;
        while(!(q.isEmpty())){
            temp = q.remove();
            if(status == 1){
                System.out.println(temp);
                status = 2;
            }else{
                q.add(temp);
                status = 1 ;
            }
        }
    }
}
