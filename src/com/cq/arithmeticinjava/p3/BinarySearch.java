/**2012-7-12**/

package com.cq.arithmeticinjava.p3;


/**
 * @author Taylor Chan
 * @since 1.0
 * @version 2012-7-12 Taylor Chan Creat
 */
public class BinarySearch {
    
    /**
     * @param <T>
     * @param array 已经排序过的数组
     * @param t 待查找的元素
     * @return
     */
    public static <T extends Comparable<? super T>> int binarySearch(T[] array, T t) {
        assert array != null;
        int low = 0;
        int height = array.length - 1;
        int mid = 0;
        while (low <= height) {
            mid = (low + height) / 2;
            if (array[mid].compareTo(t) > 0)
                height = mid - 1;
            else if (array[mid].compareTo(t) < 0)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Integer[] array = { 1, 3, 5, 7, 9 };
    }
}
