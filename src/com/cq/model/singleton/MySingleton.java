/**2012-5-17**/

package com.cq.model.singleton;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-17 ��ǿ�½�
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
     * ͨ�õ���ģʽ
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
