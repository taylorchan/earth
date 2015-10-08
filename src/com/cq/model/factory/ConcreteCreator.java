/**2012-3-19**/

package com.cq.model.factory;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public class ConcreteCreator {
    
}

// 一个工厂对应一个产品，new出对应的工厂即可以得到对应的产品
class ConcreteCreator1 implements Creator {
    //note that the override method's return value can be 
    //the concreteClass of the returnValue in superClass method
    @Override
    public ConcreteProduct1 factory() {
        return new ConcreteProduct1();
    }
}

class ConcreteCreator2 implements Creator {
    @Override
    public ConcreteProduct2 factory() {
        return new ConcreteProduct2();
    }
}
