/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.chapter9;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-22 ��ǿ�½�
 */
public class Practice2 extends abstractcla {
    
    int flag = 1;
    
    @Override
    void print() {
        System.out.println(this.flag);
    }
    
    /**
     * ����
     * 
     * @param args
     */
    public static void main(String args[]) {
        new Practice2().print();
    }
}

abstract class abstractcla {
    
    public abstractcla() {
        print();
    }
    
    abstract void print();
    
    void methodB() {
    }
}
