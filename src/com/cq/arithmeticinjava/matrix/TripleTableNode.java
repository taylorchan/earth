/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.matrix;


/**
 * 三元组顺序表节点
 * @author: qiang.chen
 * @since:    2012-7-11
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class TripleTableNode<T> {
    private int rowNo;
    private int columnNo;
    private T data;
    
    /**
     * 
     */
    public TripleTableNode(int no,int cNo,T data) {
        this.rowNo = no;
        this.columnNo = cNo;
        data= data;
    }

    
    /**
     * @return the rowNo
     */
    public int getRowNo() {
        return rowNo;
    }

    
    /**
     * @param rowNo the rowNo to set
     */
    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    
    /**
     * @return the columnNo
     */
    public int getColumnNo() {
        return columnNo;
    }

    
    /**
     * @param columnNo the columnNo to set
     */
    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    
    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    
    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }
}
