/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.binarytree;

import java.util.Stack;


/**
 * 静态链二叉树--用数组存储元素，父节点分别保存左右孩子在数组中的位置
 * @author: qiang.chen
 * @since:    2012-7-12
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class BinaryTreeByArray<T> {
    private TreeNode[] array;
    
    /**
     * @return the array
     */
    public TreeNode[] getArray() {
        return array;
    }
    int nodeNum = 0;
    
    public static class TreeNode<T>{
        T data;
        int left = -1;
        int right = -1;
        TreeNode(T t,int left,int right){
            this.data = t;
            this.left  = left;
            this.right = right;
        }
        TreeNode(T data){
            this.data =data;
        }
        public String toString(){
            return data.toString() +", "+ left+", "+right +";";
        }
    }
    
    public boolean isEmptyTree(){
        return (array!=null || nodeNum == 0);
    }
    public void putEle(T data,int left,int right,int pos){
        TreeNode en = new TreeNode<T>(data, left, right);
        array[pos] = en;
        nodeNum++;
    }
    public void putEle(T data,int pos){
        TreeNode en = new TreeNode<T>(data);
        array[pos] = en;
    }
    public BinaryTreeByArray(int size){
        array = new TreeNode[size];
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i< array.length;i++) {
            sb.append(i);
            sb.append(": ");
            sb.append(array[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        BinaryTreeByArray<String> bt = new BinaryTreeByArray<String>(7);
        bt = bt.init(bt);
        System.out.println(bt.toString());
        System.out.println();
        preorederTraverseBTreeByStack(bt);
        System.out.println();
        midorederTraverseBTree(bt,0);
        System.out.println();
        postorederTraverseBTree(bt,0);
    }
    public BinaryTreeByArray init( BinaryTreeByArray<String> bt){
        bt.putEle("a", 1, 2, 0);
        bt.putEle("b",  1);
        bt.putEle("c", 3,4, 2);
        bt.putEle("d",5, 6, 3);
        bt.putEle("e", 4);
        bt.putEle("f", 5);
        bt.putEle("g", 6);
        return bt;
    }
    /**
     * 先序遍历二叉树，递归实现
     *
     * @param <T>
     * @param bt      静态链二叉树对象
     * @param index  头节点
     */
    public static <T> void preorederTraverseBTree(BinaryTreeByArray<T> bt,int index){
         if(index == -1){//-1表示没有元素，退回到上一个节点
             return;
         }
         TreeNode[] nodes = bt.getArray();
         TreeNode cur = nodes[index];
         preorederTraverseBTree(bt,cur.left);
         System.out.println(cur);
         preorederTraverseBTree(bt,cur.right);
    }
    /**
     * 中序遍历二叉树，递归实现
     *
     * @param <T>
     * @param bt      静态链二叉树对象
     * @param index  头节点
     */
    public static <T> void midorederTraverseBTree(BinaryTreeByArray<T> bt,int index){
        if(index == -1){
            return;
        }
        TreeNode[] nodes = bt.getArray();
        TreeNode cur = nodes[index];
         System.out.println(cur);
         midorederTraverseBTree(bt,cur.left);
         midorederTraverseBTree(bt,cur.right);
    }
    /**
     * 后序遍历二叉树，递归实现
     *
     * @param <T>
     * @param bt      静态链二叉树对象
     * @param index  头节点
     */
    public static <T> void postorederTraverseBTree(BinaryTreeByArray<T> bt,int index){
        if(index == -1){
            return;
        }
        TreeNode[] nodes = bt.getArray();
        TreeNode cur = nodes[index];
        postorederTraverseBTree(bt,cur.right);
        System.out.println(cur);
        postorederTraverseBTree(bt,cur.left);
    }
    /**
     * 先序遍历二叉树，非递归实现
     *
     * @param <T>
     * @param bt      静态链二叉树对象
     * @param index  头节点
     */
    public static <T> void preorederTraverseBTreeByStack(BinaryTreeByArray<T> bt){
         TreeNode[] nodes = bt.getArray();
         Stack<TreeNode> stack = new Stack<TreeNode>(); 
         int index = 0;
         TreeNode cur = nodes[index];
         stack.push(cur);
         while(index != -1 || !stack.isEmpty()){
             if(index != -1){
                 cur = nodes[index];
                 System.out.println(cur);
                 stack.push(cur);
                 index = cur.left;
             }
             System.out.println(stack.pop());
             index = cur.right;
             if(index != -1){
                 cur = nodes[index];
             }
         }
    }
    
    
    
    /**
     * 层次遍历二叉树，递归实现
     *
     * @param <T>
     * @param bt      静态链二叉树对象
     * @param index  头节点
     */
    public static <T> void levelTraverseBTree(BinaryTreeByArray<T> bt,int index){
        TreeNode[] nodes = bt.getArray();
        TreeNode cur = nodes[index];
         System.out.println(cur);
         
    }
    
}
