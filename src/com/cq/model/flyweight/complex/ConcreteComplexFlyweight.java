/**2012-5-27**/

package com.cq.model.flyweight.complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cq.model.flyweight.simple.FlyWeight;

/**
 * 复杂享元对象
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class ConcreteComplexFlyweight implements FlyWeight {
    
    /**
     * 复合享元对象
     */
    private final Map<Character, FlyWeight> files = new HashMap<Character, FlyWeight>();
    
    /**
     * 添加一个新的单纯享元对象到聚集中
     * 
     * @param c
     * @param fw
     */
    public void add(Character c, FlyWeight fw) {
        files.put(c, fw);
    }
    
    /**
     * 复合享元对象的所有单纯享元对象的外蕴状态相同
     * 
     * @see com.cq.model.flyweight.simple.FlyWeight#operation(java.lang.String)
     */
    @Override
    public void operation(String state) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        FlyWeight fly = null;
        for (Character c : files.keySet()) {
            fly = files.get(c);
            fly.operation(state);
        }
    }
    
    /**
     * @see com.cq.model.flyweight.simple.FlyWeight#operation2(java.util.List)
     */
    @Override
    public ArrayList operation2(ArrayList lss) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return null;
    }
    
}
