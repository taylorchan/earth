/**2012-5-26**/

package com.cq.model.visitor;

/**
 * ����ķ�����ʵ��
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class Love implements Visitor {
    
    /**
     * @see com.cq.model.visitor.Visitor#visit(com.cq.model.visitor.Man)
     */
    @Override
    public void visit(Man man) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("the man love easily!");
    }
    
    /**
     * @see com.cq.model.visitor.Visitor#visit(com.cq.model.visitor.Woman)
     */
    @Override
    public void visit(Woman woman) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("the woman can't forget love easily!!");
    }
    
}
