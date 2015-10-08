/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.Map;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
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
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return map.get(this.key);
    }
    
}
