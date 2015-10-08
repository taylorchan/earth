/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter16;

import java.util.Arrays;

import arrays.BerylliumSphere;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-2 陈强新建
 */
public class Practice18 {
    
    public static void main(String args[]) {
        BerylliumSphere[] bs = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
        BerylliumSphere[] bs2 = new BerylliumSphere[5];
        System.arraycopy(bs, 0, bs2, 0, bs.length);
        Arrays.sort(bs);
        for (int i = 0; i < bs.length; i++) {
            System.out.println(bs[i]);
        }
        for (int i = 0; i < bs2.length; i++) {
            System.out.println(bs2[i]);
        }
        
    }
}
