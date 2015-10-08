/**2012-5-17**/

package com.cq.model.singleton;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-17 陈强新建
 */
public class MySingleton {
    
    private MySingleton() {
    }
    
    @Override
    public String toString() {
        return "singleton!!****";
    }
    
    private static MySingleton instance = null;
    
    /**
     * 通用单例模式
     * 
     * @return
     */
    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
    
}
