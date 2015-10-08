/**2012-6-24**/

package com.cq.effectivejava.p43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
public class NotReturnNull {
    
    private class Cheese {
        
    };
    
    private final List<Cheese> cheeseInStock = new ArrayList<Cheese>();
    
    /**
     * 预设一个0长度的数组使用，方便使用且节省消耗
     */
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    
    /**
     * @return
     */
    public Cheese[] getCheeses() {
        if (this.cheeseInStock.isEmpty()) {// 如果这样做，每次在使用此方法的时候，都要检查getChessses是否为null，否则会抛出空指针的异常
            return null;
        }
        // 返回一个长度为0的数组是通用做法，当list为空的时,将使用0长度的输入数组
        return cheeseInStock.toArray(EMPTY_CHEESE_ARRAY);
    }
    
    /**
     * 返回一个长度为0的list
     * 
     * @return
     */
    public List<Cheese> getCheeseList() {
        if (cheeseInStock.isEmpty()) {
            return Collections.emptyList();
        }
        // 如何返回值，保护性拷贝
        return new ArrayList<Cheese>(cheeseInStock);
    }
}
