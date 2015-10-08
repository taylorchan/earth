/**2012-7-11**/

package com.cq.arithmeticinjava.p6;

import java.util.List;

/**
 * @author Taylor Chan
 * @since 1.0
 * @version 2012-7-11 Taylor Chan Creat
 */
public class Arraysf {
    
    public static void main(String[] args) {
        // convariant array type;协变数组类型，这里只能放入string类型
        Object[] array = new String[3];
        array[0] = 'd';
        List<String> ls = null;
        // 泛型不是协变的
        // testGneraltic(ls);
        // 通过通配符解决泛型的协变问题
        testGneraltic2(ls);
    }
    
    /**
     * @param list
     */
    public static void testGneraltic(List<Object> list) {
        
    }
    
    /**
     * ceps原则，这里是消耗list中的元素
     * 
     * @param list
     */
    public static void testGneraltic2(List<? extends Object> list) {
        
    }
    
    /**
     * 泛型static方法 寻找T[] array中是否含有t（泛型在方法的多个地方出现，使用这种场景）
     * 
     * @param <T>
     * @param array
     * @param t
     * @return
     */
    public static <T> boolean contains(T[] array, T t) {
        for (T t1 : array) {
            if (t1.equals(t)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 使用 类型限界与通配符,限制泛型的类型--- ceps原则 , 加了通配符，square就可以跟shape对象 compare（square
     * extends shape，shape implements Comparable） 这里是产生一个Comparable对象
     * 
     * @param <T>
     * @param array
     * @return
     */
    public static <T extends Comparable<? super T>> T findMax(T[] array) {
        int index = 0;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i].compareTo(array[index]) > 0) {
                index = i;
            }
        }
        return array[index];
    }
}
