/******************************************************************************
 *****************************************************************************/

package com.cq.jvm.constantPool;

/**
 * //运行时常量池：用于存放编译期生成的各种字面量和符号引用。
 * Java 中，每个已加载的类会保存一个常量池，这是没错的。 但这个常量池只是该类的字面值（例如类名、方法名）和符号引用的有序集合。 而字符串常量池，是整个
 * JVM 共享的。
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-10-28 陈强新建
 */
public class ChangLiangPool {
    
    public static void main(String args[]) {
        PoolTest1 t = new PoolTest1();
        PoolTest2 t2 = new PoolTest2();
        System.out.println(t.s == t2.s);
    }
}
