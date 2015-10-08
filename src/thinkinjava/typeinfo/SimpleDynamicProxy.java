//: typeinfo/SimpleDynamicProxy.java

package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    
    private final Object proxied;
    
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null)
            for (Object arg : args)
                System.out.println("  " + arg);
        // 将请求转发给被代理对象，并传入参数，此处的method即指向代理对象的method
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy =
            (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[] { Interface.class },
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
} /*
   * Output: (95% match) doSomething somethingElse bonobo*** proxy: class
   * $Proxy0, method: public abstract void Interface.doSomething(), args: null
   * doSomething*** proxy: class $Proxy0, method: public abstract void
   * Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
   * bonobo somethingElse bonobo
   */// :~
