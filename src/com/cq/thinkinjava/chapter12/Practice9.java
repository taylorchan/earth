/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.chapter12;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-23 ��ǿ�½�
 */
public class Practice9 {
    
    public static void main(String args[]) {
        try {
            throw new Excep1("excep1");
            // throw new Excep2("excep2");
            // throw new Excep1("excep3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

@SuppressWarnings("serial")
class Excep1 extends Exception {
    
    String msg;
    
    Excep1(String msg) {
        super(msg);
        this.msg = msg;
    }
}

class Excep2 extends Exception {
    
    String msg;
    
    Excep2(String msg) {
        this.msg = msg;
    }
}

class Excep3 extends Exception {
    
    String msg;
    
    Excep3(String msg) {
        this.msg = msg;
    }
}
