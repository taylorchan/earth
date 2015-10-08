/**2012-5-25**/

package com.cq.model.chainofresponsibility;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Manager extends Handler {
    
    /**
     * @see com.cq.model.chainofresponsibility.Handler#handleReq(java.lang.String)
     */
    @Override
    public void handleReq(Request request) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        if (request instanceof OutRequest) {
            System.out.println("i'm manager,i can handle outRequest");
        } else {
            System.out.println("i'm manager,i can not handle this request");
            next.handleReq(request);
        }
    }
    
}
