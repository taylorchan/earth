/**2012-3-18**/

package com.cq.thinkinjava.chapter18;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-18 ��ǿ�½�
 */
public class NioToBaidu {
    
    private final Charset charset = Charset.forName("GBK");// ����GBK�ַ���
    
    private SocketChannel channel;
    
    public void readHTMLContent() {
        try {
            InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 80);
            // step1:������
            channel = SocketChannel.open(socketAddress);
            // step2:��������ʹ��GBK����,writeд���ʱ����Ҫ���루bufferbyte��ֻ�ܴ洢�ֽ��룩
            channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));
            // step3:��ȡ����
            ByteBuffer buffer = ByteBuffer.allocate(1024);// ����1024�ֽڵĻ���
            while (channel.read(buffer) != -1) {
                buffer.flip();// flip�����ڶ��������ֽڲ���֮ǰ���á�
                System.out.println(charset.decode(buffer));
                // ʹ��Charset.decode�������ֽ�ת��Ϊ�ַ���
                buffer.clear();// ��ջ���
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new NioToBaidu().readHTMLContent();
    }
}
