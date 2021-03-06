/**2012-7-2**/

package com.cq.arithmeticinjava.p4;

import java.util.Arrays;

/**
 * 自己实现的栈
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-7-2 陈强新建
 * @param <T>
 */

public class Stack<T> {
    
    private static final int INITIALIZE_SIZE = 10;
    
    private int size;
    
    private T[] element;
    
    /**
     * 栈顶元素
     */
    private int top;
    
    /**
     * 
     */
    public Stack() {
        @SuppressWarnings("unchecked")
        T[] newInstance = (T[]) new Object[INITIALIZE_SIZE];
        element = newInstance;
        size = INITIALIZE_SIZE;
        // 不存在元素的时候
        top = -1;
    }
    
    /**
     * @param size
     */
    public Stack(int size) {
        @SuppressWarnings("unchecked")
        T[] newInstance = null;
            
        newInstance =  (T[])java.lang.reflect.Array
        .newInstance(newInstance.getClass().getComponentType(), size);
        element = newInstance;
        this.size = size;
        top = -1;
    }
    
    /**
     * @param ele
     */
    public void push(T ele) {
        checkVolumn();
        element[++top] = ele;
    }
    
    /**
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        int pos = top;
        T e = element[top--];
        element[pos] = null;
        return e;
    }
    
    /**
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        T e = element[top];
        return e;
    }
    public void emptyStack(){
        element = null;
        top = -1;
        size = 0;
    }
    
    /**
     * @return
     */
    public boolean isEmpty() {
        return (top == -1);
    }
    
    /**
     * 容量检查
     */
    private void checkVolumn() {
        if (top + 1 == size) {// 扩容
            int newSize = size * 2;
            T[] newInstance = Arrays.copyOf(element, newSize);
            this.element = newInstance;
            this.size = newSize;
        }
    }
    
    public static void main(String[] args) {
        String name = "My name is Lilei!";
        char[] charArray = name.toCharArray();
        Stack<Character> s = new Stack<Character>(20);
        for (int i = 0; i < charArray.length; i++) {
            s.push(charArray[i]);
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        
    }
}
