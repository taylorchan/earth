/**2012-5-25**/

package com.cq.model.chainofresponsibility;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class RequestDemo {
    
    public static void main(String args[]) {
        // 发出一个请求
        Request re = new OutRequest();
        Request re2 = new MeetingRequest();
        Handler h = new Manager();
        Handler h2 = new Director();
        // 设置责任链，确定处理者，按链进行处理
        h.setNext(h2);
        h2.setNext(h);
        h.handleReq(re2);
        h2.handleReq(re);
    }
}
