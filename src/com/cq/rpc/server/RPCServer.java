/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.rpc.server;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.cq.rpc.op.Echo;
import com.cq.rpc.op.RemoteEcho;
import com.cq.rpc.protocal.Invocation;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-10-7
 * @version : 1.0
 */
public class RPCServer implements IServer{
    private int port = 20382;
    private Listener listener; 
    private boolean isRuning = true;
    
    /**
     * @param isRuning the isRuning to set
     */
    public void setRuning(boolean isRuning) {
        this.isRuning = isRuning;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    private Map<String ,Object> serviceEngine = new HashMap<String, Object>();
    
    
    @Override
    public void call(Invocation invo) {
        System.out.println(invo.getClass().getName());
        Object obj = serviceEngine.get(invo.getInterfaces().getName());//获取类
        if(obj!=null) {
            try {
                Method m = obj.getClass().getMethod(invo.getMethod().getMethodName(), invo.getMethod().getParams());//获取方法及参数
                Object result = m.invoke(obj, invo.getParams());
                invo.setResult(result);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("has no these class");
        }
    }

    @Override
    public void register(Class interfaceDefiner, Class impl) {
        try {
            this.serviceEngine.put(interfaceDefiner.getName(), impl.newInstance());
            System.out.println(serviceEngine);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    @Override
    public void start() {
        System.out.println("");
        listener = new Listener(this);
        this.isRuning = true;
        listener.start();
    }

    @Override
    public void stop() {
        this.setRuning(false);
    }

    @Override
    public boolean isRunning() {
        return isRuning;
    }
    
    
    public static void main(String[] args) {
        IServer server = new RPCServer();
        server.register(Echo.class,  RemoteEcho.class);
        server.start();
    }
    
}
