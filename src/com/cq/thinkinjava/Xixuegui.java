/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2011-11-16 ��ǿ�½�
 */
public class Xixuegui {
    
    int c;
    
    /**
     * 
     */
    public Xixuegui() {
        System.out.println(c);
        c = 222;
    }
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        for (int i = 1000; i < 10000; i++) {
            if (isXixueguiNum(i)) {
                System.out.println(i);
            }
        }
    }
    
    /**
     * @param i
     * @return
     */
    public static boolean isXixueguiNum(int i) {
        String strS = String.valueOf(i);
        if (strS.endsWith("00")) {
            return false;
        }
        StringBuilder strLeft = null;
        StringBuilder strBegin = null;
        for (int j = 0; j < strS.length(); j++) {
            for (int l = 0; l < strS.length(); l++) {
                if (l == j) {
                    continue;
                }
                strBegin = new StringBuilder(10);
                if (strS.charAt(j) != 0) {
                    strBegin.append(strS.charAt(j)).append(strS.charAt(l));
                }
                strLeft = new StringBuilder(10);
                for (int n = 0; n < strS.length(); n++) {
                    if (n != j && n != l) {
                        strLeft.append(strS.charAt(n));
                    }
                }
                int result1 = Integer.valueOf(strBegin.toString()) * Integer.valueOf(strLeft.toString());
                int result2 = Integer.valueOf(strBegin.toString()) * Integer.valueOf(strLeft.reverse().toString());
                if (result1 == i || result2 == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
