/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.p5;


/**
 * 移动次数为2的n次方减1
 * @author: qiang.chen
 * @since:    2012-7-9
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class MyHano {
    
    public static void hanoi(int n,String A,String B,String C){
        if(n == 1){
            System.out.println( n +" "+ A +" ===》 "+ C);
        }
        else{
            hanoi(n-1,A,C,B);
            System.out.println(n +" "+ A +" ===》 "+ C);
            hanoi(n-1,B,A,C);
        }
    }
    public static long Sigema(int n){
        if(n == 1){ return 1L;}
         return n + Sigema(n-1);
        
    
        
    }
    public static void main(String[] args) {
        hanoi(10,"圆柱1","圆柱2","圆柱3");
        System.out.println(Sigema(100));
    }
}
