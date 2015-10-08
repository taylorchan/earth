/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.springpractice.knight;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * GLib采用非常底层的字节码技术， 可以为一个类创建子类， 并在子类中采用方法拦截的技术拦截所有父类方法的调用， 并在拦截方法相应地织入横切逻辑
 * CGLib采用生成子类的技术创建代理对象，所以不能对目标类中的final方法进行代理。
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-2-15 陈强新建
 */
class SpringAopDemo2 {
    
}

class CglibProxy implements MethodInterceptor {
    
    private Enhancer enhancer = new Enhancer();
    
    // 通过getProxy(Class clazz)为一个类创建动态代理对象
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz); // ① 设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create();// ②通过字节码技术动态创建子类实例
    }
    
    /**
     * 是CGLib定义的Inerceptor接口的方法，obj表示父类的实例，method为父类方法的反射对象，args为方法的动态入参
     * ,proxy为代理类实例。
     * 
     * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object,
     *      java.lang.reflect.Method, java.lang.Object[],
     *      net.sf.cglib.proxy.MethodProxy)
     */
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
        Object result = proxy.invokeSuper(obj, args); // ③ 通过代理类调用父类中的方法
        PerformanceMonitor.end();
        return result;
    }
    
    /**
     * @return 获取 enhancer属性值
     */
    public Enhancer getEnhancer() {
        return enhancer;
    }
    
    /**
     * @param enhancer 设置 enhancer 属性值为参数值 enhancer
     */
    public void setEnhancer(Enhancer enhancer) {
        this.enhancer = enhancer;
    }
    
}

class TestForumService2 {
    
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = // ① 通过动态生成子类的方式创建代理对象
            (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
