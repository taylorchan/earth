/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter11;

import java.util.Arrays;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-23 陈强新建
 */
public class Practice7 {
    
    public static void main(String args[]) {
        
        MyList[] lstArray = new MyList[3];
        for (int i = 0; i < lstArray.length; i++) {
            lstArray[i] = new MyList(i);
            
        }
        List<MyList> newList = Arrays.asList(lstArray);
        System.out.println("newList:---" + newList);
        List<MyList> subList = newList.subList(0, 1);
        System.out.println("subList:---" + subList);
        newList.remove(subList.get(0));
        System.out.println("newList:---" + newList);
    }
}

class MyList {
    
    private int i;
    
    /**
     * @return 获取 i属性值
     */
    public int getI() {
        return i;
    }
    
    /**
     * @param i 设置 i 属性值为参数值 i
     */
    public void setI(int i) {
        this.i = i;
    }
    
    MyList(int num) {
        this.i = num;
    }
    
    @Override
    public boolean equals(Object anther) {
        if (this == null)
            return false;
        if (this.i == ((MyList) anther).getI())
            return true;
        return false;
        
    }
}
