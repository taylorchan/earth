/**2012-5-25**/

package com.cq.model.builder;

/**
 * 指导者通知建造器。收银员（指导者）告知餐馆员工准备套餐。 这里我们准备套餐的顺序是：放入汉堡，可乐倒入杯中，薯条放入盒中，并把这些东西都放在盘子上。
 * 这个过程对于普通套餐和黄金套餐来说都是一样的，不同的是它们的汉堡，可乐，薯条价格不同而已
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class FoodManager {
    
    public FoodManager() {
    }
    
    /**
     * 这里既是对建造者具体操作的指导过程，建造者按照指导者的指导进行操作
     * foodmanage负责指导过程，builder则是负责了具体的事宜，不同的builder做了不同的具体的工作
     * 比如组合不同的食物
     * 
     * @param builder
     */
    public void Construct(Builder builder) {
        builder.BuildHamb();
        
        builder.BuildCoke();
        
        builder.BuildChip();
    }
    
}
