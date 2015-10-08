/******************************************************************************
 * Copyright (C) 2011 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.practice;

public abstract class AbstractP {
    
    abstract void draw();
    
    public AbstractP() {
        System.out.println("AbstractP：开始");
        draw();
        System.out.println("AbstractP：结束");
    }
    
    public static void main(String[] arg) {
        new Child(5);
    }
}

class Child extends AbstractP {
    
    private int i = 1;
    
    @Override
    void draw() {
        System.out.println("Child：draw()");
    }
    
    public Child(int a) {
        i = a;
        System.out.println("Child Init I: " + i);
    }
}
