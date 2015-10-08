/**2012-7-15**/

package com.cq.arithmeticinjava.binarytree;

/**
 * 线索二叉树
 * 
 * @author Taylor Chan
 * @since 1.0
 * @version 2012-7-15 Taylor Chan Creat
 */
public class ClueBinaryTree<T> {
    
    /**
     * 头指针
     */
    private ClueTreeNode head;
    
    /**
     * 
     */
    public ClueBinaryTree() {
        
    }
    
    /**
     * 若ltag=0,lchild指向左子树，否则指向前趋结点; 若rtag=0,rchild指向右子树，否则指向后继结点；
     * 构成的二叉链表作为二叉树的存储结构，叫做 线索二叉链
     * 
     * @author Taylor Chan
     * @since 1.0
     * @version 2012-7-15 Taylor Chan Creat
     */
    private static class ClueTreeNode<T> {
        
        T data;
        
        /**
         * 等于0表示存在对应的子树
         */
        Flag lTag = Flag.POINTER;
        
        Flag rTag = Flag.POINTER;
        
        ClueTreeNode<T> left;
        
        ClueTreeNode<T> right;
        
        @Override
        public String toString() {
            return data.toString() + ", ";
        }
    }
    
    private enum Flag {
        POINTER, // 指针，默认的情况
        THREAD
        // 线索
        
    }
    
    /**
     * @param data
     * @param left
     * @param right
     * @param isHead
     * @return
     */
    public ClueTreeNode putEle(T data, ClueTreeNode left, ClueTreeNode right, boolean isHead) {
        ClueTreeNode node = new ClueTreeNode<T>();
        node.data = data;
        node.left = left;
        node.right = right;
        if (isHead)
            head = node;
        return node;
    }
    
    /**
     * @param data
     * @param isHead
     * @return
     */
    public ClueTreeNode putEle(T data, boolean isHead) {
        return putEle(data, null, null, isHead);
    }
    
    /**
     * 建立中序线索化链表 中序遍历二叉树，并将其序列化
     * 
     * @param head
     * @return
     */
    public static ClueTreeNode inorderThreading(ClueTreeNode head) {
        // 建立头指针
        ClueTreeNode top = new ClueTreeNode();
        
        top.rTag = Flag.THREAD;
        top.right = top;
        ClueTreeNode pre;
        if (head == null)
            top.left = top;// 左指针回指
        else {
            top.left = head;
            pre = top;
            inThreading(head, pre);
            pre.right = top;
            pre.rTag = Flag.THREAD;
            top.right = pre;
        }
        return top;
    }
    
    /**
     * 线索化
     * 
     * @param node
     * @param pre
     */
    public static void inThreading(ClueTreeNode node, ClueTreeNode pre) {
        if (node != null) {
            inThreading(node.left, pre);
            if (node.left == null) {
                node.lTag = Flag.THREAD;
                node.left = pre;// 前驱线索
            }
            if (node.right == null) {
                pre.rTag = Flag.THREAD;
                pre.right = node;// 后续线索
            }
            pre = node;
            inThreading(node.right, pre);
        }
    }
    
    /**
     * 头节点的left指向根节点
     * 
     * @param node 头节点
     * @param pre
     */
    public static void inOrderTranverse(ClueTreeNode node) {
        ClueTreeNode cur = node.left;// 根节点
        while (cur != node) {// 最后一个节点的right == node
            while (cur.lTag == Flag.POINTER)
                cur = cur.left;
            if (cur != null)
                System.out.println(cur);
            while (cur.rTag == Flag.THREAD && cur.right != node) {// 最后一个节点的right==
                // node
                cur = cur.right;
                System.out.println(cur);
            }
            cur = cur.right;
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        ClueBinaryTree<String> bt = new ClueBinaryTree<String>();
        ClueTreeNode a = bt.putEle("a", true);
        ClueTreeNode b = bt.putEle("b", false);
        ClueTreeNode c = bt.putEle("c", false);
        ClueTreeNode d = bt.putEle("d", false);
        ClueTreeNode e = bt.putEle("e", false);
        ClueTreeNode f = bt.putEle("f", false);
        ClueTreeNode g = bt.putEle("g", false);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        d.left = f;
        f.right = g;
        ClueTreeNode top = inorderThreading(a);
        inOrderTranverse(top);
    }
}
