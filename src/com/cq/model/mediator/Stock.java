/**2012-5-26**/

package com.cq.model.mediator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Stock extends AbstractColleague {
    
    /**
     * @param ac
     */
    public Stock(AbstractMediator ac) {
        super(ac);
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    private static int num = 100;
    
    /**
     * 库存过大，发出需要尽快销售的警告
     */
    public void warn() {
        System.out.println("库存量为" + Stock.num);
        mediator.execute("stock.warn");
    }
    
    /**
     * @return 获取 num属性值
     */
    public static int getNum() {
        return num;
    }
    
    /**
     * @param num 设置 num 属性值为参数值 num
     */
    public static void addNum(int num) {
        Stock.num += num;
    }
    
    /**
     * @param num 设置 num 属性值为参数值 num
     */
    public static void decreaseNum(int num) {
        Stock.num -= num;
    }
    
    public void clearStock() {
        mediator.execute("stock.clear");
    }
}
