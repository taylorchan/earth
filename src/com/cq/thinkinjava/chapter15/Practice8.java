/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.thinkinjava.chapter15;

import java.util.Random;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-1 陈强新建
 */
public class Practice8 {
    
}

class StoryCharacters {
    
}

class GoodGuys extends StoryCharacters {
    
}

class BadGuys extends StoryCharacters {
    
}

class CharactersGenerator implements CharactersGenerate<StoryCharacters> {
    
    /**
     * @return
     * @see com.cq.thinkinjava.chapter15.CharactersGenerate#generateChar()
     */
    @Override
    public StoryCharacters generateChar() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        try {
            return (StoryCharacters) characterArray[rand.nextInt(characterArray.length)].newInstance();
        } catch (InstantiationException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        return null;
    }
    
    private static Random rand = new Random(50);
    
    private final Class[] characterArray = { GoodGuys.class, BadGuys.class };
    
}

interface CharactersGenerate<T> {
    
    T generateChar();
}
