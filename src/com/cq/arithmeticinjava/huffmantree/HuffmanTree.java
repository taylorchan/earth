/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.huffmantree;

import java.util.Arrays;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-17
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class HuffmanTree {
    int n;
    int size = 0;
    private TreeNode[] nodes;
    /**
     * 静态存储树节点
     * 
     * @author: qiang.chen
     * @since:    2012-7-17
     * @version : 1.0
     * @E-mail： qiang.chen@xinyi-tech.com
     */
    private static class TreeNode{
        float weight;
        int left;
        int right;
        //父节点指针
        int plink;
        TreeNode(float f){
            this.weight = f ;
        }
        public String toString(){
            return "weight: "+weight + " left: "+left +" right: "+right+" plink: "+plink+"\n";
        }
    }
   public HuffmanTree(int n){
       nodes = new TreeNode[n*2 -1];
   }
   
   public void putEle(TreeNode node){
       if(size < nodes.length){
           nodes[size++] = node;
       }
   }
   public static void main(String[] args) {
       HuffmanTree tree = new HuffmanTree(5);
       tree.putEle(new TreeNode(14));
       tree.putEle(new TreeNode(23));
       tree.putEle(new TreeNode(7));
       tree.putEle(new TreeNode(6));
       tree.putEle(new TreeNode(50));
       boolean[] flags = new boolean[5*2 -1];
       for(int j  = 0;j<tree.nodes.length;j++){
           int min = 0;
           int secondmin = 0;
           for (int i = 0; i < tree.size; i++) {
               if(flags[i])
                   continue;
               if(tree.nodes[i].weight < tree.nodes[min].weight){
                   secondmin = min;
                   min = i;
               }
           }
          float WL = tree.nodes[min].weight + tree.nodes[secondmin].weight;
          TreeNode newNode = new TreeNode(WL);
          tree.putEle(newNode);
          newNode.left = min;
          newNode.right = secondmin;
          tree.nodes[min].plink = tree.nodes[secondmin].plink = (tree.size-1);
          flags[min] = flags[secondmin] = true;
       }
       System.out.println(Arrays.deepToString(tree.nodes));
   }
}
