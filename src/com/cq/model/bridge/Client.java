/**2012-3-19**/

/**2012-3-19**/

package com.cq.model.bridge;

/**
 * 把抽象与行为实现分离开来，从而保持各部分的独立性
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public class Client {
    
    public static void main(String args[]) {
        Abstraction abstraction = new RefinedAbstraction(new ConcreteImplementorA());
        abstraction.action();// Change implemention and call 　　
        abstraction = new RefinedAbstraction2(new ConcreteImplementorB());
        abstraction.action();
    }
}
