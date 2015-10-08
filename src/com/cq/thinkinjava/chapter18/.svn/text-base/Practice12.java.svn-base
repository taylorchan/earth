/**2012-3-17**/

package com.cq.thinkinjava.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-17 陈强新建
 */
public class Practice12 {
    
    public static List readFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        List<String> ls = new LinkedList<String>();
        while ((s = br.readLine()) != null) {
            ls.add(s);
        }
        br.close();// 打开一定要关闭
        return ls;
    }
    
    public static void writeFile(String name, List ls) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(name));
        int linec = 0;
        Iterator it = ls.iterator();
        while (it.hasNext()) {
            // System.out.println(++linec + ":" + it.next());
            bw.write(++linec + ":" + it.next() + "/r/n");
        }
        bw.close();
        
    }
    
    public static void main(String arg[]) throws IOException {
        // BufferedReader br = new BufferedReader(br);
        // InputStreamReader(System.in));
        // String fileName = br.readLine();
        // br.close();
        String fileName1 = "f:/practice1.txt";
        String fileName2 = "f:/practice2.java";
        if (null != fileName1) {
            
            writeFile(fileName2, readFile(fileName1));
            // /readFile(fileName);
        }
    }
}
