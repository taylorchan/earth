/******************************************************************************
 * Copyright (C) 2012 ShenZhen Xinyi Technology Co.Ltd,.
 * All Rights Reserved.
 * 本软件为深圳信义科技开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq.arithmeticinjava.p5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qiang.chen
 * @since: 2012-7-8
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class Test {
    
    private static class Model {
        
        Model(int size, String name) {
            this.size = size;
            this.name = name;
        }
        
        int size;
        
        String name;
    };
    
    private static class Msg {
        
        Msg(String name, int len, int offset, int index) {
            this.name = name;
            this.len = len;
            this.offset = offset;
            this.index = index;
        }
        
        String name;
        
        int len;
        
        int offset;
        
        int index;
        
        @Override
        public String toString() {
            return " name: " + name + " ,len: " + len + " ,offset: " + offset + " ,index: " + index;
        }
    }
    
    public static void main(String[] args) {
        Map<Integer, List<Msg>> splitMap = new HashMap<Integer, List<Msg>>();
        
        Model[] models =
            { new Model(67, "model1"), new Model(278, "model2"), new Model(45, "model3"), new Model(38, "model4"),
                new Model(140, "model5") };
        int sum = 0;
        for (Model model : models) {
            sum += model.size;
        }
        int num = 5;
        int spilitSize = sum / 5;
        int yushu = sum % 5;
        int lastSplitSize = spilitSize + yushu;
        int index = 1;
        
        List<Msg> lsMs = new ArrayList<Msg>();
        splitMap.put(index, lsMs);
        int modelIndex = 0;
        int modelConsume = 0;
        int sliceConsume = 0;
        for (int i = 0; i < models.length; i++) {
            if (index == num) {
                spilitSize = lastSplitSize;
            }
            // model剩余分配量
            int modelLeft = models[i].size - modelConsume;
            int sliceLeft = spilitSize - sliceConsume;
            while (modelLeft > sliceLeft && index <= num) {// 剩余量大于一个splitSize,新建一个spilit对象
                sliceLeft = spilitSize - sliceConsume;// 填满spice剩余部分
                Msg msg = new Msg(models[i].name, sliceLeft, modelConsume, modelIndex++);
                modelConsume += sliceLeft;
                lsMs.add(msg);
                sliceConsume = 0;
                lsMs = new ArrayList<Msg>();
                splitMap.put(++index, lsMs);
                if (index == num) {
                    spilitSize = lastSplitSize;
                }
                sliceLeft = spilitSize - sliceConsume;
                modelLeft = models[i].size - modelConsume;
            }
            if (modelLeft <= sliceLeft) {
                Msg msg = new Msg(models[i].name, modelLeft, modelConsume, modelIndex++);
                sliceConsume += modelLeft;
                modelConsume = 0;
                modelIndex = 0;
                lsMs.add(msg);
            }
        }
        // for (List<Msg> msg : lsSpilt) {
        // for (Msg msg2 : msg) {
        // System.out.println(msg2);
        // }
        // System.out.println();
        // }
        System.out.println(splitMap);
    }
}
