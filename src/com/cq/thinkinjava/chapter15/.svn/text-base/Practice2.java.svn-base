/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-29 陈强新建
 */
public class Practice2 {
    
    public static void main(String args[]) {
        List[] obj = { new ArrayList(), new ArrayList(), new ArrayList() };
        Holder<List> h = new Holder<List>(obj);
        List[] ls = h.getLst();
        for (int i = 0; i < ls.length; i++) {
            List list = ls[i];
            System.out.println(list);
            
        }
    }
}

class Holder<T> {
    
    private T[] lst;
    
    public Holder(T[] t) {
        this.lst = t;
    }
    
    public void setLst(T[] t) {
        this.lst = t;
    }
    
    /**
     * @return 获取 lst属性值
     */
    public T[] getLst() {
        return lst;
    }
}
