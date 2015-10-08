/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.jvm;

/**
 * survivorRatio = 8（新生代中eden与survivor的比值）,新生代的大小有10m，eden为8m，两个survivor分别为1m，当分配allocation4
 * 的时候发现eden空间不够，故执行一次minorGC，回收的时候发现from space的空间不足，故将回收的对象提前移动到tenured
 * generation
 *  
 *  minorGC 发生在新生代的垃圾回收事件
 *  majorGC/fullGC, 发生在老年代的垃圾回收事件,一般伴随着多次的MinorGc
 * @author 陈强
 * @since 1.0
 * @version 2012-3-14 陈强新建
 */
public class MinorGc {
    
    public static final int _1mb = 1024 * 1024;
    
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1mb];
        allocation2 = new byte[2 * _1mb];
        allocation3 = new byte[2 * _1mb];
        allocation4 = new byte[4 * _1mb];//出现minorGC
        
    }
    
    public static void main(String args[]) {
        testAllocation();
        
    }
}
