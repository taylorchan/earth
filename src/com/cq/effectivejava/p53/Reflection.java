/**2012-6-25**/

package com.cq.effectivejava.p53;

import java.util.Set;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-25 陈强新建
 */
public class Reflection {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 可以通过参数传入具体的实例类名
        String runtimeClass = "java.util.HashSet";
        Class cl = null;
        try {
            cl = Class.forName(runtimeClass);
        } catch (ClassNotFoundException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        Set<String> s = null;
        try {
            s = (Set<String>) cl.newInstance();
        } catch (InstantiationException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        s.add("1");
    }
}
