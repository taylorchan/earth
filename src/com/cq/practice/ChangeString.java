/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-13 ��ǿ�½�
 */
public class ChangeString {
    
    public static void changeStr(List<String> str) {
        str.add("1");
    }
    
    public static void main(String args[]) {
        List ay = new ArrayList<String>();
        ChangeString.changeStr(ay);
        System.out.println(ay);
        
    }
}
