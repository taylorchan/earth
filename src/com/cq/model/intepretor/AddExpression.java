/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.Map;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-27 ��ǿ�½�
 */
public class AddExpression extends SymboExpresssion {
    
    /**
     * @param left
     * @param right
     */
    public AddExpression(Expression left, Expression right) {
        super(left, right);
        // TODO �Զ����ɹ��캯�����ע�ͣ����캯��ʵ��ʱ��ɾ����ע��
    }
    
    /**
     * �ӷ������������Խ��͵Ĺ���Ϊ����������ֵ������
     * 
     * @see com.cq.model.intepretor.Expression#intepreter(java.util.Map)
     */
    @Override
    public int intepreter(Map<String, Integer> var) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        return left.intepreter(var) + right.intepreter(var);
    }
    
}
