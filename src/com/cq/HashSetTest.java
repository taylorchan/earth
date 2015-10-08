/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

/**
 * 1。hashSet存储对象的时候使用的是hash策略来实现的 2.hashSet实现了set接口，里面的元素不能重复，只能出现一次null
 * 3.向hashSet中添加元素的时候，先调用该对象的hashCode方法得到hashCode，
 * 4.若hashCode对应的hash桶已经存在再调用equals方法，判断是否对象已经存在，然后确定是否需要添加对象。
 * 5.在实现Collection接口的类中，添加的元素均为对象的引用
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-10-27 陈强新建
 */
public class HashSetTest {
    
}
