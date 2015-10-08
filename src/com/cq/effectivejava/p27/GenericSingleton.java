/**2012-6-23**/

package com.cq.effectivejava.p27;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public class GenericSingleton {
    
    interface UnaryFunction<T> {
        
        T apply(T arg);
    }
    
    /**
     * 泛型单例
     */
    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        
        @Override
        public Object apply(Object arg) {
            // TODO 自动生成方法存根注释，方法实现时请删除此注释
            return arg;
        }
    };
    
    /**
     * IDENTITY_FUNCTION是无状态的并且它的参数是未绑定的
     * 
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryFunction<String> sameString = identityFunction();
        for (String string : strings) {
            System.out.println(sameString.apply(string));
        }
        Number[] num = { 1, 2.32, 3L };
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number number : num) {
            System.out.println(sameNumber.apply(number));
        }
    }
}
