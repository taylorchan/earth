/**2012-6-23**/

package com.cq.effectivejava.p27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public class GenericStaticFactory {
    
    /**
     * 泛型静态工厂方法—————— <k,v>为类型参数列表 返回类型为HashMap<k,v>
     * 
     * @param <k>
     * @param <v>
     * @return
     */
    public static <k, v> HashMap<k, v> newHashMap() {
        return new HashMap<k, v>();
    }
    
    /**
     * @param <k>
     * @param <v>
     * @param i
     * @return
     */
    public <k, v> HashMap<k, v> newHashMap(int i) {
        return new HashMap<k, v>(i);
    }
    
    /**
     * 
     */
    public void test() {
        Map<String, List<String>> map = newHashMap();
    }
}
