/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.binarytree;



/**
 * 搜索二叉树,插入数据的时候按照大小排序插入,搜索的时候可实现二分查找,添加删除元素是跟树的深度相关的.在经过多次的增删操作后,
 * 树的深入可能增加很多,从而导致树不平衡.所以平衡的条件为:任何节点的深度不能太深.
 * @author: qiang.chen
 * @since:    2012-7-23
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    
    
    private TreeNode<T> root;
    
    /**
     * 
     */
    public BinarySearchTree() {
        root = null;
    }
    
    public void makeEmpty(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public boolean contains(T data){
        return contains(data,root);
    }
    
    public T findMin(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        return findMin(root).data;
    }
    
    public T findMax(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        return findMax(root).data;
    }
    
    public void insert(T data){
        insert(data, root);
    }
    
    public void remove(T data){
        if(isEmpty()){
            throw new NullPointerException();
        }
        remove(data, root);
        
    }
    /**
     * 相当于二分查找
     *
     * @param data
     * @param localRoot
     * @return
     */
    private boolean contains(T data,TreeNode<T> localRoot){
        if(localRoot == null)
            return false;
        int compareResult = data.compareTo(localRoot.data);
        if(compareResult == 0)
            return true;
        else if(compareResult > 0)
            return contains(data,localRoot.right);
        
        return contains(data, localRoot.left);
    }
    /**
     * 在左子树中搜索
     *
     * @param localRoot
     * @return
     */
    private TreeNode<T> findMin(TreeNode<T> localRoot){
        if(localRoot == null)
            return null;
        if(localRoot.left == null)
            return localRoot;
        return findMin(localRoot.left);
    }
    /**
     * 在右子树中搜索最大值
     *
     * @param localRoot
     * @return
     */
    private TreeNode<T> findMax(TreeNode<T> t){
    	if(t != null)
    		while(t.right != null)
    			t = t.right;
    	return t;
    }
    
    /**
     * 插入元素，可以明确的是，插入的元素肯定是在叶子节点的位置
     *
     * @param data
     * @param t
     * @return the new root of the tree
     */
    private TreeNode<T> insert(T data,TreeNode<T> t){
        TreeNode newNode = new TreeNode<T>(data, null, null);
        if(t == null)//根为空的情况下，直接插入元素
             return newNode;
        int compare = data.compareTo(t.data);
        if(compare < 0)
           t.left = insert(data, t.left);
            
        else if(compare > 0)
            t.right = insert(data,t.right);
        else
            ;//duplicated, do nothing
        return t;
    }
    /**
     * 
     *
     * @param data
     * @param t
     * @return return the new root of the tree
     */
    private TreeNode<T> remove(T data,TreeNode<T> t){
        if(t == null)
            return null;
        int compare = data.compareTo(t.data);
        if(compare < 0)            
            t.left = remove(data, t.left);
        
        else if(compare > 0)
            t.right  = remove(data, t.right);
        
        else if(t.left != null && t.right != null){//有两个子节点，找到右子树的最小节点，来顶替原来的节点
            t.data = findMin(t.right).data;
            t.right = remove(t.data, t.right);
          
        }else
            t = (t.left != null)?t.left:t.right;//删除了该节点后，用左子树或者右子树来代替（删除过程，直接将自身改为下个节点的引用）
            
        return t;
    }
}
