/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2011-9-27 ��ǿ�½�
 */
abstract class Rodent {
    
    protected boolean flag = false;
    
    // abstract void abMethod();
    public static void staMethod() {
        System.out.println("father's method!!");
    }
    
    void hasTooth() {
        System.out.println("base Tooth!!");
    }
    
    protected void typeInfo() {
        this.hasTooth();
    }
    
    public static void staticmethod() {
        
    }
    
}

class Mouse extends Rodent {
    
    String type = "Hamster!";
    
    @Override
    protected void hasTooth() {
        System.out.println("Mouse Tooth!!");
    }
    
    /**
     * @see com.cq.Rodent#abMethod()
     */
    void abMethod() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        
    }
}

class Gerbil extends Rodent {
    
    String type = "Hamster!";
    
    @Override
    protected void hasTooth() {
        System.out.println("Gerbil Tooth!!");
    }
    
    // abstract void abMethod();
    public static void staMethod() {
        System.out.println("father's method!!");
    }
    
    /**
     * @see com.cq.Rodent#abMethod()
     */
    void abMethod() {
        this.flag = true;
    }
}

class Hamster extends Rodent implements A {
    
    String type = "Hamster!";
    
    @Override
    protected void hasTooth() {
        System.out.println("Hamster Tooth!!");
    }
    
    public static void staMethod() {
        System.out.println("child's method!!!");
    }
    
    /**
     * @see com.cq.Rodent#abMethod()
     */
    void abMethod() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        
    }
    
    /**
     * @see com.cq.A#interfMehthod(java.lang.String)
     */
    @Override
    public void interfMehthod(String a) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        
    }
}

interface A {
    
    void interfMehthod(String a);
}

class mainClass {
    
    public static void main(String args[]) {
        Rodent rodent[] = { new Mouse(), new Gerbil(), new Hamster() };
        for (int i = 0; i < rodent.length; i++) {
            rodent[i].hasTooth();
            
            if (rodent[i] instanceof Hamster) {
                System.out.println("-------------");
                rodent[i].typeInfo();
                Hamster.staMethod();
            }
            
        }
        final Rodent hm = new Hamster();
        hm.flag = true;
        Class b = hm.getClass();
        
        Class a = com.cq.Rodent.class;
        a.getDeclaredFields();
        Class c = Integer.class;
    }
}
