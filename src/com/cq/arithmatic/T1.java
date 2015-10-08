/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmatic;


/**
 * 全排列问题
 * @author:   Taylor Chan
 * @since:    2015-9-15
 * @version : 1.0
 */
public class T1<E>{    
    public T1() {
        super();
    }
    
    private void swap(E[] _array, int i, int j){
        E tmp = _array[i];
        _array[i] = _array[j];
        _array[j] =tmp;
    }
    
    private void permutation(E[] array, int start, int end){
        int i,j;  
        if(start == end){  
            for(i=0; i<=end; i++)  
               System.out.print(array[i]);
            System.out.println();
        }else{  
            for(j=start; j<=end; j++){  
                swap(array,  j, start);  
                permutation(array, start+1, end);  
                swap(array,  j, start);  
            }  
        }  
    }
    
    public static void main(String args[]) {
        String[] strArray = {"A","B","C", "D"};
       new T1().permutation(strArray, 0, strArray.length - 1);
    }
}
