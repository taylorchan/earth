/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.mindview.util.Countries;
import net.mindview.util.Print;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-6 ��ǿ�½�
 */
public class Practice1 {
    
    public static void main(String args[]) {
        List ls = new ArrayList<String>(Countries.names(10));
        Collections.sort(ls);
        Print.print(ls);
        Collections.shuffle(ls);
        Print.print("after sort");
        Print.print(ls);
    }
}
