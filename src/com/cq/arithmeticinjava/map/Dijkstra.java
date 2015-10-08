/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.map;

import java.util.List;

import com.cq.arithmeticinjava.map.ALGraph.ArcNode;
import com.cq.arithmeticinjava.map.ALGraph.VNode;


/**
 * Dijkistra 算法，贪婪算法的例子
 * @author: qiang.chen
 * @since:    2012-7-19
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class Dijkstra {
    
    private static class Vertex{
        private List adj;
        
        private boolean know = false;
        /**
         * 记录距离起点的距离
         */
        private int dist  = Integer.MAX_VALUE;
        private Vertex path;
    }
    
    Dijkstra(ALGraph g){
        
    }
    /**
     * 
     */
    private static ALGraph creatGraph(){
        ALGraph graph = new ALGraph();
        VNode v1 = new VNode("v1");
        graph.putNode(v1);
        
        VNode v2 = new VNode("v2");
        graph.putNode(v2);
        
        VNode v3 = new VNode("v3");
        graph.putNode(v3);
        
        VNode v4 = new VNode("v4");
        graph.putNode(v4);
        
        VNode v5 = new VNode("v5");
        graph.putNode(v5);
        
        VNode v6 = new VNode("v6");
        graph.putNode(v6);
        
        VNode v7 = new VNode("v7");
        graph.putNode(v7);
        
        ALGraph.creatArcNode(graph, v1, v2, 2);
        ALGraph.creatArcNode(graph, v1, v4, 1);
        
        ALGraph.creatArcNode(graph, v2, v4, 3);
        ALGraph.creatArcNode(graph, v2, v5, 10);
        
        ALGraph.creatArcNode(graph, v3, v1, 4);
        ALGraph.creatArcNode(graph, v3, v6, 5);
        
        ALGraph.creatArcNode(graph, v4, v3, 2);
        ALGraph.creatArcNode(graph, v4, v5, 2);
        ALGraph.creatArcNode(graph, v4, v6, 8);
        ALGraph.creatArcNode(graph, v4, v7, 4);
        
        ALGraph.creatArcNode(graph, v5, v7, 6);
        
        ALGraph.creatArcNode(graph, v7, v6, 1);
        return graph;
    }
    /**
     * 计算点s到其他个点的最短距离
     *
     * @param s
     */
    public static void dijkstra(ALGraph graph,VNode v){
        VNode[] nodes = graph.AdjList;
        v.know = true;
        ArcNode arc = v.firstArc;
        while(arc != null){
            int point = arc.adjvex;
            int weight = arc.weight;
            VNode w = nodes[point];
            if(!w.know){
                if(v.dist + weight < w.dist){
                    w.dist = v.dist + arc.weight;
                }
            }
            dijkstra(graph,w);
            arc = arc.next;
        }
    }
    public static void main(String[] args) {
        ALGraph g = creatGraph();
       // dijkstra(g,v1);
    }
}
