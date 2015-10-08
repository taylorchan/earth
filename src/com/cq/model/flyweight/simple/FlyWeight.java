/**2012-5-27**/

/**2012-5-27**/

package com.cq.model.flyweight.simple;

import java.util.ArrayList;

/**
 * 单纯享元模式 以共享的方式支持大量细粒度的对象
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public interface FlyWeight {
    
    void operation(String state);
    
    ArrayList operation2(ArrayList lss);
}
