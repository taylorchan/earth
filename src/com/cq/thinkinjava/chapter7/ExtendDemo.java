/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter7;

import java.io.IOException;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-21 陈强新建
 */
class ExtendDemo {
}

class A extends C {
    
    public static void main(String args[]) {
        new A().doh("ssss");
    }
    
    public A(int i) {// 注意：此处会调用父类的默认无参构造器，若父类中无默认构造器或者默认构造器不可见，
        // 则需要显示的调用有参数的构造器
        super(i);
        System.out.println("B's constructor");
    }
    
    public A() {// 注意：此处会调用父类的默认无参构造器，若父类中无默认构造器或者默认构造器不可见，
        // 则需要显示的调用有参数的构造器
        super(2);
        System.out.println("B's constructor");
    }
    
    public String doh(String c) {// 子类对父类方法的重载(overload,方法名同，返回类型同，参数不同)
        return "String";
    }
    
    @Override
    // 子类对父类方法的重写或者叫覆盖(方法名称，参数列表返回值类型都要相同)
    public void doh(char c) {
        System.out.println("supress's doh ");
    }
    
    public final void f() {// 父类中的方法为private不可见，此处不构成重写
        System.out.println("father's f()");
    }
    
    @Override
    public void g() throws IOException {
        // 1.重写只可以保留或者扩大可见性
        // 2.重写只可以抛出原来的异常或者原来异常的的子类
        System.out.println("father's g()");
    }
    
}

class B {
    
    public B() {
        System.out.println("B's constructor");
    }
}

class C {
    
    public C(int i) {
        System.out.println("B's constructor");
    }
    
    public void doh(char c) {// 该方法被子类方法覆盖，若想防止，给方法加上final关键字，
        // 类中所有的private的方法都隐式的加上了final修饰，所以对private方法加上final无实际意义
        System.out.println("super's doh ");
    }
    
    public double doh(double c) {
        return 1f;
    }
    
    private final void f() {
        System.out.println("c's f()");
    }
    
    protected void g() throws Exception {
        System.out.println("c's g()");
    }
}
