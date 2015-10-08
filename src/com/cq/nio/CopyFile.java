/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-9-6
 * @version : 1.0
 */
public class CopyFile {
    public static void copyFile(String src,String des){
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
           fin = new FileInputStream(src);
           fout = new FileOutputStream(des);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        FileChannel fcin = fin.getChannel();
        FileChannel fco = fout.getChannel();
        ByteBuffer bytebuffer = ByteBuffer.allocate(1024);
        try {
            while(true){
                // clear方法清空缓冲区中的数据(limit = capacity,position = 0,mark = -1)，使它可以接受读入的数据  
                bytebuffer.clear();  
                // 从输入通道中将数据读到缓冲区  
                int r = fcin.read(bytebuffer);  
                // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1  
                if (r == -1) {  
                    break;  
                }  
                // flip方法让缓冲区可以将新读入的数据写入另一个通道  
                //(limit = position,position = 0,mark = -1),通过limit可以获取数据的大小
                bytebuffer.flip();  
                // 从输出通道中将数据写入缓冲区  
                fco.write(bytebuffer);  
                
            }
        }catch(IOException e){
            
            
        }
    }
}
