/**2012-3-19**/

package com.cq.model.bridge;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public class RefinedAbstraction2 extends Abstraction {
    
    /**
     *此类与第一个继承类不同点是：构造器中的参数 不是面向接口而是面向具体的实现类 一个类应该尽量承担尽量少的责任，方法也如此
     * 
     * @param impl
     */
    public RefinedAbstraction2(ConcreteImplementorB impl) {
        super(impl);
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
}
