/**2012-5-25**/

package com.cq.model.builder;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 套餐类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Food {
    
    Hashtable<String, String> food = new Hashtable<String, String>();
    
    /**
     * @param strName
     * @param Price
     */
    public void Add(String strName, String Price) {
        food.put(strName, Price);
    }
    
    /**
     * 
     */
    public void Show() {
        System.out.println("Food List:");
        System.out.println("------------------------------");
        for (Enumeration e = food.elements(); e.hasMoreElements();) {
            System.out.println(e.nextElement());
        }
        System.out.println("\n------------------------------");
    }
    
}
