
package com.cq.thinkinjava.chapter14;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-2-24 ��ǿ�½�
 */
public class Practice8 {
    
    static void getAllSuperClassInfo(Object obj) {
        Class father = ((Class) obj).getSuperclass();
        System.out.println(father.getCanonicalName());
        if (father == Object.class) {
            return;
        }
        getAllSuperClassInfo(father);
    }
    
    public static void main(String args[]) {
        Class arraylist = null;
        try {
            arraylist = Class.forName("java.util.ArrayList");
        } catch (ClassNotFoundException e) {
            // TODO �Զ������쳣�������ע�ͣ���ʵ��ʱ��ɾ����ע��
            e.printStackTrace();
        }
        getAllSuperClassInfo(arraylist);
        for (Field filed : arraylist.getDeclaredFields()) {
            System.out.println(filed);
        }
        char[] c = { 'd', 's' };
        Class charClassArry = c.getClass();
        if (charClassArry.isPrimitive()) {
            System.out.println("Primitive");
        } else if (charClassArry.isArray()) {
            System.out.println("Object");
        }
        Class<MyList> ay = MyList.class;
        // ����д�ǲ��Ե�,��������д����ȷ
        // Class<AbstractList> abL = ay.getSuperclass();
        Class<? super MyList> abL = ay.getSuperclass();
        try {
            System.out.println(abL.newInstance().getClass().getCanonicalName());
        } catch (InstantiationException e) {
            // TODO �Զ������쳣�������ע�ͣ���ʵ��ʱ��ɾ����ע��
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO �Զ������쳣�������ע�ͣ���ʵ��ʱ��ɾ����ע��
            e.printStackTrace();
        }
    }
}

class MyList extends ArrayList {
}
