/**2012-5-26**/

package com.cq.model.visitor.practice;

/**
 * �������
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class Funding implements IService {
    
    /**
     * @see com.cq.model.visitor.practice.IService#accept(com.cq.model.visitor.Visitor)
     */
    @Override
    public void accept(IVisitor visitor) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        visitor.visit(this);
    }
    
}
