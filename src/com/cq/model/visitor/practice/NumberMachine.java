/**2012-5-26**/

package com.cq.model.visitor.practice;

/**
 * 模拟银行排号器
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class NumberMachine implements IVisitor {
    
    /**
     * @see com.cq.model.visitor.practice.IVisitor#visit(com.cq.model.visitor.practice.Funding)
     */
    @Override
    public void visit(Funding fun) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("安排到基金窗口服务！");
    }
    
    /**
     * @see com.cq.model.visitor.practice.IVisitor#visit(com.cq.model.visitor.practice.Saving)
     */
    @Override
    public void visit(Saving sav) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("安排到存款服务窗口！");
    }
}
