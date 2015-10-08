/**
 * Taylor Chan's works for practice
 */
package com.cq.jvm;

/**
 * @author taylor
 * @date 2013-3-2
 * @version 1.0
 *
 */
public class PretenureSizeThreshold {
	
	private static final int _1MB =  1024*1024;
	public static void testPretenureSizeThreshold(){
		byte[] allocation = new byte[4*_1MB];
	}
	public static void main(String[] args) {
		testPretenureSizeThreshold();
	}
}
