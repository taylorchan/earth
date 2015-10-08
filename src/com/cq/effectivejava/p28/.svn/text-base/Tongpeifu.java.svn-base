/**2012-6-23**/

package com.cq.effectivejava.p28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.cq.effectivejava.p26.Stack;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public class Tongpeifu {
    
    public static void main(String args[]) {
        Stack<Number> numberStack = new Stack<Number>();
        Iterable<Integer> intergers = new Iterable<Integer>() {
            
            @Override
            public Iterator<Integer> iterator() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                return null;
            }
            
        };// 即不能想当然 的认为：用List<Object>就可以用List<String>
        numberStack.pushAll(intergers);
        
        Stack<Number> numberStack2 = new Stack<Number>();
        Iterable<Double> doubles = new Iterable<Double>() {
            
            @Override
            public Iterator<Double> iterator() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                return null;
            }
            
        };
        numberStack.pushAll(intergers);
        // 使用了超类通配符
        Collection<Object> objects = new ArrayList<Object>();
        try {
            numberStack.popAll(objects);
        } catch (Exception e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
    }
}
