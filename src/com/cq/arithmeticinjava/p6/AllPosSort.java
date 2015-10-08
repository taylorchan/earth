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
 * 全排列
 * @author: qiang.chen
 * @since:    2012-7-9
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class AllPosSort {
    public static List<char[]> ls = new ArrayList<char[]>();
    public static void allPosSort(char[] chars){
        if(chars.length == 0){
            return;
        }
       char[] newArrayPre = new char[1];
       newArrayPre[0] = chars[0];
       char[] newArrayAfter = new char[chars.length-1];
       System.arraycopy(chars, 1, newArrayAfter, 0, chars.length-1);
       char[]  sortArray =  swap(newArrayPre,newArrayAfter);
       ls.add(sortArray);
       allPosSort(newArrayAfter);
    }
    
    private static char[] swap(char[] array1,char[] array2){
        char[] array = new char[array1.length + array2.length];
        System.arraycopy(array2, 0, array, 0, array2.length);
        System.arraycopy(array1, 0, array, array2.length, array1.length);
        return array;
    }
    public static void main(String[] args) {
        String temp = "123";
        allPosSort(temp.toCharArray());
    }
}
