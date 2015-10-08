/**2012-5-26**/

package com.cq.model.prototype;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class DeepClone implements Cloneable {
    
    private Mail[] ls = new Mail[3];
    
    /**
     * @return 获取 ls属性值
     */
    public Mail[] getLs() {
        return ls;
    }
    
    public void set(int index, Mail m) {
        this.ls[index] = m;
    }
    
    public Mail getIndex(int index) {
        return this.ls[index];
        
    }
    
    /**
     * @param ls 设置 ls 属性值为参数值 ls
     */
    public void setLs(Mail[] ls) {
        this.ls = ls;
    }
    
    DeepClone() {
    }
    
    @Override
    public DeepClone clone() {
        DeepClone dc = null;
        try {
            dc = (DeepClone) super.clone();
            // ArrayList的clone为浅克隆，里面的元素为对象的时候，只是复制了其引用，若要克隆，需要自己重新写，里面的元素需要实现克隆方法
            // 数组的克隆为深度克隆，数组里面的元素会生成新的对象
            dc.ls = this.ls.clone();
        } catch (CloneNotSupportedException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        return dc;
    }
    
    public static void main(String args[]) {
        AdvTemplate adv = new AdvTemplate();
        DeepClone dc1 = new DeepClone();
        Mail m1 = new Mail(adv);
        m1.setTitle("dc1.mail");
        dc1.set(0, m1);
        
        DeepClone dc2 = dc1.clone();
        Mail m2 = dc2.getIndex(0);
        
        System.out.println(m1);
        System.out.println(m2);
        System.out.println();
        
        Mail[] ls2 = dc2.ls;
        Mail m3 = new Mail(adv);
        m3.setTitle("dc2.mail");
        dc2.set(0, m3);
        
        System.out.println(dc1.getIndex(0));
        System.out.println(dc2.getIndex(0));
        
    }
}
