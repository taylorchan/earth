package com.cq.effectivejava.clone.Variability;


/**
 * @author qiang.chen
 *
 */
public class Complx {
    private final double  re;
    private  final double  mi;
    
    /**
     * @param re
     * @param mi
     */
    public Complx(double re,double mi){
        this.re = re;
        this.mi = mi;
    }
    
    /**
     * @param o
     * @return
     */
    public Complx add(Complx o){
        return new Complx(o.re+re, o.mi+mi);
    }
    /**
     * how to write equals method
     */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Complx))  return false;
        Complx c= (Complx)o;
        //浮点数的比较方法
        return (Double.compare(c.re, this.re) ==0 && Double.compare(c.mi, this.mi)==0);
    }
    @Override
    public int hashCode(){
        int result = 17 + hashDouble(re);
        result = 31*result + hashDouble(mi);
        return result;
    }
    /**
     * 针对double的hashcode如何编写
     * @param val
     * @return
     */
    private int hashDouble(double val){
        long bit = Double.doubleToLongBits(val);
        return (int)(bit ^(bit >>> 32));// j/(int)(Math.pow(2,i))//运算2的i次方
    }
    
    public static void main(String args[]){
        int i = 888;
        System.out.println(i >> 4);
        System.out.println(i >>>4);
    }
}
