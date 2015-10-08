/**2012-5-25**/

/**2012-5-25**/

package com.cq.model.builder;

/**
 * 黄金套餐的配餐员
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class GoldBuilder extends Builder {
    
    private Food goldFood = null;
    
    /**
     * 
     */
    public GoldBuilder() {
        this.goldFood = new Food();
    }
    
    @Override
    public void BuildChip() {
        goldFood.Add("GoldChip", "5.00");
    }
    
    @Override
    public void BuildCoke() {
        goldFood.Add("CokeCole", "5.00");
    }
    
    @Override
    public void BuildHamb() {
        goldFood.Add("GoldHamb", "13.50");
    }
    
    @Override
    public Food GetFood() {
        return goldFood;
    }
    
}
