/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-18
 * @version : 1.0
 */
public class IntBufferDemo {
    
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(128);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{1,2,55,66,4});
        System.out.println(ib.get(3));
        ib.put(3, 9);
        ib.flip();
        while(ib.hasRemaining()){
            int i = ib.get();
            System.out.println(i);
            
        }
        
        
        
    }
}
