/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.map;


/**
 * 基于邻接矩阵实现的图
 * @author: qiang.chen
 * @since:    2012-7-19
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class Graph {
    private static final int MAX_VERT = 20;  
    private Node nodelist[];  
    private int adjMat[][];  
    private int nverts;  
    
    private static class Node{
        
    }
    public Graph(){  
        //顶点数组  
        nodelist=new Node[MAX_VERT];  
        //邻接矩阵  
        adjMat = new int[MAX_VERT][MAX_VERT];  
        nverts=0;  
    } 
}
