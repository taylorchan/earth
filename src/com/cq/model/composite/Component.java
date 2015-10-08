/**2012-5-25**/

package com.cq.model.composite;

/**
 * 
 * 在下面的情况下应当考虑使用合成模式 
 1）需要描述对象的部分和整体的等级结构。 
 2）需要客户端忽略掉个体构件和组合构件的区别。客户端必须平等对待所有的构件，包括个体构件和组合构件
 * 1、（安全式）这种形式涉及到三个角色; 
 1）抽象构件（Component）角色：这是一个抽象角色，它给参加组合的对象规定一个接口。这个角色给出共有的接口机器默认行为。 
 2）树叶构件（Leaf）角色：代表参加组合的树叶对象。一个树叶没有下级的子对象。定义出参加组合的原始对象的行为。 
 3）树枝构件（Composite）角色：代表参加组合的有子对象的对象，并给出树枝构件对象的行为。 
 -------这个方式的缺点就是不够透明，因为树叶类和合成类将具有不同的接口。 
 * @author  陈强
 * @since   1.0
 * @version 2012-5-25 陈强新建
 */
/**
 * 抽象构件角色由一个java接口实现，它给出两个对所有的子类均有用的方法：getComposite() sampleOperation()
 * 抽象构件角色Component的接口
 */
public interface Component {
    
    // 返还自己的实例
    Component getComposite();
    
    // 某个商业方法
    void sampleOperation();
}
