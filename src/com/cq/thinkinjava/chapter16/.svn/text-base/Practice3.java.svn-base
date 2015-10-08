/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter16;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-1 陈强新建
 */
public class Practice3 {
    
    private static Random rand = new Random(48);
    
    double[][] arrayGen(int arg1, int arg2, int ran1, int ran2) {
        if (arg1 <= 0 || arg2 <= 0) {
            return null;
        }
        double doubArray[][] = new double[arg1][arg2];
        double[] temp;
        double tempD;
        for (int i = 0; i < doubArray.length; i++) {
            temp = doubArray[i];
            for (int j = 0; j < temp.length; j++) {
                while (true) {
                    tempD = this.genDouble() * ran2;
                    if (tempD >= ran1) {
                        temp[j] = tempD;
                        break;
                    }
                }
                
            }
        }
        return doubArray;
    }
    
    double genDouble() {
        return rand.nextDouble();
    }
    
    public static void main(String args[]) {
        double[][] array = new Practice3().arrayGen(3, 6, 1, 10);
        System.out.println("double array:" + Arrays.deepToString(array));
    }
}
