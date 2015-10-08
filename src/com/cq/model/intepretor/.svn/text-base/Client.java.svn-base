/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class Client {
    
    public static void main(String args[]) {
        
        String str1 = "a+b";
        String str2 = "a-b";
        Map<String, Integer> map = new HashMap<String, Integer>(5);
        map.put("a", 3);
        map.put("b", 4);
        
        Calculator cal = new Calculator(str2);
        System.out.println(str2 + cal.run(map));
        
    }
}
