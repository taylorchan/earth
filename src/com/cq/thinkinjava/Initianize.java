/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2011-11-17 ��ǿ�½�
 */
public class Initianize {
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        System.out.println("main" + Initianize.print);
    }
    
    static String print;
    static {
        print = "fdfdf";
        System.out.println(print);
    }
}
