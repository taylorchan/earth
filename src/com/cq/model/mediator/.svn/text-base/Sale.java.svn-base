/**2012-5-26**/

package com.cq.model.mediator;

import java.util.Random;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Sale extends AbstractColleague {
    
    /**
     * @param ac
     */
    public Sale(AbstractMediator ac) {
        super(ac);
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    public void sellComputer(int num) {
        System.out.println("卖出电脑" + num + "台");
        
        // 先处理自己的业务，自己不能处理掉 业务，交由mediator来处理
        mediator.execute("sale.sellcomputer", num);
    }
    
    /**
     * 折价销售
     */
    public void saleoff() {
        mediator.execute("sale.saleoff");
    }
    
    /**
     * 返回销售情况
     * 
     * @return
     */
    public int returnSaleStatus() {
        Random rd = new Random(System.currentTimeMillis());
        int status = rd.nextInt();
        return status;
    }
}
