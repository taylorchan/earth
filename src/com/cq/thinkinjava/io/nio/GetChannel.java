/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-17
 * @version : 1.0
 */
public class GetChannel {
    
    
    public static void rwFileWithChannel(String file){
        try {
            FileChannel fc = new FileOutputStream(file).getChannel();
            fc.write(ByteBuffer.wrap("fileChannel test\n".getBytes(Charset.forName("utf-8"))));
            fc.close();
            
            fc = new RandomAccessFile(file, "rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("fileChannel test line2\n".getBytes(Charset.forName("utf-8"))));
            fc.close();
            
            fc = new FileInputStream(file).getChannel();
            
            ByteBuffer bf = ByteBuffer.allocate(1024);
            fc.read(bf);
            bf.flip();
            long index = 0L;
            while(bf.hasRemaining()){
                System.out.println("index: "+ ++index);
                System.out.println((char)bf.get());
            }
            fc.close();
      
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void rwFileWithChannel2(String file){
        try {
            FileChannel fc = new FileOutputStream(file).getChannel();
            fc.write(ByteBuffer.wrap("fileChannel test\n".getBytes(Charset.forName("utf-8"))));
            fc.close();
            
            fc = new RandomAccessFile(file, "rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("fileChannel test line2\n".getBytes(Charset.forName("utf-8"))));
            fc.close();
            
            fc = new FileInputStream(file).getChannel();
            
            ByteBuffer bf = ByteBuffer.allocate(1024);
            fc.read(bf);
            bf.flip();
            while(bf.hasRemaining()){
                System.out.print(bf.asCharBuffer());
            }
            fc.close();
      
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String strFile = "d:/Daily_log.txt";
        rwFileWithChannel2(strFile);
    }
            
            
            
            
            
            
            
            
            
      
        
    
}
