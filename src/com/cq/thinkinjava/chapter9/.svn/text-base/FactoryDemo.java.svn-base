/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter9;

/**
 * factory模式练习类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-2-22 陈强新建
 */
public class FactoryDemo {
    
    public static Cycle getCycle(CycleFactory factory) {
        return factory.getCycle();
    }
    
    public static void main(String args[]) {
        getCycle(new UnicycleFactory());
        getCycle(new BicycleFactory());
        getCycle(new TyicycleFactory());
        
    }
    
}

interface Cycle {
    
}

class Unicycle implements Cycle {
    
    Unicycle() {
        System.out.println("get Unicycle instance");
    }
    
}

class Bicycle implements Cycle {
    
    Bicycle() {
        System.out.println("get Bicycle instance");
    }
}

class Tricycle implements Cycle {
    
    Tricycle() {
        System.out.println("get Tricycle instance");
    }
}

interface CycleFactory {
    
    Cycle getCycle();
}

class UnicycleFactory implements CycleFactory {
    
    /**
     * @see com.cq.thinkinjava.chapter9.CycleFactory#getCycle()
     */
    @Override
    public Cycle getCycle() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return new Unicycle();
    }
    
}

class BicycleFactory implements CycleFactory {
    
    /**
     * @see com.cq.thinkinjava.chapter9.CycleFactory#getCycle()
     */
    @Override
    public Cycle getCycle() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return new Bicycle();
    }
    
}

class TyicycleFactory implements CycleFactory {
    
    /**
     * @see com.cq.thinkinjava.chapter9.CycleFactory#getCycle()
     */
    @Override
    public Cycle getCycle() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return new Tricycle();
    }
    
}
