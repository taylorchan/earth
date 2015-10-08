
package com.cq.thinkinjava.chapter14;

import static net.mindview.util.Print.print;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-29 陈强新建
 */

public class Practice21 {
    
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    
    public static void main(String[] args) {
        consumer(new RealObject());
        SimpleProxy in = new SimpleProxy(new RealObject());
        consumer(in);
        System.out.println(in.getMethodCount());
    }
}

interface Interface {
    
    void doSomething();
    
    void somethingElse(String arg);
}

class RealObject implements Interface {
    
    public void doSomething() {
        print("doSomething");
    }
    
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

/**
 * 代理充当了中间人的角色，是插入用来代替实际对象的对象，这些操作通常涉及到与实际对象的通信 既然是代理，则与实际对象有相似的地方
 */
class SimpleProxy implements Interface {
    
    private final Interface proxied;
    
    private int methodCount;
    
    /**
     * @return 获取 methodCount属性值
     */
    public int getMethodCount() {
        return methodCount;
    }
    
    /**
     * @param methodCount 设置 methodCount 属性值为参数值 methodCount
     */
    public void setMethodCount(int methodCount) {
        this.methodCount = methodCount;
    }
    
    /**
     * @return 获取 proxied属性值
     */
    public Interface getProxied() {
        return proxied;
    }
    
    // 代理中初始化实际对象
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    
    // 注意与spring的 aop对比一下，此处做的事情相当于将业务代码跟切面代码结合
    public void doSomething() {
        print("SimpleProxy doSomething");
        proxied.doSomething();
        methodCount++;
        
    }
    
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        methodCount++;
    }
}

/*
 * Output: doSomething somethingElse bonobo SimpleProxy doSomething doSomething
 * SimpleProxy somethingElse bonobo somethingElse bonobo
 */// :~
