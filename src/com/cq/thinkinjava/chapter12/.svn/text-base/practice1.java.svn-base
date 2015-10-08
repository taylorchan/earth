/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter12;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-23 陈强新建
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
     * @return 获取 excepMsg属性值
     */
    public String getExcepMsg() {
        return excepMsg;
    }
    
    /**
     * @param excepMsg 设置 excepMsg 属性值为参数值 excepMsg
     */
    public void setExcepMsg(String excepMsg) {
        this.excepMsg = excepMsg;
    }
    
    public MyException(String msg) {
        super(msg);
        this.excepMsg = msg;
    }
}
