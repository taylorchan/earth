/**2012-6-20**/

package com.cq.effectivejava.p21;

import java.util.Comparator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-20 陈强新建
 */
public class Strategy {
    
    /**
     * 具体的策略，实现comparator接口 内部类的目的是为其外部类提供服务
     * 
     * @author 陈强
     * @since 1.0
     * @version 2012-6-20 陈强新建
     */
    private static class StrLenCmp implements Comparator<String> {
        
        /**
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(String o1, String o2) {
            // TODO 自动生成方法存根注释，方法实现时请删除此注释
            if (o1 == null || o2 == null) {
                return 0;
            }
            
            return (o1.length() - o2.length());
        }
    }
    
    /**
     * 策略的复用，只用一次的情况下使用匿名内部类
     */
    public static final Comparator<String> STR_LEN_CMP = new StrLenCmp();
    
}
