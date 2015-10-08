/**2012-3-19**/

package com.cq.model.decoractor;

/**
 * 主要的应用场景为 1为类添加职责 2扩充一个类的功能
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public class ConcreteDecorator extends Decorator {
    
    /**
     * 父类中自定义了构造器，必须显式的调用
     * 
     * @param component
     */
    public ConcreteDecorator(Component component) {
        super(component);
    }
    
    @Override
    //用继承实现的装饰，用组合也可实现
    public void operation() {
        // addBehavior也可以在前面
        component.operation();
        addBehavior();
    }
    
    private void addBehavior() {
        // your code
    }
}
