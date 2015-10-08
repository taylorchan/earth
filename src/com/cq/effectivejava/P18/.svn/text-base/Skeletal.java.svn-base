/**2012-6-20**/

package com.cq.effectivejava.P18;

//静态导入的使用，主要用于常量的使用
import static com.cq.effectivejava.p19.PhsicalConstantsClass.PI;

import java.util.AbstractList;
import java.util.List;

/**
 * 骨架设计
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-20 陈强新建
 */
public class Skeletal {
    
    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        // 返回匿名内部类，AbstractList作为骨架设计
        return new AbstractList<Integer>() {
            
            @Override
            public Integer get(int i) {
                return a[i];
            }
            
            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }
            
            @Override
            public int size() {
                return a.length;
            }
        };
    }
    
    /**
     * 
     */
    public void test() {
        System.out.println(PI);
    }
    
}
