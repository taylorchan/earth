/**2012-6-24**/

package com.cq.effectivejava.p34;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
public class Sample {
    
    @Test
    public static void m1() {
    }
    
    public static void m2() {
    }
    
    @Test
    public static void m3() {
        throw new RuntimeException("boom");
    }
    
    public static void m4() {
    }
    
    @Test
    public void m5() {
    }
    
    public static void m6() {
    }
    
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }
    
    public static void m8() {
    }
    
    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;
        Class clazz = null;
        try {
            clazz = Class.forName("com.cq.effectivejava.p34.Sample");
        } catch (ClassNotFoundException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);// 通过class来调用，没有实例，只能调用到类方法
                    passed++;
                } catch (IllegalArgumentException e) {
                    // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
                    e.printStackTrace();
                } catch (InvocationTargetException wrappedExc) {
                    // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception e) {
                    System.out.println("invalid @Test: " + m);
                }
            }
        }
        System.out.printf("passed:%d,failed: %d%n", passed, tests - passed);
    }
}
