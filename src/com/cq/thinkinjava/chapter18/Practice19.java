/**2012-3-18**/

package com.cq.thinkinjava.chapter18;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.mindview.util.BinaryFile;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-18 陈强新建
 */
public class Practice19 {
    
    private static String fi = "F:/practice1.txt";
    
    public static void main(String args[]) throws IOException {
        byte[] by = BinaryFile.read(fi);
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        Integer temp;
        for (int i = 0; i < by.length; i++) {
            temp = map.get(by[i]);
            if (null == temp) {
                map.put(by[i], 1);
                continue;
            }
            map.put(by[i], ++temp);
        }
        System.out.println(map);
        
    }
}
