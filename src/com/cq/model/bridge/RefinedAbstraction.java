/**2012-3-19**/

package com.cq.model.bridge;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public class RefinedAbstraction extends Abstraction {
    
    /**
     * 通过依赖，建立起两块之间的桥梁
     * 
     * @param impl
     */
    public RefinedAbstraction(Implementor impl) {
        super(impl);
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
}
