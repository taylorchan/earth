/**
 * Taylor Chan's works for practice
 */
package com.cq.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 在原始类和接口还未知的时候,就确定代理类的行为,当代理类与原始类脱离了联系的时候,就可以很容易的应用到不同的场合
 * @author taylor
 * @date 2013-3-2
 * @version 1.0
 *
 */
public class DynamicProxyDemo {
	
	interface IHello{
		void sayHello();
	}
	
	static class Hello implements IHello{

		/* (non-Javadoc)
		 * @see com.cq.jvm.DynamicProxyDemo.IHello#sayHello()
		 */
		@Override
		public void sayHello() {
			System.out.println("hello's class say hello to you !");
		}
	}
	
	
	static class  DynamicProxy implements InvocationHandler{
		
		Object originalObj;
		
		DynamicProxy(Object orignal){
			this.originalObj = orignal;
		}
		
		Object generateProxyInstance(){
			return Proxy.newProxyInstance(this.originalObj.getClass().getClassLoader(), this.originalObj.getClass().getInterfaces(), this);
		}

		/* (non-Javadoc)
		 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("enter the dynamic instance");
			System.out.println("the original method name is " + method.getName());
			method.invoke(originalObj, args);
			System.out.println("finish invoke,enter the dynamic instance again");
			return null;
		}
	}
	
	public static void main(String[] args) {
		DynamicProxy d = new DynamicProxy(new Hello());
		IHello hello = (IHello)d.generateProxyInstance();
		hello.sayHello();
	}
}
