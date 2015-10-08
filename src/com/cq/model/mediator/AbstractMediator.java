/**2012-5-26**/

package com.cq.model.mediator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public abstract class AbstractMediator {
    
    protected Purchase purchase;
    
    protected Sale sale;
    
    protected Stock stock;
    
    AbstractMediator() {
        this.purchase = new Purchase(this);
        this.sale = new Sale(this);
        this.stock = new Stock(this);
        
    }
    
    abstract void execute(String str, Object... objects);
}
