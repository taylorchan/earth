/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.Map;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public abstract class Expression {
    
    /**
     * 解析公式和数字
     * 
     * @param map
     * @return
     */
    public abstract int intepreter(Map<String, Integer> map);
}
