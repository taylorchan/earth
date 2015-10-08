/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmatic;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-15
 * @version : 1.0
 */
public class T2 {
    
    public T2() {
        super();
    }
    
    public static void main(String args[]) {
        
    }
    
    public static void search(int[] array){
        int i = 0;
        int half = array.length / 2;
        Map<Integer, Integer> counter =  new HashMap<Integer, Integer>();
        while(i<array.length){
           int tmp =  array[i];
           if(counter.containsKey(tmp)){
               int val = counter.get(tmp) + 1;
               if(val == half +1){
                   System.out.println(tmp);
               }else if(val > half + 1){
                   continue;
               }
               counter.put(tmp, val);
           }else{
               counter.put(tmp, 1);
           }
        }
    }
}


