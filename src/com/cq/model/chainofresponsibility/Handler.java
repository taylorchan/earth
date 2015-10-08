
/**2012-5-25**/

package com.cq.model.chainofresponsibility;

/**
 * ������
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public abstract class Handler {
    
    protected Handler next;
    
    Handler() {
    }
    
    /**
     * ��������
     */
    
    public abstract void handleReq(Request request);
    
    /**
     * �����¸��ڵ�Ĵ�����
     * 
     * @param handler
     */
    protected void setNext(Handler handler) {
        this.next = handler;
    }
}
