/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.nio.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-24
 * @version : 1.0
 */
public class EchoClient {

    private SocketChannel socketChannel = null;
    
    private ByteBuffer sendBuffer = ByteBuffer.allocate(32 * 1024);
    
    private ByteBuffer receiveBuffer = ByteBuffer.allocate(32 * 1024);
    
    private Charset charset = Charset.forName("UTF-8");
    
    private Selector selector;
    
    private AtomicBoolean isSend = new AtomicBoolean(false);
    
    public EchoClient() throws IOException {
        socketChannel = SocketChannel.open();
        InetAddress ia = InetAddress.getLocalHost();
        InetSocketAddress isa = new InetSocketAddress(ia, 8050);
        socketChannel.connect(isa);
        socketChannel.configureBlocking(false);
        log("Client: connection establish[" + isa.getHostName() + ":" + isa.getPort() + "]", false);
        selector = Selector.open();
    }

    public static void main(String args[]) throws IOException {
        final EchoClient client = new EchoClient();
        Thread receiver = new Thread() {
            public void run() {
                client.receiveFromUser();
            }
        };

        receiver.start();
        client.talk();
    }

    public void receiveFromUser() {
        try {
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localReader.readLine()) != null) {
                log("Read From System Console: " + msg, false);
                isSend.getAndSet(true);
                log("Command line thread set isSend: " + isSend, false);
                synchronized (sendBuffer) {
                    sendBuffer.put(encode(msg + "\r\n"));
                }
                if (msg.equals("bye")){
                    log("Client Exit", false);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void talk() throws IOException {
        log("SocketChannel register [" + SelectionKey.OP_READ  + "] and [" + SelectionKey.OP_WRITE + "] to selector", false);
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        while (selector.select() > 0) {
            Set readyKeys = selector.selectedKeys();
            Iterator it = readyKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = null;
                try {
                    key = (SelectionKey) it.next();
                    it.remove();

                    if (key.isReadable()) {
                        receive(key);
                    }
                    if (key.isWritable()) {
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
            }
        }
    }

    public void send(SelectionKey key) throws IOException {
        if(!isSend.get()) {
            return;
        }
        SocketChannel sc = (SocketChannel) key.channel();
        synchronized (sendBuffer) {
            sendBuffer.flip(); 
            sc.write(sendBuffer);
            sendBuffer.compact();
        }
        isSend.getAndSet(false);
        log("Send method set isSend: " + isSend, false );
    }

    public void receive(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        sc.read(receiveBuffer);
        receiveBuffer.flip();
        String receiveData = decode(receiveBuffer);

        if (receiveData.indexOf("\n") == -1){
            return;
        }

        String outputData = receiveData.substring(0, receiveData.indexOf("\n") + 1);
        log("Recieve Data: " + outputData, false);
        if (outputData.equals("echo:bye\r\n")) {
            key.cancel();
            socketChannel.close();
            System.out.println("Exit");
            selector.close();
            System.exit(0);
        }

        ByteBuffer temp = encode(outputData);
        receiveBuffer.position(temp.limit());
        receiveBuffer.compact();
    }

    public String decode(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }

    public ByteBuffer encode(String str) { 
        return charset.encode(str);
    }
    
    public void log(String msg, boolean err) {
        String type = err ? "[WARN]" : "[INFO]";
        msg = new Date() + " --> " + type + " " + msg;
        System.out.println(msg);
    }
}