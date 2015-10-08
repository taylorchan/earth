/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

/**
 * @author 陈强
 * @since 1.0
 * @version 2011-10-27 陈强新建
 */
public class Equals {
    
    private String name;
    
    private int num;
    
    /**
     * 重写equals 作用域一定要为public不能缩小 ；参数的类型一定要为object，不能是要比较的类型
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (null == o) {
            return false;
        }
        if (!(o instanceof Equals)) {
            return false;
        }
        //
        Equals eo = (Equals) o;
        // 执行equals
        return false;
    }
    
    /**
     * 1.重写了equals方法就一定要重写hashCode方法
     * 2.若两个对象的hashCode不同，则这两个对象equals结果为false（不在同一个hash桶）
     * 3.若两个对象的equals结果为true,则这两个对象的hashCode结果相同
     * 4.若两个对象的equals结果为false,则这两个对象的hashCode也有可能相同（同一个hash桶里面的不同对象）
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.num * 15 + this.name.hashCode();
        
    }
    
    /**
     * @param name 设置 name 属性值为参数值 name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return 获取 name属性值
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param num 设置 num 属性值为参数值 num
     */
    public void setNum(int num) {
        this.num = num;
    }
    
    /**
     * @return 获取 num属性值
     */
    public int getNum() {
        return num;
    }
    
}
