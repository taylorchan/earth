package com.cq.rpc.client;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.UnknownHostException;

import com.cq.rpc.protocal.Invocation;


public class RPC {
	public static <T> T getProxy(final Class<T> clazz,String host,int port) throws UnknownHostException, IOException {
		
		final Client client = new Client(host,port);
		InvocationHandler handler = new InvocationHandler() {			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Invocation invo = new Invocation();
				invo.setInterfaces(clazz);
				invo.setMethod(new com.cq.rpc.protocal.Method(method.getName(),method.getParameterTypes()));
				invo.setParams(args);
				client.invoke(invo);
				return invo.getResult();
			}
		};
		T t = (T) Proxy.newProxyInstance(RPC.class.getClassLoader(), new Class[] {clazz},  handler);
		return t;
	}
}
	



	
	
	

