
/******************************************************************************
s *****************************************************************************/

package com.cq.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2011-10-31 ��ǿ�½�
 */
public class HeapOOM {
    
    static class OOMObject {
        
    }
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        List<OOMObject> ls = new ArrayList<OOMObject>();
        while (true) {
            ls.add(new OOMObject());
        }
    }
}
