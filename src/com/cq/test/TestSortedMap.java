/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.util.Comparator;
import java.util.TreeMap;


/**
 * 
 * @author:   chenqiang3
 * @since:    2015-4-4
 * @version : 1.0
 */
public class TestSortedMap {
    public static void main(String args[]){
        TreeMap<Mapkey, Object> treeMap = new TreeMap<Mapkey, Object>(new zCompartor());
        Object o = new Object();
        Mapkey key1 = new Mapkey("key1");
        Mapkey key2 = new Mapkey("key22");
        Mapkey key3 = new Mapkey("key3");
        treeMap.put(key1, o);
        treeMap.put(key3, o);
        treeMap.put(key2, o);
        System.out.println(treeMap.toString());
    }
    
    
    private static class zCompartor implements Comparator{

        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(Object o1, Object o2) {
           Mapkey m1 = Mapkey.class.cast(o1);
           Mapkey m2 = Mapkey.class.cast(o2);
            return m1.compareTo(m2);
        }
        
    }
}

class Mapkey implements Comparable{

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    private String key;

    Mapkey(String key){
        this.key = key;
    }

    @Override
    public String toString(){
       return "map key is " + this.key;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        String thatKey = Mapkey.class.cast(o).key;
        int result = this.key.compareTo(thatKey);
        System.out.println("this key is " + key + ", that key is " + thatKey +", compare result is " + result);
        return result;
    }
    
}
