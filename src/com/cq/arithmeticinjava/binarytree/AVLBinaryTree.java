/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.binarytree;




/**
 * Adelson-Velskii and Landis Tree,带有平衡条件的 搜索二叉树
 * 自平衡二叉查找树
 * @author: qiang.chen
 * @since:    2012-7-24
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class AVLBinaryTree<T extends Comparable<? super T>> {
	
	private static class AvlNode<T> extends TreeNode<T>{
		/**
		 * 保存其height很重要
		 */
		private int height = 0;
		/**
		 * @param _data
		 * @param _left
		 * @param _right
		 */
		AvlNode(T _data, TreeNode<T> _left, TreeNode<T> _right) {
			super(_data, _left, _right);
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
		
	}
    
    
    private AvlNode<T> root;
    
    private int height(AvlNode<T> t){
        
        return t == null ? -1 : t.height;
    }
    
    public AVLBinaryTree(){
        root = null;
    }
    
    /**
     * 插入元素
     *
     * @param data
     * @param t
     * @return the new root of the tree
     */
    public AvlNode<T> insert(T data,AvlNode<T> t){
        AvlNode newNode = new AvlNode<T>(data, null, null);
        if(t == null)//根为空的情况下，直接插入元素
             return newNode;
        int compare = data.compareTo(t.data);
        if(compare < 0){
            t.left = insert(data, (AvlNode)t.left);
            if(height((AvlNode)t.left) - height((AvlNode)t.right) ==2){//左子树的高度高于了右子树,需要从左向右旋转
                if(data.compareTo(t.left.data) < 0)
                    t = rotateWithLeftChild(t);
                else
                    t = doubleWithLeftChild(t);
            }
        }
            
        else if(compare > 0){
            t.right = insert(data,(AvlNode)t.right);
            if(height((AvlNode)t.right) - height((AvlNode)t.left) == 2){
                if(data.compareTo(t.right.data) > 0)
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
            }
            
        }
        else
            
            ;//duplicated, do nothing
        t.height = Math.max(height((AvlNode)t.left), height((AvlNode)t.right)) + 1;//每次添加结点的时候,都会更新其height
        return t;
    }
    
    /**
     * 将k2节点的左孩子向右单旋转,k1为k2的左孩子
     * 
     *
     * @param k2 最初的根节点
     * @return 新的根节点的引用(k1)
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
        
        AvlNode<T> k1 = (AvlNode)k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height((AvlNode)k2.left),height((AvlNode)k2.right)) + 1;
        k1.height = Math.max(height((AvlNode)k1.left), k2.height)+1;
        return k1;
        
    }
   
    
    /**
     * 将k1节点的右孩子从右向左的单旋转,k2为k1的右孩子
     *
     * @param k2
     * @return 新根的引用(k2)
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1){
        AvlNode<T> k2 =(AvlNode) k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height((AvlNode)k1.left),height((AvlNode)k1.right)) + 1;
        k2.height = Math.max(k1.height, height((AvlNode)k2.right))+1;
        return k2;
    }
    
    /**
     * 从左向右的双旋转
                              
                                   K3
                                  *  * 
                                 *    *
                                K1     D
                               *  *
                              *     *
                             A        k2
     *                                *  *
     * @param k3             *    *
     *                              B       C
     *                              
     *    先对k3 的左孩子(k1)执行从右向左的旋转
     *    再对k3执行左孩子从左到右的旋转
     * @return 新的根节点的引用
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3){
        
        k3.left = rotateWithRightChild((AvlNode)k3.left);
        return rotateWithLeftChild(k3);
        
    }
    
    /**
     * 从左向右的双旋转                               k1
     *                       							 *  *
     * @param k2          						*    *
                            						 A      K3
     												*  * 
     														*    *
                                				K2     D
     											*  *
     													*     *
                             B        C
     * @return
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1){
        
        k1.right = rotateWithLeftChild((AvlNode)k1.right);
        return rotateWithRightChild(k1);
        
    }

    public static void main(String[] args) {
        AVLBinaryTree<Integer> avlTree = new AVLBinaryTree<Integer>();
        avlTree.root = avlTree.insert(1, avlTree.root);
        avlTree.root = avlTree.insert(3, avlTree.root);
        avlTree.root = avlTree.insert(5, avlTree.root);
        avlTree.root = avlTree.insert(2, avlTree.root);
        avlTree.root = avlTree.insert(4, avlTree.root);
        avlTree.root = avlTree.insert(6, avlTree.root);
    }
}
