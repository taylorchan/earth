/**2012-3-18**/

package com.cq.thinkinjava.chapter18;

import java.io.Serializable;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-18 ��ǿ�½�
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
     * @return ��ȡ num����ֵ
     */
    public int getNum() {
        return num;
    }
    
    /**
     * @param num ���� num ����ֵΪ����ֵ num
     */
    public void setNum(int num) {
        this.num = num;
    }
    
    /**
     * @return ��ȡ name����ֵ
     */
    public String getName() {
        return Name;
    }
    
    /**
     * @param name ���� name ����ֵΪ����ֵ name
     */
    public void setName(String name) {
        Name = name;
    }
    
    /**
     * @return ��ȡ age����ֵ
     */
    public int getAge() {
        return age;
    }
    
    /**
     * @param age ���� age ����ֵΪ����ֵ age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * @return ��ȡ sex����ֵ
     */
    public String getSex() {
        return sex;
    }
    
    /**
     * @param sex ���� sex ����ֵΪ����ֵ sex
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
    // // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
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
    // // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
    // out.writeInt(age);
    // out.writeUTF(Name);
    // out.writeInt(num);
    // out.writeUTF(sex);
    //        
    // }
}
