/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq;

import java.io.UnsupportedEncodingException;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2011-10-27 ��ǿ�½�
 */
public class StringTest {
    
    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String args[]) throws UnsupportedEncodingException {
        String a = "Programming";  
        String b = new String("Programming");  
        String c = "Program" + "ming";  
          
        System.out.println(a == b);  
        System.out.println(a == c);  
        System.out.println(a.equals(b));  
        System.out.println(a.equals(c));  
        System.out.println(a.intern() == b.intern());  
    }
}
