/**2012-5-25**/

/**2012-5-25**/

package com.cq.model.builder;

/**
 * 普通套餐的配餐员
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class NormalBuilder extends Builder {
    
    private Food normalFood = null;
    
    public NormalBuilder() {
        normalFood = new Food();
    }
    
    @Override
    public void BuildChip() {
        // 添加薯条
        normalFood.Add("FireChips", "2.00");
    }
    
    @Override
    public void BuildCoke() {
        // 添加可乐
        normalFood.Add("cokecole", "5.00");
    }
    
    @Override
    public void BuildHamb() {
        // 添加汉堡
        normalFood.Add("NormalHamb", "1.00");
    }
    
    @Override
    public Food GetFood() {
        return normalFood;
    }
    
}
