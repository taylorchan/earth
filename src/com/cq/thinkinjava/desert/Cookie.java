/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.desert;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-17 陈强新建
 */
public class Cookie {
    
    String className;
    
    private suger sugerKind;
    
    /**
     * 父类构造器若为private，子类将无法初始化
     */
    public Cookie() {
        this.sugerKind = new suger();
    }
    
    public Cookie(String name) {
        this.className = name;
    }
    
    protected void bite() {
    };
    
    protected class suger {
        
        public suger() {
            System.out.println("Cookie's suger!");
        }
        
    }
    
}
