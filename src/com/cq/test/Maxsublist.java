/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-4-7
 * @version : 1.0
 */
public class Maxsublist {
    
    public Maxsublist() {
        super();
    }
    
    public static List<String> result = new ArrayList<String>();

    private static String str_pattern = "\\s*";
    
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);  
        String s = "";
        while(stdin.hasNext()){
            s = stdin.nextLine();
            for(int i=0; i< exps.length; i++){
                cal_sub(i, exps);
            }
            Iterator<String> it = result.iterator();
            while(it.hasNext()){
                String val = it.next();
                System.out.println(val);
            }
        }
    }
    
    private static void cal_sub(int pos, String[] exps){
        int base = pos;
        int cursor = base + 1;
        char[] tmp_array  = new char[exps.length];
        tmp_array[0] = exps[base].toCharArray()[0]  ;
        int count = 0;
        for(; cursor < exps.length; cursor++){
                String tmp = exps[base];
                if(exps[cursor].compareTo(tmp) > 0){
                    tmp_array[++count] = exps[cursor].toCharArray()[0];
                    base = cursor;
                }
        }
        if(tmp_array.length > 1)
            result.add(String.copyValueOf(tmp_array));
    }
}
