/**2012-3-17**/

package com.cq.thinkinjava.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-17 陈强新建
 */
public class Practice16 {
    
    private static String file = "f:/practice2.java";
    
    public static void saveData(String file) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeBoolean(false);
        rf.writeByte(0);
        rf.writeBytes("this is write bytes!");
        rf.writeChar(12);
        rf.writeChars("this is chars");
        rf.writeDouble(3.1415);
        rf.writeFloat(4.3333f);
        rf.writeInt(1);
        rf.writeLong(700l);
        rf.writeShort(22);
        rf.writeUTF("utf zifuchuan");
        rf.close();
    }
    
    public static void main(String ar[]) throws IOException {
        saveData(file);
    }
}
