/**2012-5-25**/

package com.cq.model.command;

/**
 *请求方发送的命令,命令可能有多种,这里是抽象父类
 * 
 * @author 
 * @since 1.0
 * @version 2012-5-25 
 */
public abstract class Command implements ICommand{
    
    protected RequirementGroup requirementGroup = new RequirementGroup();
    
    protected PageGroup pg = new PageGroup();
    
    protected CodeGroup cg = new CodeGroup();
}
