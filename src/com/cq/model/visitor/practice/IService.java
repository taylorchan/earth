/**2012-5-26**/

package com.cq.model.visitor.practice;


/**
 * 银行服务的描述类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public interface IService {
    
    /**
     * @param visitor
     */
    void accept(IVisitor visitor);
}
