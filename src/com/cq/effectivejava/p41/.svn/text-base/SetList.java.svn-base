/**2012-6-24**/

package com.cq.effectivejava.p41;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
public class SetList {
    
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> ls = new ArrayList<Integer>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            ls.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            // ls.remove(i);// 注意此方法进行了重载
            ls.remove(Integer.valueOf(i));
        }
        System.out.println(set + "\n" + ls);
        // [-3, -2, -1]
        // [-2, 0, 2]
    }
}
