/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * 内存映射文件，对大文件的读写操作
 * @author:   qiang.chen
 * @since:    2012-12-18
 * @version : 1.0
 */
public class LargeMappedFile {
    private static  final int SIZE = 0x8ffffff;
    
    
    
    public static void readFile(String path){
        try {
            MappedByteBuffer mbb = new RandomAccessFile(path,"rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, SIZE);
            for (int i = 0; i < SIZE; i++) {
                mbb.put((byte)'x');
            }
            System.out.println("finished write");
            for (int i = SIZE/2; i < SIZE/2 + 6; i++) {
                System.out.println((char)mbb.get(i));
            }
            
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    public static void main(String[] args) {
        
    }
}
