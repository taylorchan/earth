/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.p6;

import java.util.ArrayList;
import java.util.List;


/**
 * 找出子集
 * @author: qiang.chen
 * @since:    2012-7-9
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class CountInnerCollections {
    public static  List<Object[]> lsCollection = new ArrayList<Object[]>();
    
    public static void getObjArray(Object[] objs ){
        lsCollection.add(objs);
        if(objs.length>1){
            Object[] newArray = new Object[1];
            System.arraycopy(objs, 0, newArray, 0, 1);
            lsCollection.add(newArray);
        }
        int length = objs.length;
        int newSize = length - 1;
        if(newSize == 0){
            lsCollection.add(new Object[0]);
            return;
        }
        Object[] newArrays = new Object[newSize];
        System.arraycopy(objs, 1, newArrays, 0, newSize);
        getObjArray(newArrays);
    }
    public static void main(String[] args) {
        Integer[] inta = {1,2,3,4};
        getObjArray(inta);
    }
}
