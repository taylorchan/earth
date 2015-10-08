/**2012-5-29**/

package com.cq.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 关键字为@interface，隐式的继承了java.lang.Annotation 其实还是接口
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-29 陈强新建
 */
// 制定注解的生命周期
@Retention(value = RetentionPolicy.SOURCE)
// 制定注解的作用对象
@Target(value = { ElementType.FIELD, ElementType.METHOD })
// 说明该注解自动被子类继承
@Inherited
public @interface MyAnnotation {
    
    String value = "defaultValue";
    
    String name = "MyAnnotation";
    
    String eame();
    
    String value();// 方法可以制定默认的返回值
}
