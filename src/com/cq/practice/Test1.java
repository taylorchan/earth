/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.practice;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-27 陈强新建
 */
public class Test1 {
    
    static String arr[] = new String[10];
    
    public void myMethod(Object o) {
        System.out.println("My Object");
    }
    
    public void myMethod(String s) {
        System.out.println("My String");
    }
    
    public void myMethod(int s) {
        System.out.println("My int");
    }
    
    public static void main(String args[]) {
        // Test1 t = new Test1();
        // t.myMethod(null);
        System.out.println(arr[0]);
        System.out.println(arr.length);
        String a = "hello";
        ArrayList o = new ArrayList();
        LinkedList ls = new LinkedList();
        Test1 t = new Test1();
        int b = 65;
        long c = 54l;
        // char c = 'A';
    }
    
    public static final native int w();
}
