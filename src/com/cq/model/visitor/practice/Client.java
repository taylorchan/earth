/**2012-5-26**/

package com.cq.model.visitor.practice;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class Client {
    
    public static void main(String args[]) {
        IVisitor nm = new NumberMachine();
        // ��Ҫһ���ֽ����
        IService s = new Funding();
        s.accept(nm);
        
        s = new Saving();
        
        s.accept(nm);
        
    }
}
