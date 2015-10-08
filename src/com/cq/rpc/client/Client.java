
package com.cq.rpc.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.cq.rpc.op.Echo;
import com.cq.rpc.protocal.Invocation;

public class Client {
    
    String host;
    
    int port;
    
    private Socket socket;
    
    public Client(String host, int port) throws UnknownHostException, IOException {
        this.host = host;
        this.port = port;
    }
    
    private void init() throws UnknownHostException, IOException {
        socket = new Socket(host, port);
    }
    
    public void invoke(Invocation invo) throws UnknownHostException, IOException, ClassNotFoundException {
        System.out.println("----客户端开始写数据----");
        this.init();
        ObjectOutputStream oos =  new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(invo);
        oos.flush();
        
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Invocation result = (Invocation) ois.readObject();
        invo.setResult(result.getResult());
        oos.close();
        ois.close();
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        Echo echo = RPC.getProxy(Echo.class, "127.0.0.1", 20382);
        
        System.out.println(echo.echo("hello,1111111111111111111"));
        System.out.println(echo.echo("hello,22222222222222222"));
        System.out.println(echo.echo("hello,33333333333333333"));
        System.out.println(echo.echo("hello,44444444444444444"));
    }
    
}
