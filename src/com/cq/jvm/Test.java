/**2012-3-23**/

package com.cq.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *全排列问题
 * @author 
 * @since 1.0
 * @version 2012-3-23 
 */
public class Test {
    
    public static void main(String args[]) {
        int i = 1;
        int j = 2;
        if (i == 1 || j == 2) {
            System.out.println("ok1");
        }
        int[] a = { 1, 2, 3, 4, 5 };
        
        String[] s = new String[]{"a","b","c","d"};
        List ls = Arrays.asList(s);
        sort(ls,new ArrayList(),ls.size());
        
        
       
    }
    
    public static void showSort(int[] args) {
        int flag1, flag2, flag3, flag4, flag5;
        int temp[];
        List ls = new ArrayList();
        for (flag1 = 0; flag1 < args.length; flag1++) {
            temp = new int[5];
            temp[0] = args[flag1];
            for (flag2 = 0; flag2 < args.length; flag2++) {
                if (flag2 == flag1)
                    continue;
                temp[1] = args[flag2];
                for (flag3 = 0; flag3 < args.length; flag3++) {
                    if (flag3 == flag1 || flag3 == flag2)
                        continue;
                    temp[2] = args[flag3];
                    for (flag4 = 0; flag4 < args.length; flag4++) {
                        if (flag4 == flag3 || flag4 == flag2 || flag4 == flag1)
                            continue;
                        temp[3] = args[flag4];
                        for (flag5 = 0; flag5 < args.length; flag5++) {
                            if (flag5 == flag3 || flag5 == flag2 || flag5 == flag1 || flag5 == flag4)
                                continue;
                            temp[4] = args[flag5];
                            ls.add(temp.clone());
                        }
                    }
                }
            }
        }
        for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
            int[] i = (int[]) iterator.next();
            for (int j = 0; j < i.length; j++) {
                System.out.print(i[j]);
            }
            System.out.println();
        }
        
    }
    
    
    private static void sort(List data,List target,int size){
    	if (target.size() == size) {  
            for (Object obj : target)  
                System.out.print(obj);  
            System.out.println();  
            return;  
        }  
    	for (int j = 0; j < data.size(); j++) {
    		List newData = new ArrayList(data);
    		List newTarget = new ArrayList(target);
    		newTarget.add(newData.get(j)); 
    		 newData.remove(j); 
    		sort(newData,newTarget,size);
		}
    }
  
}
