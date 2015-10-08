/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author 陈强
 * @since 1.0
 * @version 2011-10-27 陈强新建
 */
public class ExceptionDemo {
    
    /**
     * 若throw语句抛出捕获异常，其类型必须与所在的 方法声明中可能抛出的捕获异常的类型相同或者为其子类， 类型的确定按引用类型，而不是按其实际指
     * 向的类型
     * 
     * @throws IOException
     */
    public void myFunction() throws IOException {
        IOException ie = new EOFException();
        // 显性抛出异常，在方法的声明中仍然需要声明异常
        throw ie;
    }
    
    /**
     * 隐性再抛出
     * 
     * @throws IOException
     */
    public void myFunction2() throws IOException {
        ServerSocket sk = new ServerSocket(9999);
    }
    
}
