/**2012-6-20**/

package com.cq.effectivejava.p22;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-20 陈强新建
 */
public class InnerMember {
    
    class MySet<E> extends AbstractSet<E> {
        
        /**
         * @author 陈强
         * @since 1.0
         * @version 2012-6-20 陈强新建
         */
        private class MyIterator implements Iterator<E> {
            
            /**
             * @see java.util.Iterator#hasNext()
             */
            @Override
            public boolean hasNext() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                return false;
            }
            
            /**
             * @see java.util.Iterator#next()
             */
            @Override
            public E next() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                return null;
            }
            
            /**
             * @see java.util.Iterator#remove()
             */
            @Override
            public void remove() {
                // TODO 自动生成方法存根注释，方法实现时请删除此注释
                
            }
            
        }
        
        /**
         * @see java.util.AbstractCollection#iterator()
         */
        @Override
        public Iterator<E> iterator() {
            // TODO 自动生成方法存根注释，方法实现时请删除此注释
            return new MyIterator();
        }
        
        /**
         * @see java.util.AbstractCollection#size()
         */
        @Override
        public int size() {
            // TODO 自动生成方法存根注释，方法实现时请删除此注释
            return 0;
        }
    }
    
    public static void main(String args[]) {
        int i = 10;
        int length = 16;
        System.out.println(i & length);
    }
}
