/**2012-5-26**/

package com.cq.model.visitor;

/**
 * 访问者接口，代表了男人与女人在不同状态下的表现
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public interface Visitor {
    
    /**
     * @param man
     */
    void visit(Man man);
    
    /**
     * @param woman
     */
    void visit(Woman woman);
}
