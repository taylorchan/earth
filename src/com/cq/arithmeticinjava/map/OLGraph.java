/**2012-7-19**/

package com.cq.arithmeticinjava.map;

/**
 * 十字链表表示图
 * 
 * @author Taylor Chan
 * @since 1.0
 * @version 2012-7-19 Taylor Chan Creat
 */
public class OLGraph<T> {
    
    private static final int INITIAL_SIZE = 20;
    
    private final VexNode[] xList = new VexNode[INITIAL_SIZE];
    
    /**
     * 当前顶点数
     */
    private int vexSize;
    
    /**
     * 当前弧的数目
     */
    private int arcSize;
    
    /**
     * 弧节点
     * 
     * @author Taylor Chan
     * @since 1.0
     * @version 2012-7-19 Taylor Chan Creat
     */
    private static class ArcBox {
        
        int tailVex, headVex;// 弧的尾和头顶点的位置
            
        private final ArcBox hLink, tLink;// 弧头相同和弧尾相同的弧的链域
            
        private final String arcInfo;
        
        ArcBox(int tailVex, int headVex, ArcBox hLink, ArcBox tLink, String info) {
            this.arcInfo = info;
            this.tailVex = tailVex;
            this.headVex = headVex;
            this.hLink = hLink;
            this.tLink = tLink;
        }
        
        @Override
        public String toString() {
            return tailVex + " => " + headVex + "\n";
        }
    }
    
    void putVexNode(VexNode node) {
        xList[vexSize++] = node;
    }
    
    /**
     * 顶点节点
     * 
     * @author Taylor Chan
     * @since 1.0
     * @version 2012-7-19 Taylor Chan Creat
     */
    private static class VexNode<T> {
        
        VexNode(T data) {
            this.data = data;
        }
        
        T data;// 数据域
        
        ArcBox firstIn, firstOut;// 分别指向该顶点的第一条入弧和出弧
            
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof VexNode))
                return false;
            VexNode other = (VexNode) obj;
            return this.data.equals(other.data);
        }
    }
    
    public static void main(String[] args) {
        OLGraph<String> olGraph = new OLGraph<String>();
        VexNode<String> v1 = new VexNode<String>("v1");
        olGraph.putVexNode(v1);
        VexNode<String> v2 = new VexNode<String>("v2");
        olGraph.putVexNode(v2);
        VexNode<String> v3 = new VexNode<String>("v3");
        olGraph.putVexNode(v3);
        VexNode<String> v4 = new VexNode<String>("v4");
        olGraph.putVexNode(v4);
        creatArc(olGraph, v1, v2);
        creatArc(olGraph, v1, v3);
        creatArc(olGraph, v3, v1);
        creatArc(olGraph, v3, v4);
        creatArc(olGraph, v4, v1);
        creatArc(olGraph, v4, v2);
        creatArc(olGraph, v4, v3);
    }
    
    private static <T> int locateVex(OLGraph<T> g, VexNode<T> node) {
        VexNode[] nodes = g.xList;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals(node)) {
                return i;
            }
        }
        return -1;
    }
    
    private static <T> void creatArc(OLGraph<T> g, VexNode<T> tail, VexNode<T> head) {
        int tailVex = locateVex(g, tail);
        int headVex = locateVex(g, head);
        ArcBox arc = new ArcBox(tailVex, headVex, g.xList[headVex].firstIn, g.xList[tailVex].firstOut, null);
        g.xList[headVex].firstIn = g.xList[tailVex].firstOut = arc;
    }
}
