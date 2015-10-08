
/**2012-5-25**/

package com.cq.model.chainofresponsibility;

/**
 * 处理者
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public abstract class Handler {
    
    protected Handler next;
    
    Handler() {
    }
    
    /**
     * 处理请求
     */
    
    public abstract void handleReq(Request request);
    
    /**
     * 设置下个节点的处理者
     * 
     * @param handler
     */
    protected void setNext(Handler handler) {
        this.next = handler;
    }
}
