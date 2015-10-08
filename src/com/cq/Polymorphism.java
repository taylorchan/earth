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
 * @version 2011-9-27 陈强新建
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
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        
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
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        
    }
    
    /**
     * @see com.cq.A#interfMehthod(java.lang.String)
     */
    @Override
    public void interfMehthod(String a) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        
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
