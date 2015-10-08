/**
 * Taylor Chan's works for practice
 */
package com.cq.arithmeticinjava.heap;


/**
 * 将二叉堆只叫做堆,跟二叉树类似,其存在 结构性 和 堆序性.
 * 堆是一棵被完全填满的二叉树
 * 二叉堆又叫做 2-堆
 * @author taylor
 * @date 2013-3-13
 * @version 1.0
 *
 */
public class BinaryHeap <T extends Comparable<? super T>>{
	
	
	private T[] array;
	
	private int currentSize;
	
	private static final int INITIALIZE = 10;
	

	/**
	 * index start from 1
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		array = (T[])new Object[INITIALIZE];
		currentSize = 0;
	}
	
	/**
	 * 从已经存在的数据源构造堆
	 * @param items
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap(T[] items){
		array = (T[])new Object[items.length +1];
		System.arraycopy(items, 0, array, 1, items.length);
		buildHeap();
		currentSize = items.length;
	}
	
	/**
	 * 插入到一个堆的过程
	 * @param ele
	 */
	public void insert(T ele){
		if(currentSize == array.length -1)
			enlargeArray(array.length * 2 +1);
		int hole = ++ currentSize;//空穴的位置
		for(;hole >1 && ele.compareTo(array[hole/2]) <0;hole = hole/2)//空穴进行上滤(percolate up)的过程,hole每次变小
			array[hole] = array[hole/2];
		array[hole] = ele;
	}
	
	/**
	 * 删除根节点
	 * @return
	 */
	public T deleteMin(){
		if(isEmpty())
			return null;
		T min = findMin();
		if(min == null)
			return null;
		
		array[1] = array[currentSize -1];
		percolateDown(1);
		return min;
	}
	
	/**
	 * 
	 */
	private void buildHeap(){
		for(int i = currentSize/2;i>0;i--){
			percolateDown(i);
		}
	}
	
	/**
	 * 下滤动作
	 * @param hole
	 */
	private void percolateDown(int hole){
		int child = 1;
		T temp = array[hole];
		for(;hole *2 < currentSize;hole = child){
			child = hole *2;
			if(child != currentSize && array[child +1].compareTo(array[child]) <0)
				child +=1;
			if(array[child].compareTo(array[hole]) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = temp;
	}
	
	/**
	 *find the min value in the heap 
	 * @return
	 */
	private T findMin(){
		if(currentSize == 0)
			return null;
		return array[1];
	}
	
	private void enlargeArray(int size){
		assert size > currentSize;
		@SuppressWarnings("unchecked")
		T[] newArray = (T[])new Object[size];
		System.arraycopy(array, 0, newArray, 0, array.length);
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
}
