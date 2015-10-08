/**
 * Taylor Chan's works for practice
 */
package com.cq.arithmeticinjava.recursion;

/**
 * @author taylor
 * @date 2013-3-5
 * @version 1.0
 *
 */
public class UCTest {
	public static void main(String[] args) {
		new child();
	}
}

class Parent{
	/**
	 * 
	 */
	public Parent() {
		System.out.println("to construct parent!");
	}
}

class child extends Parent{
	
	private Delegate d = new Delegate();
	/**
	 * 
	 */
	public child() {
		System.out.println("to construct child");
	}
}

class Delegate{
	/**
	 * 
	 */
	public Delegate() {
		System.out.println("to construct delegate");
	}
}
