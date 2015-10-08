/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter9;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-22 陈强新建
 */
public class Practice2 extends abstractcla {
    
    int flag = 1;
    
    @Override
    void print() {
        System.out.println(this.flag);
    }
    
    /**
     * 父类
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
