/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.practice;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-27 ��ǿ�½�
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
