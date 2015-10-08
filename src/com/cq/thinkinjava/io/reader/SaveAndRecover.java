/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.reader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-14
 * @version : 1.0
 */
public class SaveAndRecover {
    
    
    public static void useDataStream(String name){
        DataOutputStream dos = null;
        try {
             dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(name)));
             dos.writeUTF("this is pai:");
             dos.writeDouble(3.1415926);
             dos.writeUTF("square out of r");
             dos.close();
             DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(name)));
             System.out.println(dis.readUTF());
             System.out.println(dis.readDouble());
             System.out.println(dis.readUTF());
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String filename = "d:/Daily_log.txt";
        useDataStream(filename);
    }
}
