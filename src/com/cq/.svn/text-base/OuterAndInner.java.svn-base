/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

/**
 * 1。外部类可以访问内部类的任何成员 2.内部类中不能有静态成员
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-10-27 陈强新建
 */
public class OuterAndInner {
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        
        Outer out = new Outer();
        // 如何创建outer的inner，需要先创建外部类的对象才行
        Outer.Inner1 in1 = out.new Inner1();
        in1.show();
        out.show();
        out.getInner();
        
        Outer2 out2 = new Outer2();
        out2.getInner();
        out2.innerInstance.sayHello();
    }
}

class Outer {
    
    private final int x = 1;
    
    /**
     * Outer类的非静态内部类
     * 
     * @author 陈强
     * @since 1.0
     * @version 2011-10-28 陈强新建
     */
    class Inner1 {
        
        private final int x = 4;
        
        /**
         * 如何访问外部类和内部类的成员变量
         */
        public void show() {
            System.out.println("Outer X:" + Outer.this.x);
            System.out.println("Inner X:" + this.x);
            
        }
        
    }
    
    /**
     * 定义 局部内部类,在局部块中定义的类，其作用域只在定义的块中有效, 但是创建的局部内部类的对象不会随着语句块的结束而消亡，若是在语句块结束后，
     * 调用了局部内部类对象中访问普通局部变量的方法就要出问题，因为此时要访问的局部变量不存在了（ps:final 修饰的变量存在哪里？）
     * final的局部变量在语句块结束后不会消失，还会长期存在，可以在后面被继续访问到
     */
    public void getInner() {
        final int x = 100;
        /**
         * 局部内部类
         * 
         * @author 陈强
         * @since 1.0
         * @version 2011-10-28 陈强新建
         */
        class Inner2 {
            
            /**
             * 访问局部变量的时候，局部变量需要定义为 final 方可被访问
             */
            public void show() {
                System.out.println("局部变量访问：" + x);
            }
        }
        Inner2 in = new Inner2();
        in.show();
    }
    
    /**
     * 外部类中访问内部类的成员
     */
    public void show() {
        
        Inner1 in = new Inner1();
        System.out.println(in.x);
        
    }
    
    /**
     * @return 获取 x属性值
     */
    public int getX() {
        return x;
    }
}

/**
 * 局部内部类只在局部有效，外面不可能用局部内部类的引用指向其对象，可定义一个接口
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-10-28 陈强新建
 */
class Outer2 {
    
    /**
     * 定义内部接口
     */
    interface ForInner {
        
        void sayHello();
    }
    
    ForInner innerInstance = null;
    
    public void getInner() {
        
        /**
         * 局部内部类
         * 
         * @author 陈强
         * @since 1.0
         * @version 2011-10-28 陈强新建
         */
        class Inner2 implements ForInner {
            
            /**
             * @see com.cq.Outer2.ForInner#sayHello()
             */
            @Override
            public void sayHello() {
                System.out.println("我是局部内部类对象，我的命长着呢！！");
                
            }
        }
        innerInstance = new Inner2();
    }
}
