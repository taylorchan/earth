/**2012-5-26**/

package com.cq.model.visitor;

/**
 * 模拟节点的接口
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public interface Person {
    
    /**
     * @param visitor
     */
    void accept(Visitor visitor);
}
