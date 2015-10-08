/**2012-5-25**/

/**2012-5-25**/

package com.cq.model.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Client {
    /**
     * 菜单
     */
    private static Map<String,Class> menu = new HashMap<String,Class>();
    static{
        menu.clear();
        menu.put("gold", GoldBuilder.class);
        menu.put("normal", NormalBuilder.class);
    }
    
    
    /**
     * 模拟顾客点菜
     * @param args
     */
    public static void main(String[] args) {
        FoodManager foodmanager = new FoodManager();
        String foodType = "normal";
        Class clazz = menu.get(foodType);
        orderFood(foodmanager, clazz);
        
        foodType = "gold";
        clazz = menu.get(foodType);
        orderFood(foodmanager, clazz);
    }
    
    public static void orderFood(FoodManager foodmanager,Class clazz){
        Builder instance;
        try {//c
            instance = (Builder) clazz.newInstance();
            foodmanager.Construct(instance);
            Food food = instance.GetFood();
            food.Show();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
    }
}
