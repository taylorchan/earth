
package com.cq.thinkinjava.chapter14;

import static net.mindview.util.Print.print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-29 陈强新建
 */
public class Practice22 {
    
    public static void main(String[] args) {
        SomeMethods proxy =
            (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), new Class[] { SomeMethods.class },
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo", 3);
        proxy.boring3();
        System.out.println(MethodSelector.getMethodCount());
    }
}

class MethodSelector implements InvocationHandler {
    
    private final Object proxied;
    
    private static int methodCount = 0;
    
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("count:**" + methodCount + "**** proxy: " + proxy.getClass() + ", method: " + method
            + ", args: " + args);
        if (method.getName().equals("interesting"))
            print("Proxy detected the interesting method");
        methodCount++;
        return method.invoke(proxied, args);
    }
    
    /**
     * @return 获取 methodCount属性值
     */
    public static int getMethodCount() {
        return methodCount;
    }
}

interface SomeMethods {
    
    void boring1();
    
    void boring2();
    
    void interesting(String arg, int arg2);
    
    void boring3();
}

class Implementation implements SomeMethods {
    
    public void boring1() {
        print("boring1");
    }
    
    public void boring2() {
        print("boring2");
    }
    
    public void interesting(String arg, int arg2) {
        print("interesting " + arg + arg2);
    }
    
    public void boring3() {
        print("boring3");
    }
}

class SelectingMethods {
    
} /*
   * Output: boring1 boring2 Proxy detected the interesting method interesting
   * bonobo boring3
   */// :~
