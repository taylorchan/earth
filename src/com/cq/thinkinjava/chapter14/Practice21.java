
package com.cq.thinkinjava.chapter14;

import static net.mindview.util.Print.print;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-29 ��ǿ�½�
 */

public class Practice21 {
    
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    
    public static void main(String[] args) {
        consumer(new RealObject());
        SimpleProxy in = new SimpleProxy(new RealObject());
        consumer(in);
        System.out.println(in.getMethodCount());
    }
}

interface Interface {
    
    void doSomething();
    
    void somethingElse(String arg);
}

class RealObject implements Interface {
    
    public void doSomething() {
        print("doSomething");
    }
    
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

/**
 * ����䵱���м��˵Ľ�ɫ���ǲ�����������ʵ�ʶ���Ķ�����Щ����ͨ���漰����ʵ�ʶ����ͨ�� ��Ȼ�Ǵ�������ʵ�ʶ��������Ƶĵط�
 */
class SimpleProxy implements Interface {
    
    private final Interface proxied;
    
    private int methodCount;
    
    /**
     * @return ��ȡ methodCount����ֵ
     */
    public int getMethodCount() {
        return methodCount;
    }
    
    /**
     * @param methodCount ���� methodCount ����ֵΪ����ֵ methodCount
     */
    public void setMethodCount(int methodCount) {
        this.methodCount = methodCount;
    }
    
    /**
     * @return ��ȡ proxied����ֵ
     */
    public Interface getProxied() {
        return proxied;
    }
    
    // �����г�ʼ��ʵ�ʶ���
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    
    // ע����spring�� aop�Ա�һ�£��˴����������൱�ڽ�ҵ���������������
    public void doSomething() {
        print("SimpleProxy doSomething");
        proxied.doSomething();
        methodCount++;
        
    }
    
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        methodCount++;
    }
}

/*
 * Output: doSomething somethingElse bonobo SimpleProxy doSomething doSomething
 * SimpleProxy somethingElse bonobo somethingElse bonobo
 */// :~
