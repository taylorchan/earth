/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.chapter16;

import arrays.BerylliumSphere;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-1 ��ǿ�½�
 */
public class Practice1 {
    
    public static void main(String args[]) {
        char[] ch = new char[2];
        int[] ih = new int[2];
        for (int i = 0; i < ih.length; i++) {
            System.out.println(ih[i]);
        }
        new Practice1().method(new BerylliumSphere[] { new BerylliumSphere() });
        
    }
    
    void method(BerylliumSphere b[]) {
        
    }
}
