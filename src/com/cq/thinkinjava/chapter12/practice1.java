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
public class practice1 {
    
    public static void main(String args[]) {
        String strExc = null;
        try {
            strExc.substring(0, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            throw new Exception("test throw exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally carry out");
        }
        try {
            throw new MyException("test MyException!");
        } catch (MyException e) {
            System.out.println(e.getExcepMsg());
        }
        
    }
}

class MyException extends Exception {
    
    private String excepMsg;
    
    /**
     * @return ��ȡ excepMsg����ֵ
     */
    public String getExcepMsg() {
        return excepMsg;
    }
    
    /**
     * @param excepMsg ���� excepMsg ����ֵΪ����ֵ excepMsg
     */
    public void setExcepMsg(String excepMsg) {
        this.excepMsg = excepMsg;
    }
    
    public MyException(String msg) {
        super(msg);
        this.excepMsg = msg;
    }
}
