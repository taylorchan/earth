/**
 * Taylor Chan's works for practice
 */
package com.cq.arithmeticinjava.fullsort;

/**
 * @author taylor
 * @date 2013-3-13
 * @version 1.0
 *
 */
public class SimpletSort {
	
	/**
	 * 从数组的index = 1开始,假设这个index之前的元素均已经排序完成,只需要将index位置的元素插入到已经排序好的元素的适当的位置即可.
	 * 插入排序
	 * @param array
	 */
	public static<T extends Comparable<? super T >> void insertionSort(T[] array){
		if(array.length == 0 || array == null)
			return;
		int j = 0;
		T temp = null;
		for(int p = 1,k = array.length;p<k;p++){//遍历数组从index = 1位置开始
			temp  = array[p];
			for(j = p;j>0 && temp.compareTo(array[j-1])<0;j--)//循环条件:后面的元素小于前面的元素,这个时候需要赋值,相当于 挪动 并 插入,
				//到需要插入的位置,停止循环
				array[j] = array[j-1];
			array[j] = temp;
		}
	}
	
	/**
	 *  希尔排序
	 *  gap为增量序列,gap的初始值为[gap/2]
	 * @param array
	 */
	public static<T extends Comparable<? super T >> void shellSort(T[] array){
		if(array.length == 0 || array == null)
			return;
		int length = array.length;
		int j = 0;
		T temp = null;
		for(int gap = length/2; gap>0; gap = gap/2){
			for(int i = gap; i<length; i++){
				temp = array[i];
				for(j=i; j>=gap && temp.compareTo(array[j-gap]) < 0; j = j-gap)
					array[j] = array[j-gap];
				array[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		Integer array[] = new Integer[]{34,8,64,32,21,5};
		insertionSort(array);
	}
}
