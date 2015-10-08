/**2012-7-2**/

package com.cq.arithmeticinjava.p3;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-7-2 陈强新建
 */
public class BasicSort {
    
    private static void swap(int[] array, int num1, int num2) {
        int temp = array[num2];
        array[num2] = array[num1];
        array[num1] = temp;
    }
    
    /**
     * 冒泡排序,每次循环将最大的元素放到最后去
     * 
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int size = array.length;
        for (int j = size - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1])
                    swap(array, i, i + 1);
            }
        }
        
    }
    
    /**
     * 选择排序，假定某个位置为最小的元素，后面的元素若是比它大，则交换，每次循环将最小的元素放到最前面
     * 
     * @param array
     */
    public static void selectionSort(int[] array) {
        int out, in;
        for (out = 0; out < array.length; out++) {
            for (in = out + 1; in < array.length; in++) {
                if (array[in] < array[out]) {
                    swap(array, in, out);
                }
            }
        }
    }
    
    /**
     * 从index =1开始，将前面的视为已经排序好了的数组，若该点的元素较前面的小，则依次移动前面所有的元素，直到无法移动为止--- 插入排序
     * (交换次数最小)
     * 
     * @param array
     */
    public static void insertionSort(int[] array) {
        // 插入的时候遍历的节点位置
        int startPos;
        // 当前的位置
        int curPos;
        for (startPos = 1; startPos < array.length; startPos++) {
            int temp = array[startPos];
            curPos = startPos;
            while (curPos > 0 && array[curPos - 1] >= temp) {
                array[curPos] = array[curPos - 1];
                curPos--;
            }
            // 很重要
            array[curPos] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] array = { 10, 9, 8, 7, 6, 5, 4 };
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
