/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/

package com.cq.arithmeticinjava.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 1.完全二叉树,设高度为h,则到第h-1层为满二叉树,第 h 层所有的结点都连续集中在最左边.
 * 2.完全二叉树的高度为log2N + 1
 * 
 * 二叉树的一般存放方法:
 * 1. 二叉链的方式存放,分别存放指向左右孩子的引用
 * 2.顺序存放,用数组来存放二叉树的所有节点(按顺序编号,从index=0开始,将对应的元素存放到对应的位置,可能浪费一定的空间)
 * 3.三叉链表存放,分别存放左右孩子及父节点的引用
 * 以二叉链的形式表现二叉树,每个节点里面存放一个数据域用于指向其左右叶子节点.
 * 
 * @author: qiang.chen
 * @since: 2012-7-12
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class BinaryTree<T> {
    
    /**
     * 头指针
     */
    private TreeNode head;
    
    public BinaryTree() {
        
    }
    
    public TreeNode putEle(T data, TreeNode left, TreeNode right, boolean isHead) {
        TreeNode node = new TreeNode<T>(data,left,right);
        if (isHead)
            head = node;
        return node;
    }
    
    public TreeNode putEle(T data, boolean isHead) {
        return putEle(data, null, null, isHead);
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * 中序遍历二叉树，递归实现
     * 
     * @param <T>
     * @param head 二叉树的head
     * @param index 头节点
     */
    public static <T> void midorederTraverseBTree(TreeNode head) {
        TreeNode node = head;
        if (head == null) {
            return;
        }
        System.out.println(node);
        midorederTraverseBTree(node.left);
        midorederTraverseBTree(node.right);
    }
    

    /**
     * 中序遍历二叉树，非递归实现
     * 
     * @param <T>
     * @param head 二叉树的head
     * @param index 头节点
     */
    public static <T> void midorederTraverseBTreebyStack(TreeNode head) {
        TreeNode node = head;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop(); // 相当于回溯,栈的使用，记录轨迹的使用
                System.out.println(node);
                node = node.right;
            }
        }
    }
    
    /**
     * 先序遍历二叉树，非递归实现
     * 
     * @param <T>
     * @param head 二叉树的head
     * @param index 头节点
     */
    public static <T> void preorederTraverseBTreebyStack(TreeNode head) {
        TreeNode node = head;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                System.out.println(node);
                s.push(node);
                node = node.left;
            } else {
                node = s.pop(); // 相当于回溯,栈的使用，记录轨迹的使用
                node = node.right;
            }
        }
    }
    
    /**
     * 后序遍历二叉树，非递归实现
     * 
     * @param <T>
     * @param head 二叉树的head
     * @param index 头节点
     */
    public static <T> void postorederTraverseBTreebyStack(TreeNode head) {
        TreeNode node = head;
        TreeNode pre = head;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            if (!s.isEmpty()) {
                TreeNode temp = s.peek().right;
                if (temp == null || temp == pre) {
                    node = s.pop();
                    System.out.println(node);
                    pre = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }
    }
    
    /**
     * 利用队列实现的二叉树的广度优先遍历,利用栈的FIFO特性
     * @param head
     */
    public static void widthTraverseBTree(TreeNode head){
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	if(head == null)
    		return;
    	queue.add(head);
    	TreeNode displayNode = null;
    	while(!queue.isEmpty()){
    		displayNode = queue.poll();
    		System.out.println(displayNode);
    		if(displayNode.left !=null)
    			queue.add(displayNode.left);
    		if(displayNode.right !=null)
    			queue.add(displayNode.right);
    	}
    }
    
    /**
     * 计算子孙节点数据
     * 
     * @param head
     * @return
     */
    public static int countBTreeNum(TreeNode head) {
        TreeNode node = head;
        if (head == null) {
            return 0;
        }
        int num = 1;
        return num + countBTreeNum(node.left) + countBTreeNum(node.right);
    }

    
    /**
     * 求二叉树的深度
     * 
     * @param <T>
     * @param head
     * @return
     */
    public static <T> int deepthOfBTree(TreeNode head) {
        TreeNode node = head;
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(deepthOfBTree(head.left), deepthOfBTree(head.right));
    }
    
    /**
     * 求出叶子节点的数目
     * 
     * @param <T>
     * @param head
     * @return
     */
    public static <T> int leavesOfBTree(TreeNode head) {
        TreeNode node = head;
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        int leftNum = leavesOfBTree(node.left);
        int rightNum = leavesOfBTree(node.right);
        return rightNum + leftNum;
    }
    
    /**
     * 交换左右子树
     * 
     * @param <T>
     * @param head
     * @return
     */
    public static <T> void swapBTree(TreeNode head) {
        TreeNode node = head;
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        swapBTree(node.left);
        swapBTree(node.right);
    }
    
    /**
     * 求所有节点的子孙个数
     * 
     * @param <T>
     * @param head
     * @return
     */
    public static <T> void coutBTreeAllChildrenNum(TreeNode head, List<Integer> ls) {
        TreeNode node = head;
        if (node == null) {
            return;
        }
        ls.add(countBTreeNum(node));
        coutBTreeAllChildrenNum(node.left, ls);
        coutBTreeAllChildrenNum(node.right, ls);
    }
    
    public static void main(String[] args) {
        BinaryTree<String> bt = new BinaryTree<String>();
        TreeNode a = bt.putEle("a", true);
        TreeNode b = bt.putEle("b", false);
        TreeNode c = bt.putEle("c", false);
        TreeNode d = bt.putEle("d", false);
        TreeNode e = bt.putEle("e", false);
        TreeNode f = bt.putEle("f", false);
        TreeNode g = bt.putEle("g", false);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        d.left = f;
        f.right = g;
        preorederTraverseBTreebyStack(bt.head);
        System.out.println();
        midorederTraverseBTreebyStack(bt.head);
        System.out.println();
        postorederTraverseBTreebyStack(bt.head);
        System.out.println("deepth:  " + deepthOfBTree(bt.head));
        System.out.println("Leaves: " + leavesOfBTree(bt.head));
       // swapBTree(bt.head);
        System.out.println(countBTreeNum(bt.head));
        List<Integer> ls = new ArrayList<Integer>();
        coutBTreeAllChildrenNum(bt.head, ls);
        for (Integer integer : ls) {
            System.out.println(integer + "  ");
        }
        widthTraverseBTree(bt.head);
    }
}
