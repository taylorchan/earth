/**2012-5-26**/

package com.cq.model.state;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class CloseState extends State {
    
    /**
     * @param context
     */
    CloseState() {
        super();
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    /**
     * @see com.cq.model.state.State#close()
     */
    @Override
    void close() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("电梯关闭！");
    }
    
    /**
     * @see com.cq.model.state.State#open()
     */
    @Override
    void open() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        context.setState(Context.open);// 打开门，门的状态为打开
        context.getState().open();// 打印门是打开的消息
        
    }
    
    /**
     * @see com.cq.model.state.State#run()
     */
    @Override
    void run() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        context.setState(Context.run);
        context.getState().run();// 打印电梯运行的信息的消息
    }
    
    /**
     * @see com.cq.model.state.State#stop()
     */
    @Override
    void stop() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        // context.stop();
        context.setState(Context.stop);
        context.getState().stop();// 打印电梯运行的信息的消息
    }
    
}
