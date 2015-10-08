/**2012-5-26**/

package com.cq.model.prototype;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Client {
    
    public static final int num = 100;
    
    public static void main(String args[]) {
        int i = 0;
        Mail m = new Mail(new AdvTemplate());
        // 发送制定数目的邮件
        Mail temp;
        while (i < num) {
            temp = m.clone();
            temp.setDestiny("xxxx@qq.com");
            temp.setTail("thank you!!");
            sendMail(temp);
        }
        
    }
    
    public static void sendMail(Mail m) {
        
    }
}
