/**2012-3-19**/

package com.cq.model.factory;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-19 ��ǿ�½�
 */
public class ConcreteProduct {
    
}

class ConcreteProduct1 implements Product {
    
    public ConcreteProduct1() {
        System.out.println("CocnreteProduct1 is being created.");
    }
}

class ConcreteProduct2 implements Product {
    
    public ConcreteProduct2() {
        System.out.println("CocnreteProduct2 is being created.");
    }
}
