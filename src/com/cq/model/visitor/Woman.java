/**2012-5-26**/

package com.cq.model.visitor;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class Woman implements Person {
    
    /**
     * @see com.cq.model.visitor.Person#accept(com.cq.model.visitor.Visitor)
     */
    @Override
    public void accept(Visitor visitor) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        visitor.visit(this);
    }
    
}
