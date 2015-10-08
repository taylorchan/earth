/**2012-5-25**/

package com.cq.model.chainofresponsibility;

/**
 * 总监类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Director extends Handler {
    
    /**
     * @see com.cq.model.chainofresponsibility.Handler#handleReq(com.cq.model.chainofresponsibility.Request)
     */
    @Override
    public void handleReq(Request request) {
        if (request instanceof MeetingRequest) {
            System.out.println("i'm director,i can handle meetingRequest");
        } else {
            System.out.println("i'm director,i can not handle this request");
            next.handleReq(request);
        }
        
    }
    
}
