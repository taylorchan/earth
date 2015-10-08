/**
 * Taylor Chan's works for practice
 */
package com.cq.arithmeticinjava.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taylor
 * @date 2013-3-1
 * @version 1.0
 *
 */
public class FullSort {
	private static void sort(List source,List target,int size){
		if(target.size() == size){
			System.out.println(target);
			return;
		}
		Object obj = null;
		for (int i = 0; i <  source.size(); i++) {
			List newSource = new ArrayList(source);
			List newTarget = new ArrayList(target);
			obj = newSource.remove(i);
			newTarget.add(obj);
			sort(newSource,newTarget,size);
		}
	}
	private static List creatList(){
		List des = new ArrayList(4);
		des.add('a');
		des.add('b');
		des.add('c');
		des.add('d');
		return des;
	}
	
	public static int search(int[] array,int value){
		if(array == null || array.length == 0)
			return -1;
		Arrays.sort(array);
		return Arrays.binarySearch(array, value);
	}
	public static void main(String[] args) {
//		List source = creatList();
//		List des = new ArrayList(source.size());
//		sort(source,des,source.size());
//		int[] array = new int[]{5,4,3,3,1};
//		int j = search(array,3);
		testShort();
	}
	
	public static final void testShort(){
		byte sh = 5;
		try{
			sh+=1;
			System.out.println("try");
		}catch(Exception e){
			System.out.println("exception");
		}finally{
			System.out.println("finally");
		}
	}
}
