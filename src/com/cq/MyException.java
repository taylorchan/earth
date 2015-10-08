/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq;

/**
 * �Զ����쳣��
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2011-10-27 ��ǿ�½�
 */
public class MyException extends Exception {
    
    /***/
    private static final long serialVersionUID = -7787300945653793851L;
    
    /**
     * 
     */
    public MyException() {
        
    }
    
    /**
     * @param msg
     */
    public MyException(String msg) {
        super(msg);
    }
    
    public static void main(String args[]) {
        MyException ex = new MyException("test yichang");
        System.out.println(ex.toString());
        System.out.println(ex.getMessage());
    }
    
    /**
     * �׳��Զ����쳣���Զ����׳������쳣�ĳ���������, ���˾���һ������runtimeException �ȽϺ���
     * 
     * @param grade
     * @return
     * @throws MyException
     */
    public static int findGrade(double grade) throws MyException {
        if (grade > 0 || grade <= 100) {
            return 1;
        } else {
            throw new MyException("û�д��������" + grade);
        }
    }
}
