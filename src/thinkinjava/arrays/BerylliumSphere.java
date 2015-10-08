/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲������.
 *****************************************************************************/

package arrays;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-1 ��ǿ�½�
 */
public class BerylliumSphere implements Comparable<BerylliumSphere> {
    
    private static long counter;
    
    private final long id = counter++;
    
    @Override
    public String toString() {
        return "Sphere " + id;
    }
    
    /**
     * ʵ��comparable�ӿ�ʵ�ֶԱ�
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(BerylliumSphere bs) {// ע����ͬ�Ķ������ֱ�ӷ������г�Ա
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        return this.id < bs.getId() ? -1 : (this.id == bs.getId() ? 0 : 1);
    }
    
    /**
     * @return ��ȡ id����ֵ
     */
    public long getId() {
        return id;
    }
}
