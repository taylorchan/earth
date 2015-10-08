/**2012-3-18**/

package com.cq.thinkinjava.chapter18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-18 陈强新建
 */
public class WriteOrReadObj {
    
    private static String file = "f:/studentData.dat";
    
    public static void readObj() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
        Student s[] = (Student[]) objIn.readObject();
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        
    }
    
    public static void writeObj() throws FileNotFoundException, IOException {
        Student s = new Student(1, "zhangsan", "femal", 20);
        Student s2 = new Student(2, "lisi", "mal", 30);
        Student s3[] = { s, s2 };
        File f = new File(file);
        ObjectOutputStream objStream = new ObjectOutputStream(new FileOutputStream(f));
        objStream.writeObject(s3);
        // objStream.writeObject(s2);
        objStream.close();
    }
    
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {
        writeObj();
        readObj();
        // Student s = new Student(3, "wanger", "male", 23);
        // File f = new File(file);
        // ObjectOutputStream objStream = new ObjectOutputStream(new
        // FileOutputStream(f));
        // objStream.
    }
    
}
