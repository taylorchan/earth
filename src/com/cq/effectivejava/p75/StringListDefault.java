/**2012-6-29**/

package com.cq.effectivejava.p75;

import java.io.Serializable;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-29 陈强新建
 */
public final class StringListDefault implements Serializable {
    
    /***/
    private static final long serialVersionUID = -9098983315407354436L;
    
    private final int size = 0;
    
    private final Entry head = null;
    
    private static class Entry implements Serializable {
        
        /***/
        private static final long serialVersionUID = 7241660238243206501L;
        
        String data;
        
        Entry next;
        
        Entry pre;
    }
    
}
