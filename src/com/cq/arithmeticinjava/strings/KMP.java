/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.strings;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-11
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class KMP {
    
    public static int[] getNextJ(char[] source){
        assert source!= null;
        int len = source.length;
        int[] nextArray= new int[len];
        char[] tempArray;
        int value;
        for ( int j = 0; j < len; j++) {
            tempArray = new char[j+1];
            System.arraycopy(source, 0, tempArray, 0, j+1);
            if(j+1 == 1){
                nextArray[j] =1;
                continue;
            }
            int n = (j+1)/2;
            int i = 0;
            value = 1;
            loop1:
            while(n<=j){
                while(i<n){
                    if(tempArray[i++] != tempArray[j-n+1]){
                        continue loop1;
                    }
                    value++;
                }
                n++;
               
            }
            nextArray[j] = value;
        }
        return nextArray;
    }

    
    public static int KMP_(String sour,String des){
        char[] source = sour.toCharArray();
        char[] sep = des.toCharArray();
        int len1 = source.length;
        int len2 = sep.length;
        int index = -1;
        int i = 0,j = 0;
        int[] next = getNextJ(sep);
        while(i < len1 -len2 + 1 && j <len2){
            if(j == 0 || source[i] == sep[j]){
                ++i;
                ++j;
            }else{
                j = next[j];
            }
        }
        if(j == len2){
            index =  i-len2;
        }
        return index;
    }
    public static void main(String[] args) {
       System.out.println(KMP_("ababsfdfdab","abab")); 
      // System.out.println(isLoopWord(new char[]{'a'}, 0));
    }
}
