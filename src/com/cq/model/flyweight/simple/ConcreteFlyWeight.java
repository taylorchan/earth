/**2012-5-27**/

package com.cq.model.flyweight.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class ConcreteFlyWeight implements FlyWeight {
    
    /**
     * 内蕴状态
     */
    private Character initr = null;
    
    /**
     * 内蕴为对象建立的时候设置，不可改变，如本例中内蕴指的就是一个字符
     * 
     * @param state
     */
    public ConcreteFlyWeight(Character state) {
        this.initr = state;
    }
    
    /**
     * 设置外蕴元素，并且根据外蕴进行相关操作，本例中，即是根据字符的字体，显示该字符
     * 
     * @see com.cq.model.flyweight.simple.FlyWeight#operation(java.lang.String)
     */
    @Override
    public void operation(String state) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("字符" + this.initr + "的字体为" + state);
    }
    
    /**
     * @see com.cq.model.flyweight.simple.FlyWeight#operation2(com.cq.model.flyweight.simple.List)
     */
    @Override
    public ArrayList operation2(ArrayList lss) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return null;
    }
    
    /**
     * @param lss
     * @return
     */
    public ArrayList operation2(List lss) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return null;
    }
    
}
