/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

/**
 * @author 陈强
 * @since 1.0
 * @version 2011-9-28 陈强新建
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class TestReflect {
    
    public static Object get(String className, Map<String, Object> map) throws Exception {
        Class c = Class.forName(className); // 获得类对象
        Object o = c.newInstance(); // 获得对象
        Set<String> set = map.keySet();
        for (String str : set) {
            String s = "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
            Field f = c.getDeclaredField(str);
            Method m = c.getMethod(s, f.getType()); // 获得方法对象
            m.invoke(o, map.get(str)); // 用方法对象调用方法
        }
        return o;
    }
    
    public static void main(String[] args) throws Exception {
        Map m = new HashMap();
        m.put("name", "zhang");
        m.put("age", 22);
        Object o = get("com.cq.Student", m);
        Student s = (Student) o;
        System.out.println(s.getName() + "   " + s.getAge());
        
        Map m1 = new HashMap();
        m1.put("name", "li");
        m1.put("gender", "男");
        Object o1 = get("com.cq.Teacher", m1);
        Teacher t = (Teacher) o1;
        System.out.println(t.getName() + "    " + t.getGender());
    }
}

class Student {
    
    private String name;
    
    private int age;
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

class Teacher {
    
    private String name;
    
    private String gender;
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
