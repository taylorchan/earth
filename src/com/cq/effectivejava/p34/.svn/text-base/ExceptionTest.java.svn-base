/**2012-6-24**/

package com.cq.effectivejava.p34;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    
    // 注解的参数类型，某个扩展Exception的类的class对象
    Class<? extends Exception>[] value();
}
