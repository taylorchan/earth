/**2012-3-18**/

package com.cq.thinkinjava.chapter18;

import java.io.Serializable;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-18 陈强新建
 */
public class Student implements Serializable {
    
    /***/
    private static final long serialVersionUID = -8023364986145801007L;
    
    public Student(int num, String name, String sex, int age) {
        this.num = num;
        this.Name = name;
        this.age = age;
        this.sex = sex;
    }
    
    /**
     * @return 获取 num属性值
     */
    public int getNum() {
        return num;
    }
    
    /**
     * @param num 设置 num 属性值为参数值 num
     */
    public void setNum(int num) {
        this.num = num;
    }
    
    /**
     * @return 获取 name属性值
     */
    public String getName() {
        return Name;
    }
    
    /**
     * @param name 设置 name 属性值为参数值 name
     */
    public void setName(String name) {
        Name = name;
    }
    
    /**
     * @return 获取 age属性值
     */
    public int getAge() {
        return age;
    }
    
    /**
     * @param age 设置 age 属性值为参数值 age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * @return 获取 sex属性值
     */
    public String getSex() {
        return sex;
    }
    
    /**
     * @param sex 设置 sex 属性值为参数值 sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    private int num;
    
    private String Name;
    
    private int age;
    
    private String sex;
    
    @Override
    public String toString() {
        return "name:" + this.Name + "  age:" + this.age + "   number:" + this.num + "   sex:" + this.sex;
    }
    
    // /**
    // * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
    // */
    // @Override
    // public void readExternal(ObjectInput in) throws IOException,
    // ClassNotFoundException {
    // // TODO 自动生成方法存根注释，方法实现时请删除此注释
    // this.age = in.readInt();
    // this.Name = in.readUTF();
    // this.num = in.readInt();
    // this.sex = in.readUTF();
    // }
    //    
    // /**
    // * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
    // */
    // @Override
    // public void writeExternal(ObjectOutput out) throws IOException {
    // // TODO 自动生成方法存根注释，方法实现时请删除此注释
    // out.writeInt(age);
    // out.writeUTF(Name);
    // out.writeInt(num);
    // out.writeUTF(sex);
    //        
    // }
}
