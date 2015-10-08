/**
 * Taylor Chan's works for practice
 */
package com.cq.arithmeticinjava.binarytree;

import sun.org.mozilla.javascript.internal.ast.NewExpression;


/**
 * 红黑树的实现
 * @author taylor
 * @date 2013-3-13
 * @version 1.0
 *
 */
public class RedBlackTree<T extends Comparable<? super T>> {
	
	private static final int RED = 0;
	
	private static final int BLACK = 1;
	
	private RedBlackNode<T> header;
	
	private RedBlackNode<T> nullNode;
	
	
	private RedBlackNode<T> current;
	
	private RedBlackNode<T> parent;
	
	private RedBlackNode<T> grand;
	
	private RedBlackNode<T> great;
	
	/**
	 * construct the tree
	 */
	public RedBlackTree(){
		nullNode = new RedBlackNode<T>(null);
		nullNode.left = nullNode.right = nullNode;
		header = new RedBlackNode<T>(null);
		header.left = header.right = nullNode;
	}
	
	/**
	 * Internal routine which performs as  a single or double rotation
	 * @param data
	 * @param parent
	 * @return
	 */
	private RedBlackNode<T> rotate(T item,RedBlackNode<T> parent){
		if(compare(item,parent) < 0)
			return parent.left = compare(item,parent.left) <0 ?
					rotateWithLeftChild(parent.left) :	rotateWithRightChild(parent.left);
		else
			return parent.right = compare(item,parent.right) <0 ?
								rotateWithLeftChild(parent.right) :rotateWithRightChild(parent.right);
	}
	
	/**
	 * if a node has two red children,Performs flip and rotation
	 * @param item
	 */
	private void handleReorient(T item){
		
	}
    
    /**
     * 将k2节点的左孩子向右单旋转,k1为k2的左孩子
     * 
     *
     * @param k2 最初的根节点
     * @return 新的根节点的引用(k1)
     */
    private RedBlackNode<T> rotateWithLeftChild(RedBlackNode<T> k2){
    	RedBlackNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
   
    
    /**
     * 将k1节点的右孩子从右向左的单旋转,k2为k1的右孩子
     *
     * @param k2
     * @return 新根的引用(k2)
     */
    private RedBlackNode<T> rotateWithRightChild(RedBlackNode<T> k1){
    	RedBlackNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
	
	/**
	 * 
	 * @param data
	 * @param t
	 * @return
	 */
	private int compare(T data,RedBlackNode<T> t){
		if(t == header)
			return 1;
		else
			return data.compareTo(t.data);
	}

	private static class RedBlackNode<T>{
		
		T data;
		
		RedBlackNode<T> left;
		
		RedBlackNode<T> right;
		
		int color;
		
		/**
		 * 
		 */
		RedBlackNode(T data) {
			this(null,null,data);
		}
		
		/**
		 * 
		 */
		RedBlackNode(RedBlackNode<T> left,RedBlackNode<T> right, T data) {
			this.left = left;
			this.right = right;
			this.data = data;
			this.color = BLACK;
		}
	}
}
