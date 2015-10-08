/**
 * Taylor Chan's works for practice
 */
package com.cq.arithmeticinjava.tree;

/**
 * 树的父节点表示法,每个节点记录其父节点,所有的节点存储在数据中,记录的节点为其父节点在数组中的位置
 * @author taylor
 * @date 2013-2-21
 * @version 1.0
 *
 */
public class TreeParent<E> {
	private static class Node<E>{
		E data;
		private int parent;
		
		/**
		 * 
		 */
		public Node(E data) {
			this.data = data;
		}
		
		public Node(E data,int parent){
			this.data = data;
			this.parent = parent;
		}
	}
}
