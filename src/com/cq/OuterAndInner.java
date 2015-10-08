/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.cq;

/**
 * 1���ⲿ����Է����ڲ�����κγ�Ա 2.�ڲ����в����о�̬��Ա
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2011-10-27 ��ǿ�½�
 */
public class OuterAndInner {
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        
        Outer out = new Outer();
        // ��δ���outer��inner����Ҫ�ȴ����ⲿ��Ķ������
        Outer.Inner1 in1 = out.new Inner1();
        in1.show();
        out.show();
        out.getInner();
        
        Outer2 out2 = new Outer2();
        out2.getInner();
        out2.innerInstance.sayHello();
    }
}

class Outer {
    
    private final int x = 1;
    
    /**
     * Outer��ķǾ�̬�ڲ���
     * 
     * @author ��ǿ
     * @since 1.0
     * @version 2011-10-28 ��ǿ�½�
     */
    class Inner1 {
        
        private final int x = 4;
        
        /**
         * ��η����ⲿ����ڲ���ĳ�Ա����
         */
        public void show() {
            System.out.println("Outer X:" + Outer.this.x);
            System.out.println("Inner X:" + this.x);
            
        }
        
    }
    
    /**
     * ���� �ֲ��ڲ���,�ھֲ����ж�����࣬��������ֻ�ڶ���Ŀ�����Ч, ���Ǵ����ľֲ��ڲ���Ķ��󲻻���������Ľ��������������������������
     * �����˾ֲ��ڲ�������з�����ͨ�ֲ������ķ�����Ҫ�����⣬��Ϊ��ʱҪ���ʵľֲ������������ˣ�ps:final ���εı������������
     * final�ľֲ���������������󲻻���ʧ�����᳤�ڴ��ڣ������ں��汻�������ʵ�
     */
    public void getInner() {
        final int x = 100;
        /**
         * �ֲ��ڲ���
         * 
         * @author ��ǿ
         * @since 1.0
         * @version 2011-10-28 ��ǿ�½�
         */
        class Inner2 {
            
            /**
             * ���ʾֲ�������ʱ�򣬾ֲ�������Ҫ����Ϊ final ���ɱ�����
             */
            public void show() {
                System.out.println("�ֲ��������ʣ�" + x);
            }
        }
        Inner2 in = new Inner2();
        in.show();
    }
    
    /**
     * �ⲿ���з����ڲ���ĳ�Ա
     */
    public void show() {
        
        Inner1 in = new Inner1();
        System.out.println(in.x);
        
    }
    
    /**
     * @return ��ȡ x����ֵ
     */
    public int getX() {
        return x;
    }
}

/**
 * �ֲ��ڲ���ֻ�ھֲ���Ч�����治�����þֲ��ڲ��������ָ������󣬿ɶ���һ���ӿ�
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2011-10-28 ��ǿ�½�
 */
class Outer2 {
    
    /**
     * �����ڲ��ӿ�
     */
    interface ForInner {
        
        void sayHello();
    }
    
    ForInner innerInstance = null;
    
    public void getInner() {
        
        /**
         * �ֲ��ڲ���
         * 
         * @author ��ǿ
         * @since 1.0
         * @version 2011-10-28 ��ǿ�½�
         */
        class Inner2 implements ForInner {
            
            /**
             * @see com.cq.Outer2.ForInner#sayHello()
             */
            @Override
            public void sayHello() {
                System.out.println("���Ǿֲ��ڲ�������ҵ��������أ���");
                
            }
        }
        innerInstance = new Inner2();
    }
}
