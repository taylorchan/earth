/**2012-5-26**/

package com.cq.model.visitor.practice;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Client {
    
    public static void main(String args[]) {
        IVisitor nm = new NumberMachine();
        // 需要一个现金服务
        IService s = new Funding();
        s.accept(nm);
        
        s = new Saving();
        
        s.accept(nm);
        
    }
}
