/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.Map;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-27 ��ǿ�½�
 */
public abstract class Expression {
    
    /**
     * ������ʽ������
     * 
     * @param map
     * @return
     */
    public abstract int intepreter(Map<String, Integer> map);
}
