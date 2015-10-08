/**2012-6-29**/

package com.cq.effectivejava.p75;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-29 陈强新建
 */
public final class StringList implements Serializable {
    
    /***/
    private static final long serialVersionUID = -2452154581912403345L;
    
    private transient final int size = 0;
    
    private transient Entry head = null;
    
    private Entry con = null;
    
    private static class Entry {
        
        String data;
        
        Entry next;
        
        Entry pre;
    }
    
    /**
     * 向链中添加元素
     * 
     * @param s
     */
    public final void add(String s) {
        Entry entry = new Entry();
        entry.data = s;
        if (head == null) {
            head = entry;
            con = head;
        } else {
            con.next = entry;
            entry.pre = con;
            con = entry;
        }
    }
    
    @Override
    public String toString() {
        
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Entry p = head;
        while (p.next != null) {
            sb.append(p.data);
            p = p.next;
        }
        sb.append(p.data);
        return sb.toString();
    }
    
    private void writeObject(ObjectOutputStream s) {
        try {
            s.defaultWriteObject();
            s.writeInt(size);
            for (Entry e = head; e != null; e = e.next) {
                s.writeObject(e.data);
            }
        } catch (IOException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
    }
    
    private void readObject(ObjectInputStream s) {
        try {
            s.defaultReadObject();
            int num = s.readInt();
            for (int i = 0; i < num; i++) {
                add((String) s.readObject());
            }
        } catch (IOException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String s = "1";
        String w = "2";
        StringList sl = new StringList();
        sl.add(s);
        sl.add(w);
        System.out.println(sl);
    }
}
