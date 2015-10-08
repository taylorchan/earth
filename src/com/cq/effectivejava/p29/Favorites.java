/**2012-6-23**/

package com.cq.effectivejava.p29;

import java.util.HashMap;
import java.util.Map;

/**
 * 类型安全的异构容器（异构-所有的键值都是不同类型） class作为参数化键，对象作为值
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public class Favorites {
    
    private final Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();
    
    /**
     * @param <T>
     * @param clazz
     * @param instance
     */
    public <T> void putFavorite(Class<T> clazz, T instance) {
        favorites.put(clazz, clazz.cast(instance));
    }
    
    /**
     * @param <T>
     * @param clazz
     * @return
     */
    public <T> T getFavorite(Class<T> clazz) {
        return clazz.cast(favorites.get(clazz));
    };
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "my bass");
        f.putFavorite(Number.class, 3);
        f.putFavorite(Class.class, Favorites.class);
        
        int num = f.getFavorite(Integer.class);
    }
}
