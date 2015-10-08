/**
 * Taylor Chan's works for practicef
 */
package com.cq.arithmeticinjava.recursion;

/**
 * @author taylor
 * @date 2013-3-1
 * @version 1.0
 *
 */
public class Hanio {
	private static void hannio(int n,String A,String B,String C){
		if(n>0){
			hannio(n-1,A,C,B);
			System.out.println("move "+n +"from " + A +" to " + C);
			hannio(n-1,B,C,A);
		}
	}
}
