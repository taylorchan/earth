/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.matrix;

import java.util.ArrayList;
import java.util.List;


/**
 * 十字链表
 * @author: qiang.chen
 * @since:    2012-7-11
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class OrthogonalList<E> {
    
    private Node firstNode;
    
    public OrthogonalList(){
       List ls  = new ArrayList();
       ls.add(ls);
    }
    
    private static class Node<E>{
        int rowNo = -1;
        int columnNo =-1;
        E data;
        Node right ;
        Node down;
        public Node(int row,int column){
            this.rowNo = row;
            this.columnNo = column;
        }
        public Node(){
        }
        /**
         * @return the data
         */
        public E getData() {
            return data;
        }
        
        /**
         * @param data the data to set
         */
        public void setData(E data) {
            this.data = data;
        }
        
        /**
         * @return the right
         */
        public Node getRight() {
            return right;
        }
        
        /**
         * @param right the right to set
         */
        public void setRight(Node right) {
            this.right = right;
        }
        
        /**
         * @return the down
         */
        public Node getDown() {
            return down;
        }
        
        /**
         * @param down the down to set
         */
        public void setDown(Node down) {
            this.down = down;
        }
    }
}
