/**2012-5-25**/

package com.cq.model.builder;

/**
 * 建造者处理指导者的要求，并将部件添加到产品中。餐馆员工（建造者）按照收银员要求的把对应的汉堡，
 * 可乐，薯条放入盘子中。这部分是建造者模式里面富于变化的部分， 因为顾客选择的套餐不同， 套餐的组装过程也不同， 这步完成产品对象的创建工作
 * 
 *不同的建造者，造出不同的商品，这点跟工厂模式很相似
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public abstract class Builder {
    
    /**
     * 
     */
    public Builder() {
    }
    
    /**
     * 
     */
    public abstract void BuildHamb();
    
    /**
     * 添加可乐
     */
    public abstract void BuildCoke();
    
    /**
     * 添加薯条
     */
    public abstract void BuildChip();
    
    /**
     * 返回结果
     * 
     * @return 食品对象
     */
    public abstract Food GetFood();
    
}
