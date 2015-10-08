/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-9-26
 * @version : 1.0
 */
public class ReadWriteMap<k,v> {
    
    private final Map<k, v> map;
    
    private final ReadWriteLock rw = new ReentrantReadWriteLock();
    
    private final Lock r = rw.readLock();
    private final Lock w = rw.writeLock();
    
    public ReadWriteMap() {
        super();
        map = new HashMap<k,v>();
    }
    
    public v put(k key, v val){
        this.w.lock();
        try{
            this.map.put(key, val);
        }finally{
            w.unlock();
        }
        return val;
    }
    
    public v get(k key){
        this.r.lock();
        try{
            return this.map.get(key);
        }finally{
            r.unlock();
        }
    }
    
    public static void main(String args[]) {
        
    }
}
