/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava;

/**
 * Integer在创建对象时，值在-128-127范围内，会放入缓冲池中
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-2-21 陈强新建
 */
public class IntegerCache {
    
    private IntegerCache() {
    }
    
    static final Integer cache[] = new Integer[-(-128) + 127 + 1];
    
    static {
        for (int i = 0; i < cache.length; i++)
            cache[i] = new Integer(i - 128);
    }
    
    public static void main(String args[]) {
        
        for (int i = 0; i < cache.length; i++)
            System.out.println(cache[i]);
    }
    
}
