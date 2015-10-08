/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.springpractice.knight;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-15 陈强新建
 */
class SpringAopDemo {
    
}

interface ForumService {
    
    void removeTopic(int topicId);
    
    void removeForum(int forumId);
}

class ForumServiceImpl implements ForumService {// 模拟的业务逻辑代码

    @SuppressWarnings("static-access")
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @SuppressWarnings("static-access")
    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class MethodPerformace {
    
    private long begin;
    
    /**
     * @return 获取 end属性值
     */
    public long getEnd() {
        return end;
    }
    
    /**
     * @param end 设置 end 属性值为参数值 end
     */
    public void setEnd(long end) {
        this.end = end;
    }
    
    /**
     * @param begin 设置 begin 属性值为参数值 begin
     */
    public void setBegin(long begin) {
        this.begin = begin;
    }
    
    /**
     * @return 获取 begin属性值
     */
    public long getBegin() {
        return begin;
    }
    
    private long end;
    
    private final String serviceMethod;
    
    public MethodPerformace(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();// 记录方法调用开始时的系统时间
    }
    
    public void printPerformace() {
        // 以下两行程序得到方法调用后的系统时间，并计算出方法执行花费时间
        end = System.currentTimeMillis();
        long elapse = end - begin;
        // 报告业务方法执行时间
        System.out.println(serviceMethod + "花费" + elapse + "毫秒。");
    }
}

class PerformanceMonitor {// ThreadLocal是削除非线程安全状态的不二法宝

    // 通过一个ThreadLocal保存线程相关的性能监视信息
    private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();
    
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformace mp = new MethodPerformace(method);
        performaceRecord.set(mp);
    }
    
    public static void end() {
        System.out.println("end monitor...");
        MethodPerformace mp = performaceRecord.get();
        mp.printPerformace(); // 打印出业务方法性能监视的信息
    }
}

/**
 * InvocationHandler就是横切代码的家园乐土，我们将性能监视的代码安置在PerformaceHandler中
 */
class PerformaceHandler implements InvocationHandler {
    
    private final Object target;
    
    public PerformaceHandler(Object target) {// ①target为目标的业务类
        this.target = target;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target, args);// ②通过反射方法调用目标业务类的业务方法
        PerformanceMonitor.end();
        return obj;
    }
    
    public void jubum() {
        String s = null;
        s.charAt(0);
    }
}

/** 代理实例 **/
class TestForumService {
    
    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl();// ①目标业务类
        // ② 将目标业务类和横切代码编织到一起,将ForumService实例编织为一个包含性能监视逻辑的PerformaceHandler实例
        PerformaceHandler handler = new PerformaceHandler(target);
        // ③为编织了目标业务类逻辑和性能监视横切逻辑的handler创建代理类
        // 第一个入参为类加载器，第二个入参为创建的代理实例所要实现的一组接口，
        // 第三个参数是整合了业务逻辑和横切逻辑的编织器对象
        ForumService proxy =
            (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        // ④ 操作代理实例
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
