/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.p5;


/**
 * 自实现双向链表
 * @author: qiang.chen
 * @since:    2012-7-5
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class DoubleLinkedList<E> {
    
    private static class Entry<E>{
        E data;
        Entry next;
        Entry pre;
        public String toString(){
            return data.toString();
        }
    }
    
    private Entry next;
    
    private Entry pre;
    
    private Entry first;
    
    private Entry last;
    public DoubleLinkedList(){
    }
    public String toString(){
        Entry cur = first;
        StringBuffer sb = new StringBuffer();
        while(cur!=null){
            sb.append(cur.toString()) ;
            sb.append(", ");
            cur = cur.next;
        }
        return sb.toString();
    }
    /**
     * 在表头插入数据
     *
     * @param t
     */
    public void insertInFirstPos(E t){
        Entry e = new Entry<E>();
        e.data = t;
        if(isEmpty()){
            first = e;
            last = e;
        }else{
            e.next = first;
            first.pre = e;
            first = e;
        }
    }
    public boolean isEmpty(){
        return first == null;
    }
    /**
     * 
     *在表尾部插入数据
     * @param e
     */
    public void insertInLastPos(E e){
        Entry ele = new Entry<E>();
        ele.data = e;
        if(isEmpty()){
            first = ele;
            last = ele;
        }else{
            last.next = ele;
            ele.pre  = last;
            last = ele;
        }
    }
    /**
     * insert newvalue after e in list
     *
     * @param e
     * @param newValue
     * @return
     */
    public boolean insertAfter(E e,E newValue){
        Entry cur = first;
        Entry curNext = null;
        Entry newEle = null;
        boolean flag = false;
        while(cur != null){
            if(cur.data.equals(e)){//找到插入点
                newEle = new Entry<E>();
                newEle.data = newValue;
                if(cur!=last){
                    curNext = cur.next;
                    newEle.next = curNext;
                    curNext.pre = newEle;
                }else{
                    last = newEle;
                }
                cur.next = newEle;
                newEle.pre = cur;
                flag = true;
                break;
            }
            cur  = cur.next;
        }
        return flag;
    }
    /**
     * 
     *
     * @param e
     * @return
     */
    public void delete(E e){
        boolean flag = false;
        if(isEmpty()){
            throw new NullPointerException();
        }
        Entry cur = first;
        Entry curNext = null;
        Entry curPre = null;
        while(cur != null){
            if(cur.data.equals(e)){
                curPre = cur.pre;
                curNext = cur.next;
                if(cur == first){
                    first = curNext;
                    curNext.pre = null;
                    cur = first;
                }else if(cur == last){
                    last = curPre;
                    curPre.next = null;
                    cur = last;
                }else{
                    curPre.next = curNext;
                    curNext.pre = curPre;
                }
            }
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        DoubleLinkedList<String> dbls = new DoubleLinkedList<String>();
        System.out.println(dbls.isEmpty()) ;
        System.out.println(dbls.insertAfter("sfsf", "fdfd"));
        dbls.insertInLastPos("insert in lastPos");
        dbls.insertInFirstPos("insert in firstPos");
        dbls.insertAfter("insert in lastPos", "insert afer last");
        System.out.println(dbls);
        dbls.delete("fdfd");
        dbls.delete("insert in firstPos");
        dbls.delete("insert afer last");
        System.out.println(dbls);
    }
}
