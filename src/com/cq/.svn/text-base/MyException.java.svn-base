/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

/**
 * 自定义异常类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-10-27 陈强新建
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
     * 抛出自定义异常，自定义抛出此类异常的场景及条件, 个人觉得一般用在runtimeException 比较合适
     * 
     * @param grade
     * @return
     * @throws MyException
     */
    public static int findGrade(double grade) throws MyException {
        if (grade > 0 || grade <= 100) {
            return 1;
        } else {
            throw new MyException("没有此类分数：" + grade);
        }
    }
}
