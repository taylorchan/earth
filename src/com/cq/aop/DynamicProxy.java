/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-10-7
 * @version : 1.0
 */
public class DynamicProxy implements AopInterface{
    
    private Object obj;
    public DynamicProxy(Object _obj) {
        super();
        this.obj = _obj;
    }
    
  public Object getProxy() {
        InvocationHandler handler = new InvocationHandler() {           
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                DynamicProxy.this.doBefore();
                Object o = method.invoke(obj, args);
                DynamicProxy.this.doBefore();
                return o;
            }
        };
        return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(), this.obj.getClass().getInterfaces(),  handler);
    }

/* (non-Javadoc)
 * @see com.cq.aop.AopInterface#doBefore()
 */
@Override
public Object doBefore() {
    // TODO Auto-generated method stub
    System.out.println("植入逻辑,方法开始之前");
    return null;
}

/* (non-Javadoc)
 * @see com.cq.aop.AopInterface#doAfter()
 */
@Override
public Object doAfter() {
    // TODO Auto-generated method stub
    System.out.println("植入逻辑,方法结束之后");
    return null;
}
   
}
