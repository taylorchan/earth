/**2012-5-25**/

package com.cq.model.command;

/**
 * 模拟客户端调用命令
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Client {
    
    public static void main(String args[]) {
        // 接口人，负责接收和执行命令
        Invoker zhangsan = new Invoker();
        
        // 一个新的删除页面命令
        Command command = new DeletePageCommand();
        zhangsan.setCommand(command);
        zhangsan.action();
        
    }
}
