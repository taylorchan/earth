/**2012-6-24**/

package com.cq.effectivejava.p39;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 保护性拷贝-避免外界的破坏
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-24 陈强新建
 */
public class Period {
    
    /**
     * 访问域不能为public，数组内部的元素可以被直接修改
     */
    private static final Integer[] VALUES = { 1, 3, 4, 5 };
    
    /**
     * 不能直接将组件返回给客户端
     * 
     * @return
     */
    public Integer[] getInteger() {
        return VALUES.clone();
    }
    
    /**
     * 返回不可变列表
     * 
     * @return
     */
    public List<Integer> getInt() {
        return Collections.unmodifiableList(Arrays.asList(VALUES));
        // / return new ArrayList(VALUES);
    }
    
    private final Date start;
    
    /**
     * 不应该把组件的引用返回给客户端
     * 
     * @return 获取 start属性值
     */
    public Date getStart() {
        // return start;
        return new Date(start.getTime());
    }
    
    /**
     * @return 获取 end属性值
     */
    public Date getEnd() {// get方法直接返回 end对象，使得外部可以在获取end对象后，修改end的值
        // return end;
        // 执行保护性拷贝,这可以确定end的类型确实为java.util.Date，所以可以使用克隆方法
        return end.getClass().cast(end.clone());
    }
    
    private final Date end;
    
    /**
     * 构造器参数为引用类型需要特别注意
     * 
     * @param date
     * @param d2
     * @throws Exception
     */
    public Period(Date date, Date d2) throws Exception {
        // 直接赋值引用，存在易被改变的危险
        // this.start = date;
        // this.end = d2;
        // 进行保护性拷贝，不确定date，d2一定为Date类型（恶意的子类），所以不要用clone方法
        this.start = new Date(date.getTime());
        this.end = new Date(d2.getTime());
        if (end.compareTo(start) < 0) {// 有效性检查在拷贝对象之后
            throw new Exception();
        }
    }
    
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = null;
        try {
            p = new Period(start, end);
        } catch (Exception e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        // end被改变了
        end.setDate(3);
        
    }
}
