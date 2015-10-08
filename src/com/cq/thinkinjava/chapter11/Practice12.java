/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-23 ��ǿ�½�
 */
public class Practice12 {
    
    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        List<Integer> lst1 = new ArrayList<Integer>(10);
        
        for (int i = 0; i < 10; i++) {
            lst1.add(i);
        }
        ListIterator it1 = lst1.listIterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        // while (it1.hasPrevious()) {
        // lst2.add((Integer) it1.previous());
        // }
        List<Integer> lst2 = new ArrayList<Integer>();
        lst2.addAll(lst1);
        System.out.println("lst1 bianliwanc:" + lst1);
        System.out.println("lst2 init:" + lst2);
        // System.out.println("lst1 iterator index:" + it1.previousIndex());
        
        ListIterator it2 = lst2.listIterator();
        while (it1.hasPrevious()) {
            it2.next();
            int i = (Integer) it1.previous();
            it2.set(i);
        }
        // ע��subListȡ����list�еĶ�����ԭlist�еĶ���
        List<Integer> lst3 = lst2.subList(0, 1);
        lst3.set(0, 10);
        System.out.println(lst2);
    }
}
