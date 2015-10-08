/**2012-6-24**/

package com.cq.effectivejava.p34;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
public class Sample2 {
    
    @ExceptionTest( { ArithmeticException.class })
    public static void m1() {
        int i = 0;
        i = i / i;
    }
    
    @ExceptionTest( { ArithmeticException.class, ArrayIndexOutOfBoundsException.class })
    public static void m2() {
        int[] a = new int[0];
        int o = a[1];
    }
    
    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
    }
    
    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;
        Class clazz = null;
        try {
            clazz = Class.forName("com.cq.effectivejava.p34.Sample2");
        } catch (ClassNotFoundException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);// 通过class来调用，没有实例，只能调用到类方法
                } catch (IllegalArgumentException e) {
                    // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException wrappedExc) {
                    // 此处捕获到异常
                    Throwable exc = wrappedExc.getCause();
                    // 获取注解中的异常的类名
                    Class<? extends Exception>[] excType = m.getAnnotation(ExceptionTest.class).value();
                    if (excType[0].isInstance(exc)) {// 检查捕获到的异常是否是注解中填写的异常类的实例
                        passed++;
                    } else {
                        System.out.printf("Test %s failed: expected %s, got %s%n", m, excType[0].getName(), exc);
                    }
                } catch (Exception e) {
                    System.out.println("invalid @ExceptionTest: " + m);
                }
            }
        }
        System.out.printf("passed:%d,failed: %d%n", passed, tests - passed);
    }
}
