/**2012-5-27**/

package com.cq.model.flyweight.complex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cq.model.flyweight.simple.ConcreteFlyWeight;
import com.cq.model.flyweight.simple.FlyWeight;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class FlyWeightFactory {
    
    /**
     * 此处的flyweight为simple单纯享元对象
     */
    private final Map<Character, FlyWeight> files = new HashMap<Character, FlyWeight>();
    
    /**
     * 返回一个复合享元
     * 
     * @param compositeState
     * @return
     */
    public FlyWeight factory(List<Character> compositeState) {
        ConcreteComplexFlyweight con = new ConcreteComplexFlyweight();
        for (Character c : compositeState) {
            con.add(c, this.factory(c));
        }
        return con;
    }
    
    /**
     * 产生一个新的字符，不存在，则new 一个享元对象，存在的话则直接从map中拿
     * 
     * @param c
     * @return
     */
    private FlyWeight factory(Character c) {
        FlyWeight fw = files.get(c);
        if (fw == null) {
            fw = new ConcreteFlyWeight(c);
            files.put(c, fw);
        }
        return fw;
    }
}
