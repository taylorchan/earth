/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-29 ��ǿ�½�
 */
public class Practice2 {
    
    public static void main(String args[]) {
        List[] obj = { new ArrayList(), new ArrayList(), new ArrayList() };
        Holder<List> h = new Holder<List>(obj);
        List[] ls = h.getLst();
        for (int i = 0; i < ls.length; i++) {
            List list = ls[i];
            System.out.println(list);
            
        }
    }
}

class Holder<T> {
    
    private T[] lst;
    
    public Holder(T[] t) {
        this.lst = t;
    }
    
    public void setLst(T[] t) {
        this.lst = t;
    }
    
    /**
     * @return ��ȡ lst����ֵ
     */
    public T[] getLst() {
        return lst;
    }
}
