/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

/**
 * 封装类测试类， 1。 封装类一旦创建，其内容永不改变，若是需要新内容，只能再创建新对象2.封装类均为final
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-10-27 陈强新建
 */
public class Fengzhuang {
    
    /**
     * 
     */
    public static void main(String args[]) {
        // java中的char只能对应''.不能用"",char只能是一个字符
        Character c = new Character('c');
        //
        Boolean b1 = new Boolean(false);
        Boolean b2 = new Boolean("False");
        // b3的值为false
        Boolean b3 = new Boolean("sgdsadsa!!");
        // Exception in thread "main" java.lang.NumberFormatException: For input
        // string: "fdfdf"
        try {
            Float f1 = new Float("fdfdf");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // 构造器参数为float或者double
        Float f2 = new Float(12.56f);
        Float f3 = new Float(12.56);
        
        Integer i = new Integer(3);
        
        Integer i3 = new Integer("3");
        Integer i2 = new Integer('3');
        // java.lang.NumberFormatException: For input string: "qqwww"
        // Integer i4 = new Integer("qqwww");
        System.out.println(i2);
        
        // Double d = new Double(12 % 0);
        // if (d.isNaN()) {// 无穷大的判定
        
        // }
        // System.out.println(d);
        
        Integer i5 = 2;
        Integer i6 = 2;
        System.out.println(i5 == i6);// true
        
        Integer i7 = 234;
        Integer i8 = 234;
        System.out.println(i7 == i8);// false
        
    }
}
