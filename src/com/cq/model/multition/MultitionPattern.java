/**2012-5-17**/

package com.cq.model.multition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 这里实现有上限的多例模式
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-17 陈强新建
 */
public class MultitionPattern {
    
    // 上限
    private static final int maxnum = 2;
    
    private static List<MultitionPattern> ls = new ArrayList<MultitionPattern>(2);
    
    static {
        int i = 0;
        while (i < maxnum) {
            ls.add(new MultitionPattern("this is NO:" + i + "instance"));
        }
        
    }
    
    private String id;
    
    private MultitionPattern() {
    }
    
    private MultitionPattern(String id) {
        this.id = id;
    }
    
    public static MultitionPattern getInstance() {
        Random rd = new Random();
        int num = rd.nextInt(maxnum);
        return ls.get(num);
    }
    
    @Override
    public String toString() {
        return this.id;
        
    }
    
    public static void main(String args[]) {
        MultitionPattern ml = MultitionPattern.getInstance();
        System.out.println(ml);
    }
}
