/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.model.singleton;


/**
 * 
 * @author:   chenqiang3
 * @since:    2015-3-14
 * @version : 1.0
 */
public class MySingleton2 {
   
    //饿汉式
    private static MySingleton2 instance = new MySingleton2();
    
    private MySingleton2(){
    }
    
    
    public static MySingleton2 getMySingleton(){
        return instance;
        
    } 
    
    /**
     * 多线程的情况下的单例实现
     * 方法级别的,性能差些.
     * 
     */
    public static synchronized MySingleton2 getMySingleton2(){
        if(instance == null){
            instance = new MySingleton2();
        }
        return instance;
    }
    
    /**
     * 改进型的多线程单例实现
     * 
     */
    public static MySingleton2 getMySingleton3(){
        if(instance == null){
            synchronized (MySingleton2.class) {
                    instance = new MySingleton2();
            }
        }
        return instance;
    }



    /**
     * 改进型的多线程单例实现,这样才彻底没问题.
     * 
     */
    public static MySingleton2 getMySingleton4(){
        if(instance == null){
            synchronized (MySingleton2.class) {
                if(instance == null)
                    instance = new MySingleton2();
            }
        }
        return instance;
    }
}
