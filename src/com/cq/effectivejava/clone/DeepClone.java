package com.cq.effectivejava.clone;


/**
 * 自实现深度克隆
 * @author qiang.chen
 *
 */
public class DeepClone implements Cloneable {
    private Entry[] bucket;
    private static class Entry{
        final Object key;
        Object value;
        Entry next;
        Entry(Object key,Object value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        Entry DeepCopy(){
            return new Entry(key, value, next == null?null:next.DeepCopy());
        }
        
      
    }
    @Override
    public DeepClone clone(){
        DeepClone dc = null;
        try {
            dc = (DeepClone)super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dc.bucket = new Entry[bucket.length];
        for (int i = 0; i <  dc.bucket.length; i++) {
            dc.bucket[i] = bucket[i].DeepCopy();
        }
        return dc;
    }
    
}
