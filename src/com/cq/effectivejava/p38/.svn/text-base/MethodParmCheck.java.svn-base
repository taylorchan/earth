/**2012-6-24**/

package com.cq.effectivejava.p38;

import java.math.BigInteger;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
public class MethodParmCheck {
    
    /**
     * 公有方法的处理，进入方法的时候进行合法检查，抛出相应的异常，注释里面添加throws标签，
     * 
     * @param m
     * @return
     * @throws ArithmeticException if m < 0;
     */
    public BigInteger mod(BigInteger m) {
        if (m.signum() < 0) {
            throw new ArithmeticException("native number");
        }
        return null;
    }
    
    /**
     * 对于非公有方法应该使用断言来检查
     * 
     * @param a
     * @param offset
     * @param length
     */
    private static void sort(long a[], int offset, int length) {
        // 执行到此处不符合断言则会终止
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        
    }
    
    public static void main(String[] args) {
        long[] longarray = null;
        sort(longarray, 5, 6);
        
    }
}
