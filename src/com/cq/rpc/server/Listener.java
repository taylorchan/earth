package com.cq.rpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.cq.rpc.protocal.Invocation;

public class Listener extends Thread {
    private ServerSocket socket;
    private IServer server;

    public Listener(IServer server) {
        this.server = server;
    }

    @Override
    public void run() {

        System.out.println("--------------服务器启动，开始监听#" + server.getPort());
        try {
            socket = new ServerSocket(server.getPort());
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
        while (server.isRunning()) {
            try {
                Socket client = socket.accept();
                System.out.println("----------server accept client---------");
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                Invocation invo = (Invocation) ois.readObject();
                System.out.println("---------------收到客户端协议对象#" + invo);

                server.call(invo);//收到客户端协议对象，进行处理
                
                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
                oos.writeObject(invo);//写响应
                oos.flush();
                oos.close();
                ois.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        try {
            if (socket != null && !socket.isClosed())
                socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
