/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter15;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-29 陈强新建
 */
public class Practice5 {
    
    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);
    }
}

/**
 * 内部链式存储机制， 原理为将stack中保存的元素视为一个节点，每个节点里面保存两个成员，一个为数据成员（泛型）， 一个为下一个成员的引用（节点数据类型）
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-2-29 陈强新建
 */
class LinkedStack<T> {
    
    private class Node<T> {
        
        T item;
        
        Node<T> next;
        
        Node() {
            item = null;
            next = null;
        }
        
        Node(T item1, Node<T> next) {
            this.item = item1;
            this.next = next;
        }
        
        boolean end() {
            return item == null && next == null;
        }
    }
    
    // 末端哨兵，实际元素个数比插入的元素多一个
    private Node top = new Node(); // End sentinel
    
    public void push(T item) {
        top = new Node<T>(item, top);
    }
    
    public T pop() {
        T result = (T) top.item;
        if (!top.end())
            top = top.next;
        return result;
    }
    
} /*
   * Output: stun! on Phasers
   */// :~
