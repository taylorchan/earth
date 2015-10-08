/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-23 陈强新建
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
        // 注意subList取出的list中的对象还是原list中的对象
        List<Integer> lst3 = lst2.subList(0, 1);
        lst3.set(0, 10);
        System.out.println(lst2);
    }
}
