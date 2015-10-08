/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter11;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-23 陈强新建
 */
public class Practice14 {
    
    public static void main(String args[]) {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        ListIterator it = lst.listIterator();
        for (int i = 0; i < 10; i++) {
            if (!it.hasNext()) {
                lst.add(i);
            } else if (!it.hasPrevious()) {
                lst.add(i);
                
            }
            
        }
        
    }
}
