/**2012-3-19**/

/**2012-3-19**/

package com.cq.model.bridge;

/**
 * 注意这里是骨架实现
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public abstract class Abstraction implements IBridge {
    
    //通过组合的方式建立起与需要联系模块的联系　　
    private Implementor implementor;
    
    /**
     * @param impl
     */
    public Abstraction(Implementor impl) {
        this.implementor = impl;
    }
    
    /**
     * 注意这里的action是通过implementor来实现的
     */
    public void action() {
        implementor.operation();
    }
    
    /**
     * @return 获取 implementor属性值
     */
    public Implementor getImplementor() {
        return implementor;
    }
    
    /**
     * @param implementor 设置 implementor 属性值为参数值 implementor
     */
    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
    
}
