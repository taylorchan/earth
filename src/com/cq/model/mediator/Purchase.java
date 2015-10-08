/**2012-5-26**/

package com.cq.model.mediator;

/**
 * 采购类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Purchase extends AbstractColleague {
    
    /**
     * @param ac
     */
    public Purchase(AbstractMediator ac) {
        super(ac);
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    public void buyComputere(int num) {
        mediator.execute("purchase.buy", num);
    }
    
    public void refuseBuy() {
        System.out.println("refuse to buy computer!");
    }
}
