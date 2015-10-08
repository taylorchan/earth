/**2012-5-27**/

package com.cq.model.mediator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class Client {
    
    public static void main(String args[]) {
        AbstractMediator am = new Mediator();
        
        Purchase pc = new Purchase(am);
        pc.buyComputere(100);
        
        Sale s = new Sale(am);
        s.sellComputer(50);
        
        System.out.println("clear stock");
        Stock sd = new Stock(am);
        sd.warn();
        
    }
}
