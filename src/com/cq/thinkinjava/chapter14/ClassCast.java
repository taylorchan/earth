/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.chapter14;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-24
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class ClassCast {
    public static void main(String[] args) {
        List list = new ArrayList();
        Class<ArrayList> listClass = ArrayList.class;
        ArrayList newList = listClass.cast(list);
        //相当于newList = (ArrayList)list;
    }
}
