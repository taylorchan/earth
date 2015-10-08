/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-5-4
 * @version : 1.0
 */
public class Count {
    
    public Count() {
        super();
    }
    
    private static int count(){
        int base1 = 1;
        int base2 = 5;
        int base3 = 10;
        int count = 0;
        for(int size1 = 100;size1>=0;size1--){
            for(int size2 = 0;size2<=20;size2++){
                    for(int size3=0; size3<=10;size3++){
                        if(base1 * size1 + base2 * size2 + base3 * size3 == 100){
                            count++;
                        }
                    }
            }
        }
        return count;
    }
    
    public static void main(String args[]) {
        System.out.println(count());
        
    }
}
