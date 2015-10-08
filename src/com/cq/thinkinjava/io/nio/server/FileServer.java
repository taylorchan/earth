/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.nio.server;


import java.nio.channels.*;
import java.nio.charset.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.nio.*;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-24
 * @version : 1.0
 */
public class FileServer {
    
    
    private Selector selector = null;
    
    private ServerSocketChannel serverSocketChannel = null;
    
    private int port = 8050;
    
    private Charset charset=Charset.forName("UTF-8");

    public FileServer()throws IOException{
        selector = Selector.open();
        serverSocketChannel= ServerSocketChannel.open();
        serverSocketChannel.socket().setReuseAddress(true);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        System.out.println("Server is start[" + new InetSocketAddress(port).getAddress() + ":" + port + "]");
    }

    public void service() throws IOException{
        
        System.out.println("ServerSocketChannel register [" + SelectionKey.OP_ACCEPT + "] to selector");
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT );
        while (selector.select() > 0) {
            // 取得迭代器.selectedKeys()中包含了每个准备好某一I/O操作的信道的SelectionKey  
            // Selected-key Iterator 代表了所有通过 select() 方法监测到可以进行 IO 操作的 channel  
            // ，这个集合可以通过 selectedKeys() 拿到 
            Set<SelectionKey> selectKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectKeys.iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                try {
                    if (key.isAcceptable()) {
                        accept(key);
                    }
                    
                    if (key.isReadable()) {// 判断是否有数据发送过来  
                        receive(key);
                    }
                    
                    if (key.isWritable()) {//发送给客户端  
                        send(key);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        if (key != null) {
                            key.cancel();
                            key.channel().close();
                        }
                    } catch (Exception ex) {
                        e.printStackTrace();
                    }
                }
                // 移除处理过的键 
                iter.remove();
            }
        }
    }
    
    /**
     *连接上事件 
     *
     * @param key
     * @throws IOException
     */
    public void accept(SelectionKey key) throws IOException{
        System.out.println("Selection Key isAcceptable: " + key.isAcceptable());
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = (SocketChannel) ssc.accept();
        System.out.println("Recieved Client Connection:" + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());
        socketChannel.configureBlocking(false);
        
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.register(selector, SelectionKey.OP_READ, buffer);
        System.out.println("SocketChannel register [" + SelectionKey.OP_READ  + "]  to selector");
    }
    
    public void receive(SelectionKey key) throws IOException {
        System.out.println("Selection Key isReadable");
        System.out.println("receive");
        // 获得与客户端通信的信道  
        SocketChannel clientChannel = (SocketChannel) key.channel();  
        // 得到并清空缓冲区  
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();  
        // 读取信息获得读取的字节数  
        long bytesRead = clientChannel.read(buffer);  
        if (bytesRead == -1) {  
            // 没有读取到内容的情况  
            clientChannel.close();  
        } else {  
            // 将缓冲区准备为数据传出状态  
            buffer.flip();  
            // 将字节转化为为UTF-16的字符串  
            String receivedString = Charset.forName("UTF-8").newDecoder()  
                    .decode(buffer).toString();  
            // 控制台打印出来  
            System.out.println("接收到来自"  
                    + clientChannel.socket().getRemoteSocketAddress() + "的信息:"  
                    + receivedString);  
            // 准备发送的文本  
            String sendString = "你好,客户端. @" + new Date().toString()  
                    + "，已经收到你的信息" + receivedString;  
            buffer = ByteBuffer.wrap(sendString.getBytes("UTF-8"));  
            clientChannel.write(buffer);  
            // 设置为下一次读取或是写入做准备  
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);  
        }  
    }
    
    public void send(SelectionKey key) throws IOException {
        //logger.info("send");
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        buffer.flip(); 
        String data = decode(buffer);
        if (data.indexOf("\r\n") == -1){
            return;
        }
        String outputData = data.substring(0, data.indexOf("\n") + 1);
        System.out.println("outputData: " + outputData);
        ByteBuffer outputBuffer = encode("echo:" + outputData);
        while (outputBuffer.hasRemaining()){
            socketChannel.write(outputBuffer);
        }

        ByteBuffer temp = encode(outputData);
        buffer.position(temp.limit());
        buffer.compact();

        if (outputData.equals("bye\r\n")) {
            key.cancel();
            socketChannel.close();
            System.out.println("Close Client Connection");
        }
    }
    

    public String decode(ByteBuffer buffer) { 
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }

    public ByteBuffer encode(String str) { 
        return charset.encode(str);
    }

    public static void main(String args[]) throws Exception {
        FileServer server = new FileServer();
        server.service();
    }
}


