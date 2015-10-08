/**2012-4-30**/

package com.cq.thinkinjava.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-4-30 陈强新建
 */
public class ParamCast {
    
    private static volatile List lst = new ArrayList();
    
    private void f(int ch) {
        System.out.println(ch);
    }
    
    private void chageString(String s) {
        s = "ggggggg";
    }
    
    private void chageInt(int s) {
        s = 0;
    }
    
    private void changeList(List s) {
        s = null;
    }
    
    public static void main(String args[]) {
        char i = 5;
        new ParamCast().f(i);
        String s = "adbdgd";
        new ParamCast().chageString(s);
        System.out.println(s);
        new ParamCast().chageInt(i);
        System.out.println(i);
        List ls = new ArrayList();
        ls.add(i);
        ls.add(s);
        new ParamCast().changeList(lst);
        System.out.println(lst.size());
        String ws[][] = new String[2][3];
        Integer[] in = { new Integer(1), new Integer(2), 3, };
        System.out.println(Arrays.toString(in));
        System.out.println(in.length);
    }
}
