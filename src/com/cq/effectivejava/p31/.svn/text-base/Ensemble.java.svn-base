/**2012-6-24**/

package com.cq.effectivejava.p31;

/**
 * 利用实例域代替序数
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
public enum Ensemble {
    /*
     * 即不要使用枚举的序数，而是将其保存在一个实例域中
     */
    SOLO(1), DUET(2), TRIO(3), QUARTET(4);
    
    private final int numberOfMusicians;
    
    Ensemble(int num) {
        this.numberOfMusicians = num;
    }
    
    public int numberOfMusicians() {
        return this.numberOfMusicians;
    }
}
