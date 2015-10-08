/**2012-5-27**/

package com.cq.model.flyweight.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户端获取享元不能直接获取，只能通过工厂获得
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class FlyWeightFactory {
    
    private final Map<Character, FlyWeight> files = new HashMap<Character, FlyWeight>();
    
    private FlyWeight fly;
    
    public FlyWeightFactory() {
    }
    
    /**
     * 产生一个新的字符，不存在，则new 一个享元对象，存在的话则直接从map中拿
     * 
     * @param c
     * @return
     */
    public FlyWeight factory(Character c) {
        if (this.files.containsKey(c)) {
            return this.files.get(c);
        } else {
            fly = new ConcreteFlyWeight(c);
            files.put(c, fly);
            return fly;
        }
    }
}
