/**2012-6-23**/

package com.cq.effectivejava.p29;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public class ReadAnnotation {
    
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (ClassNotFoundException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        // 此方法存在 有限制的类型令牌，
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
