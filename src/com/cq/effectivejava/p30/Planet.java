/**2012-6-23**/

package com.cq.effectivejava.p30;

import java.util.Arrays;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public enum Planet {
    // 表示成这种形态决定了其必须要构造器及构造器的形式
    // 行星的质量-半径
    MERCRY(3.302e+23, 2.439e6), VENUS(4.869e+24, 6.052e6), EARTH(5.975e+24, 6.378e6);
    
    private static final double G = 6.67E-11;
    
    private final double mass;
    
    private final double radius;
    
    private final double surfaceGravity;
    
    Planet(double d1, double d2) {
        this.mass = d1;
        this.radius = d2;
        surfaceGravity = G * mass / (radius * radius);
    }
    
    /**
     * 求重力
     * 
     * @param mass
     * @return
     */
    public double surfaceWeight(double materia) {
        return materia * surfaceGravity;// F=ma
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Planet.values()));
        double m = 100;
        for (Planet p : Planet.values()) {
            System.out.println("weight on " + p + " is: " + p.surfaceWeight(m));
        }
    }
}
