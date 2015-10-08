/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmatic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-15
 * @version : 1.0
 */
public class HuiWen {
    
    public HuiWen() {
        super();
    }
    
    private static List<String> getSubString(String str){
        if(null ==  str) return new ArrayList<String>();
        int len = str.length();
        List<String> subList = new ArrayList<String>();
        String tmp = null;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len + 1; j++){
                tmp = str.substring(i, j);
                if(isReverse(tmp)){
                    subList.add(tmp);
                }
            }
        }
        return subList;
    }
    
    private static boolean isReverse(String str){
        if(null == str) return false;
        int len = str.length();
        for(int i=0, j = len-1; i<j; i++, j--){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            if(ch1 != ch2) return false;
        }
        return true;
    }
    
    public static String maxLenRevSub(String str){
        List<String> subs = getSubString(str);
        Iterator<String> iter = subs.iterator();
        String tmp = null;
        int maxLen = 0;
        String ret = "";
        while(iter.hasNext()){
            tmp = iter.next();
            int len = tmp.length();
            if(len > maxLen){
                maxLen = len;
                ret  = tmp;
            }
        }
        return ret;
    }
    
    public static void main(String args[]) {
        String str = "oxoxo";
        System.out.println(maxLenRevSub(str));
    }
}
