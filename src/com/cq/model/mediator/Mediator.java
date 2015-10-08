/**2012-5-26**/

package com.cq.model.mediator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Mediator extends AbstractMediator {
    
    /**
     * @param purchase
     * @param sale
     * @param stock
     */
    Mediator() {
        super();
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    /**
     * @see com.cq.model.mediator.AbstractMediator#execute(java.lang.String,
     *      java.lang.Object[])
     */
    @Override
    void execute(String str, Object... objects) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        if (str.equals("purchase.buy")) {
            this.buyComputer((Integer) objects[0]);
        } else if (str.equals("sale.sellcomputer")) {
            this.sellComputer((Integer) objects[0]);
        } else if (str.equals("sale.saleoff")) {
            this.selloff();
        } else if (str.equals("stock.warn")) {// 需要清仓
            this.clearStock();
        }
        
    }
    
    /**
     * 买电脑
     * 
     * @param num
     */
    private void buyComputer(int num) {
        int saleStatus = sale.returnSaleStatus();
        if (saleStatus < 80) {
            num = num / 2;
        }
        System.out.println("采购了" + num + "台电脑");
        stock.addNum(num);
    }
    
    /**
     * 折价销售
     */
    private void selloff() {
        System.out.println("折价销售电脑" + stock.getNum() + "台");
    }
    
    /**
     * 清仓的处理
     */
    private void clearStock() {
        sale.saleoff();
        purchase.refuseBuy();
    }
    
    /**
     * 卖出多少台电脑
     * 
     * @param num
     */
    private void sellComputer(int num) {
        if (super.stock.getNum() < num) {
            purchase.buyComputere(num);
        }
        stock.decreaseNum(num);
    }
    
}
