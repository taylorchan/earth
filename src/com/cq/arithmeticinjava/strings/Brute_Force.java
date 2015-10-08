/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.strings;

import java.util.ArrayList;
import java.util.List;


/**
 * indexof的简单算法实现
 * @author: qiang.chen
 * @since:    2012-7-11
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class Brute_Force {
    public static int indexOf(String source,String des){
        char[] sour = source.toCharArray();
        char[] sep = des.toCharArray();
        int length1 = sour.length;
        int length2 = sep.length;
        int index = -1;
        if(length2 > length1){
            return index;
        }
        loop1:
        for (int i = 0; i < length1 - length2 ; i++) {
             for (int j = 0; j < length2; j++) {
                if(sour[i+j] != sep[j])
                     continue loop1;
             }
             index = i;
             break;
        }
        return index;
    }
        public static List<Integer> indexOf_All(String source,String des){
            char[] sour = source.toCharArray();
            char[] sep = des.toCharArray();
            int length1 = sour.length;
            int length2 = sep.length;
            int index = -1;
            List<Integer> ls = new ArrayList<Integer>();
            if(length2 > length1){
                return ls;
            }
            loop1:
            for (int i = 0; i < length1 - length2 ; i++) {
                 for (int j = 0; j < length2; j++) {
                    if(sour[i+j] != sep[j])
                         continue loop1;
                 }
                 index = i;
                 ls.add(index);
            }
            return ls;
        }

    public static void main(String[] args) {
        System.out.println(indexOf_All("abcdefgabcabcabccccavavabab","ab"));;
    }
}
