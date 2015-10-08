/**2012-6-23**/

package com.cq.effectivejava.p26;

import java.util.Collection;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 * @param <E>
 */
public class Stack<E> {
    
    private E[] elements;
    
    private int size = 0;
    
    /**
     * @return 获取 size属性值
     */
    public int getSize() {
        return size;
    }
    
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    /**
    * 
    */
    @SuppressWarnings("unchecked")
    public Stack() {// E[]为不可具体化的类型
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    /**
     * @param e
     */
    public void push(E e) {
        this.ensureCapacity();
        elements[size++] = e;
    }
    
    /**
     * 不要使用通配符作为返回值的类型
     * 
     * @return
     * @throws Exception
     */
    public E pop() throws Exception {
        if (size == 0) {
            throw new Exception("no element!");
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }
    
    /**
     * 验证容量
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= elements.length) {
            E[] newArray = (E[]) new Object[size * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }
    
    /**
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    
    /**
     * 使用通配符类型 ——————参数化类型表示一个E的生产者 producer-extends
     * 
     * @param src
     */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
        
    }
    
    /**
     * 使用超类通配符————-参数化类型表示一个E的消费者 consumer-super
     * 
     * @param dst
     * @throws Exception
     */
    public void popAll(Collection<? super E> dst) throws Exception {
        while (!isEmpty()) {
            dst.add(this.pop());
        }
    }
}
