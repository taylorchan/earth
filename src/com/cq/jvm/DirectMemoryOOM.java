/**
 * Taylor Chan's works for practice
 */
package com.cq.jvm;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author taylor
 * @date 2013-3-2
 * @version 1.0
 *
 */
public class DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String args[]){
		 Field theUnsafe = null;
		try {
			theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	     theUnsafe.setAccessible(true);  
	 	Unsafe UNSAFE = null;
	     try {
			 UNSAFE = (Unsafe) theUnsafe.get(null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		while(true){
			UNSAFE.allocateMemory(_1MB);
		}
				
	}
}
