/**2012-7-18**/

package com.cq.arithmeticinjava.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 用邻接表表示图
 * 
 * @author Taylor Chan
 * @since 1.0
 * @version 2012-7-18 Taylor Chan Creat
 * @param <T>
 */
public class ALGraph {
    
    private static final int INITIAL_SIZE = 20;
    
    /**
     * 邻接表的组成
     */
     final VNode[] AdjList = new VNode[INITIAL_SIZE];
    
    /**
     * 当前顶点数
     */
     int vexSize = 0;
    
    /**
     * 当前弧的数目
     */
     int arcSize;
    
    /**
     * 头节点的实现
     * 
     * @author Taylor Chan
     * @since 1.0
     * @version 2012-7-18 Taylor Chan Creat
     */
    public static class VNode {
        
         public VNode(String info){
             this.nodeInfo = info;
             this.path = new ArrayList<VNode>();
         }
        /**
         * 顶点信息
         */
        String nodeInfo;
        
        /**
         * 指向第一条依附该顶点的弧的指针
         */
        ArcNode firstArc;
        /**
         * 
         */
         boolean know = false;
        /**
         * 记录距离起点的距离,最大值表示没有通路
         */
         int dist  = Integer.MAX_VALUE;
         
         List<VNode> path;
     
        
        public boolean equals(Object obj){
            VNode other = (VNode)obj;
            return other.nodeInfo.equals(this.nodeInfo);
        }
       
        
    }
    
    public void putNode(VNode node){
        AdjList[vexSize++] = node;
    }
    /**
     *
     * @param g
     * @param tailNode
     * @return
     */
    public static  int locateNode(ALGraph g,VNode node){
        
        for (int i = 0; i < g.AdjList.length; i++) {
            if(g.AdjList[i].equals(node)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 
     *
     * @param tailNode 弧指向的节点
     * @return
     */
    public static ArcNode creatArcNode(ALGraph g,VNode headNode,VNode tailNode,int weight){
        
        int index = locateNode(g, tailNode);
        ArcNode newArc = new ArcNode(index, weight);
        
        ArcNode arcNode =  headNode.firstArc;
        if(arcNode == null)
            headNode.firstArc = newArc;
        else{
            while(arcNode.next != null)
                arcNode = arcNode.next;
            arcNode.next = newArc;
        }
        return newArc;
    }
    
    /**
     * 表节点的实现（弧的描述）
     * 
     * @author Taylor Chan
     * @since 1.0
     * @version 2012-7-18 Taylor Chan Creat
     */
    public static class ArcNode {
        
        ArcNode( int adjvex ,int weight){
            this.adjvex = adjvex;
            this.weight = weight;
        }
        
        // 该弧所指向的顶点的位置
        int adjvex;
        
        // 指向下一条弧的指针
        ArcNode next;
        
        // 弧的相关信息
        int weight = 0 ;
    }
    
    
}
