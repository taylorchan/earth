/**2012-5-29**/

package com.cq.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-29 陈强新建
 */
public class TestAnnotation {
    
    @MyAnnotation(value = "1", eame = "2")
    private String name;
    
    private int num;
    
    private int count;
    
    @MyAnnotation(value = "1", eame = "2")
    void method() {
        
    }
    
    public static void main(String args[]) {
        TestAnnotation ta = new TestAnnotation();
        Class clazz = ta.getClass();
        Field f = null;
        try {
            f = clazz.getDeclaredField("name");
        } catch (SecurityException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        Annotation[] ma = f.getDeclaredAnnotations();
        MyAnnotation ma2 = f.getAnnotation(MyAnnotation.class);
        System.out.println(((MyAnnotation) ma[0]).eame());
        System.out.println(((MyAnnotation) ma[0]).value());
        
    }
}
