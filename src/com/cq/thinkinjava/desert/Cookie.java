/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava.desert;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-17 ��ǿ�½�
 */
public class Cookie {
    
    String className;
    
    private suger sugerKind;
    
    /**
     * ���๹������Ϊprivate�����ཫ�޷���ʼ��
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
