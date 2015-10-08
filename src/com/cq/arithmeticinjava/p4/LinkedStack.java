/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.p4;

import java.util.Iterator;


/**
 * 链式栈的实现，不带头
 * @author: qiang.chen
 * @since:    2012-7-5
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class LinkedStack <T> implements Iterable<T>{
    private static class Entry<T>{
        Entry(T t){
            this.data = t;
        }
        T data;
        Entry next;
    }
    private Entry top;
    private int size;
    public LinkedStack(){
        top = null;
    }
    /**
     * 
     *
     * @param t
     * @return
     */
    @SuppressWarnings("unchecked")
    public T push(T t){
        Entry e = new Entry<T>(t);
        Entry orignalTop = top;
        top = e;
        top.next = orignalTop;
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
        Entry orignalTop = top;
        Entry newTop = top.next;
        top = newTop;
        return (T) orignalTop.data;
        
    }
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return top == null;
    }
    
    public void emptyStack(){
        this.top = null;
    }
    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<String>();
        ls.push("kfkdd");
        ls.push("fdfdfd");
        while(!ls.isEmpty()){
            System.out.println(ls.pop());
        }
        System.out.println(dToN(1348L,8)); 
        
        System.out.println(getInputString("this is prefix msg ddddd@hello word!!#fdfdfd"));
    }
    public String toString(){
        Entry cur = top;
        StringBuilder sb = new StringBuilder();
        while(cur!=null){
            sb.append(cur.data);
            cur = cur.next;
        }
        return sb.toString();
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
                return e != null && e.next!=null;
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
    public static String dToN(long d,int n){
        long re = 0L;
        LinkedStack<Long> stack = new LinkedStack<Long>();
        while(d >=n){
            re = d%n;
            stack.push(re);
            d = d/n;
        }
        stack.push(d);
        return stack.toString();
    }
    public static String getInputString(String inputString){
        assert inputString != null ;
        char[] array = inputString.toCharArray();
        LinkedStack<Character> stack = new LinkedStack<Character>();
        for (char c : array) {
            switch(c){
                case '#' :stack.pop();break;
                case '@': stack.emptyStack();break;
                default: stack.push(c);
            }
        }
        return stack.toString();
    }
}
