/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.Map;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-27 ��ǿ�½�
 */
public class VarExpression extends Expression {
    
    private final String key;
    
    public VarExpression(String _key) {
        this.key = _key;
    }
    
    /**
     * @see com.cq.model.intepretor.Expression#intepreter(java.util.Map)
     */
    @Override
    public int intepreter(Map<String, Integer> map) {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        return map.get(this.key);
    }
    
}
