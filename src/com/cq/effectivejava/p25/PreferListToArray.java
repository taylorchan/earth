/**2012-6-23**/

package com.cq.effectivejava.p25;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组是携变可以具体化的，泛型是不可变的且可以被擦除的
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public class PreferListToArray {
    
    /**
     * 
     */
    public void testArray() {
        // 如果sub是super的子类，那么有sub[]就是super[]的子类
        // 相反的List<sub>不是List<super>的子类，可以说无关系
        Object[] objectArray = new Long[1];
        // 只会在运行时跑出ArrayStoreException
        objectArray[0] = "you are fool";
    }
    
    /**
     * 
     */
    public void testList() {
        // 编译的时候即发生错误
        List<Object> ls = new ArrayList<Long>();
        // 只会在运行时产生错误
        ls.add("you are fool");
    }
    
    static Object reduce(List list, Function f, Object initVal) {
        Object[] snapshot = list.toArray();
        Object result = initVal;
        for (Object e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }
    
    interface Function<T> {
        
        T apply(T o1, T o2);
    }
    
    private static class genericMethodClass {
        
        static <E> E reduce(List<E> ls, Function<E> f, E initVal) {
            @SuppressWarnings("unchecked")
            // 编译器无法在运行的时候检查转换的安全性
            // 明确知道数组的类型
            E[] snapshot = (E[]) ls.toArray();// 即便强制类型转换，编译器也无法保证运行时的安全性
            E result = initVal;
            for (E e : snapshot) {
                result = f.apply(result, e);
            }
            return result;
        }
    }
    
    private static class genericMethodClass2 {
        
        /**
         * @param <E>
         * @param ls
         * @param f
         * @param initVal
         * @return
         */
        static <E> E reduce(List<E> ls, Function<E> f, E initVal) {
            List<E> snapshot;
            synchronized (ls) {
                snapshot = new ArrayList<E>(ls);
            }
            E result = initVal;
            for (E e : snapshot) {
                result = f.apply(result, e);
            }
            return result;
        }
    }
}
