/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq.thinkinjava;

import com.cq.thinkinjava.desert.Cookie;
import com.cq.thinkinjava.desert.Eat;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-17 ��ǿ�½�
 */
class ChocolateChip extends Cookie implements Eat {
    
    public ChocolateChip() {
        // super("ddd");// �������Ĭ�Ϲ��������ɼ���������ʽ�ĵ��������ɼ��Ĺ�����������Ҫ����һ��������
    }
    
    void chomp() {
        bite();
    }
    
    protected class suger {
        
        public suger() {
            System.out.println("ChocolateChip's suger!");
        }
        
    }
    
    public static void main(String args[]) {
        short i = 0;
        long l = 6;
        Integer a = 125;
        Integer b = 125;
        Integer c = 130;
        Integer d = 130;
        
        System.out.println(a == b);
        System.out.println(c == d);
        
        ChocolateChip e = new ChocolateChip();
    }
    
}
