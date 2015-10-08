/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.Map;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class SubExpression extends SymboExpresssion {
    
    /**
     * @param left
     * @param right
     */
    public SubExpression(Expression left, Expression right) {
        super(left, right);
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    /**
     * @see com.cq.model.intepretor.Expression#intepreter(java.util.Map)
     */
    @Override
    public int intepreter(Map<String, Integer> var) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return left.intepreter(var) - right.intepreter(var);
    }
    
}
