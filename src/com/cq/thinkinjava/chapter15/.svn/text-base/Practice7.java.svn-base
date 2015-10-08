/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter15;

import java.util.Iterator;

import net.mindview.util.Generator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-29 陈强新建
 */
public class Practice7 {
    
    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci(5);
        for (int i = 0; i < 10; i++)
            System.out.print(gen.next() + " ");
        Iterator it = gen.getIt();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class Fibonacci implements Generator<Integer> {
    
    private int count = 0;
    
    private final Iterator it;
    
    /**
     * @return 获取 count属性值
     */
    public int getCount() {
        return count;
    }
    
    /**
     * @param count 设置 count 属性值为参数值 count
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * @return 获取 it属性值
     */
    public Iterator getIt() {
        return it;
    }
    
    Fibonacci(int count) {
        this.count = count;
        this.it = new Iterator<Integer>() {
            
            @Override
            public boolean hasNext() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                return Fibonacci.this.count > 0;
            }
            
            @Override
            public Integer next() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                Fibonacci.this.count--;
                return Fibonacci.this.next(false);
            }
            
            @Override
            public void remove() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                
            }
        };
    }
    
    public Integer next(boolean flag) {
        if (flag)
            count++;
        return fib(count);
    }
    
    public Integer next() {
        return fib(count++);
    }
    
    private int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }
    
} /*
   * Output: 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
   */// :~
