/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-18
 * @version : 1.0
 */
public class AvilableCharset {
    
    public static void main(String[] args) {
        Map<String,Charset> charset = Charset.availableCharsets();
        Iterator<String> iter = charset.keySet().iterator();        
        while(iter.hasNext()){
            String key = iter.next();
            System.out.print(key + ": ");
            Iterator<String> temp = charset.get(key).aliases().iterator();
            while(temp.hasNext()){
                System.out.print(temp.next());
                System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println(System.getProperty("file.encoding"));
    }
}
