/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

/**
 * @author 陈强
 * @since 1.0
 * @version 2011-9-28 陈强新建
 */

interface Target1 {// 客户端的的需求接口

    int add(int a, int b);
}

class Adaptee {
    
    public int addOpe(int a, int b) {
        return a + b;
    }
}

class Adapter1 extends Adaptee implements Target1 {
    
    public int add(int a, int b) {
        return addOpe(a, b);
    }
}

// 以下为对象适配器,通过多态实现
class Target {
    
    public int add(int a, int b) {
        return 0;
    }
}

class Adapter extends Target {
    
    Adaptee adaptee;
    
    Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public int add(int a, int b) {
        return adaptee.addOpe(a, b);
    }
}
