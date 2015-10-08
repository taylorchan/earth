/**2012-5-25**/

package com.cq.model.command;

/**
 * 添加需求的命令
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class AddRequirementCommand extends Command {
    
    /**
     * @see com.cq.model.command.Command#execute()
     */
    @Override
	public void execute() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        super.requirementGroup.find();
        super.requirementGroup.change();
    }
    
}
