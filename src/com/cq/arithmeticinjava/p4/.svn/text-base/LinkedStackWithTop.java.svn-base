/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.p4;

import java.util.Iterator;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-10
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class LinkedStackWithTop<T> implements Iterable<T>{
    private static class Entry<T>{
        Entry(){
        }
        T data;
        Entry next;
    }
    private Entry top;
    private int size;
    public LinkedStackWithTop(){
        top = new Entry();
    }
    /**
     * 
     *
     * @param t
     * @return
     */
    @SuppressWarnings("unchecked")
    public T push(T t){
        Entry e = new Entry<T>();
        e.data = t;
        e.next =  top.next;
        top.next = e;
        size++;
        return t;
    }
    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public T pop(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        Entry topNext = top.next;
        Entry newTopNext = topNext.next;
        top.next = newTopNext;
        return (T) topNext.data;
    }
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return top.next == null;
    }
    public static void main(String[] args) {
        LinkedStackWithTop<String> ls = new LinkedStackWithTop<String>();
        ls.push("kfkdd");
        ls.push("fdfdfd");
        while(!ls.isEmpty()){
            System.out.println(ls.pop());
        }
    }
    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public Iterator iterator(){
        return new Iterator<T>() {
            Entry e = top;
            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return  e.next!=null;
            }

            @Override
            public T next() {
                // TODO Auto-generated method stub
                return (T) e.next.data;
            }

            @Override
            public void remove() {
                // TODO Auto-generated method stub
                
            }
        };
    }
 
}
