/**
 * Taylor Chan's works for practice
 */
package com.cq.arithmeticinjava.binarytree;


/**
 * @author taylor
 * @date 2013-3-11
 * @version 1.0
 *
 */
public class TreeNode<T> {
    
    T data;
    
    TreeNode<T> left;
    
    TreeNode<T> right;
    
    public TreeNode(T _data, TreeNode<T> _left, TreeNode<T> _right){
    	data = _data;
    	left = _left;
    	right=_right;
    }
    
    @Override
    public String toString() {
        return data.toString() + ", ";
    }
}
