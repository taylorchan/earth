/**2012-3-17**/

package com.cq.thinkinjava.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-17 ��ǿ�½�
 */
public class Practice8 {
    
    public static void readFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        List<String> ls = new LinkedList<String>();
        while ((s = br.readLine()) != null) {
            ls.add(s);
        }
        br.close();// ��һ��Ҫ�ر�
        ListIterator it = ls.listIterator();
        while (it.hasNext()) {
            it.next();
        }
        while (it.hasPrevious()) {
            s = (String) it.previous();
            System.out.println(s.toUpperCase());
        }
    }
    
    public static void main(String arg[]) throws IOException {
        // BufferedReader br = new BufferedReader(br);
        // InputStreamReader(System.in));
        // String fileName = br.readLine();
        // br.close();
        String fileName = "f:/practice.txt";
        if (null != fileName) {
            readFile(fileName);
        }
    }
}
