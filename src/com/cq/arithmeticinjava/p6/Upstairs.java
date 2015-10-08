/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.cq.arithmeticinjava.p6;


/**
 * 上楼梯问题,一次可以上一步或者两步，共有n级楼梯
 * @author: qiang.chen
 * @since:    2012-7-9
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class Upstairs {
    public static int upStairs(int n){
        if(n == 2){
            return 2;
        }
        if(n == 1){
            return 1;
        }
        return upStairs(n-1) + upStairs(n-2);
    }
    public static void main(String[] args) {
       System.out.println(upStairs(10));
    }
}
