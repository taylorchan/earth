/**2012-5-26**/

package com.cq.model.visitor.practice;

/**
 * ģ�������ź���
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class NumberMachine implements IVisitor {
    
    /**
     * @see com.cq.model.visitor.practice.IVisitor#visit(com.cq.model.visitor.practice.Funding)
     */
    @Override
    public void visit(Funding fun) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("���ŵ����𴰿ڷ���");
    }
    
    /**
     * @see com.cq.model.visitor.practice.IVisitor#visit(com.cq.model.visitor.practice.Saving)
     */
    @Override
    public void visit(Saving sav) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("���ŵ������񴰿ڣ�");
    }
}
