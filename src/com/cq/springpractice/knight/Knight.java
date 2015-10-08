/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.springpractice.knight;

/**
 * 圆桌骑士问题
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-11-16 陈强新建
 */
interface Knight {
    
    Object embarkOnQuest();
}

class KnightOfTheRoundTable implements Knight {
    
    /**
     * 骑士姓名
     */
    private String name;
    
    private Quest quest;
    
    /**
     * @param quest 设置 quest 属性值为参数值 quest
     */
    public void setQuest(Quest quest) {
        this.quest = quest;
    }
    
    /**
     * @param name 设置 name 属性值为参数值 name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return 获取 name属性值
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return 获取 quest属性值
     */
    public Quest getQuest() {
        return quest;
    }
    
    /**
     * constructor 骑士通过接口探险，但是仍然是一个具体的探险类型；
     * 若是通过set方法来设置quest的值，则可以按自己的需要赋值任意一种Quest的实现 协调依赖对象之间合作的责任从对象自身转移出来
     * 
     * @param name
     */
    public KnightOfTheRoundTable(String name) {
        this.name = name;
        this.quest = new HolyGrailQuest();
    }
    
    public Object embarkOnQuest() {
        return quest.embark();
    }
}
