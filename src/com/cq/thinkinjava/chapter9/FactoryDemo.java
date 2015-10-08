/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.chapter9;

/**
 * factoryģʽ��ϰ��
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-22 ��ǿ�½�
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
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        return new Unicycle();
    }
    
}

class BicycleFactory implements CycleFactory {
    
    /**
     * @see com.cq.thinkinjava.chapter9.CycleFactory#getCycle()
     */
    @Override
    public Cycle getCycle() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        return new Bicycle();
    }
    
}

class TyicycleFactory implements CycleFactory {
    
    /**
     * @see com.cq.thinkinjava.chapter9.CycleFactory#getCycle()
     */
    @Override
    public Cycle getCycle() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        return new Tricycle();
    }
    
}
