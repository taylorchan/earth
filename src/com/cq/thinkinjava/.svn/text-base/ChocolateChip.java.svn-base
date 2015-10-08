/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava;

import com.cq.thinkinjava.desert.Cookie;
import com.cq.thinkinjava.desert.Eat;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-17 陈强新建
 */
class ChocolateChip extends Cookie implements Eat {
    
    public ChocolateChip() {
        // super("ddd");// 当父类的默认构造器不可见，必须显式的调用其他可见的构造器，至少要调用一个构造器
    }
    
    void chomp() {
        bite();
    }
    
    protected class suger {
        
        public suger() {
            System.out.println("ChocolateChip's suger!");
        }
        
    }
    
    public static void main(String args[]) {
        short i = 0;
        long l = 6;
        Integer a = 125;
        Integer b = 125;
        Integer c = 130;
        Integer d = 130;
        
        System.out.println(a == b);
        System.out.println(c == d);
        
        ChocolateChip e = new ChocolateChip();
    }
    
}
