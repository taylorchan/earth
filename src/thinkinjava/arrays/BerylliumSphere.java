/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package arrays;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-1 陈强新建
 */
public class BerylliumSphere implements Comparable<BerylliumSphere> {
    
    private static long counter;
    
    private final long id = counter++;
    
    @Override
    public String toString() {
        return "Sphere " + id;
    }
    
    /**
     * 实现comparable接口实现对比
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(BerylliumSphere bs) {// 注意相同的对象可以直接访问是有成员
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return this.id < bs.getId() ? -1 : (this.id == bs.getId() ? 0 : 1);
    }
    
    /**
     * @return 获取 id属性值
     */
    public long getId() {
        return id;
    }
}
