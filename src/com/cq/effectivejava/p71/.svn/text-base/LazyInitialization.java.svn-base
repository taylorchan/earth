/**2012-6-28**/

package com.cq.effectivejava.p71;

/**
 * 延迟加载的示例
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-28 陈强新建
 */
public class LazyInitialization {
    
    private static class FieldType {
    }
    
    /**
     * 可以应用于单例的变种，用于static域
     * 
     * @author 陈强
     * @since 1.0
     * @version 2012-6-28 陈强新建
     */
    private static class FiledHolder {
        
        static final FieldType filed = new FieldType();
    }
    
    /**
     * 第一次读取field，才导致FiledHolder被初始化
     * 
     * @return
     */
    public static FieldType getFiledClass() {
        return FiledHolder.filed;
    }
    
    private volatile FieldType field;
    
    /**
     * 使用双重检查，主要应用于实例域
     * 
     * @return
     */
    FieldType getField() {
        FieldType result = field;
        if (result == null) {
            synchronized (this) {
                result = field;
                if (result == null) {// 声明为volatile的作用，使对其的改变马上发生到里面去
                    field = result = new FieldType();
                }
            }
        }
        return result;
    }
    
    /**
     * 单重检查，用于可接受重复初始化的域
     * 
     * @return
     */
    FieldType getFiled2() {
        FieldType result = field;
        if (result == null) {// 声明为volatile的作用，使对其的改变马上发生到里面去
            field = result = new FieldType();
        }
        return result;
    }
}
