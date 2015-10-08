/**2012-5-26**/

package com.cq.model.state;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class StopState extends State {
    
    /**
     * @param context
     */
    StopState() {
        super();
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    /**
     * 停止的时候电梯门本来就是关着的，所以不用关了。
     * 
     * @see com.cq.model.state.State#close()
     */
    @Override
    void close() {
        
    }
    
    /**
     * 可以执行开门的动作ss
     * 
     * @see com.cq.model.state.State#open()
     */
    @Override
    void open() {
        // context.open();
        context.setState(Context.open);
        context.getState().open();
    }
    
    /**
     * 停止的时候，可以再启动
     * 
     * @see com.cq.model.state.State#run()
     */
    @Override
    void run() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        // context.run();
        context.setState(Context.run);
        context.getState().run();
    }
    
    /**
     * @see com.cq.model.state.State#stop()
     */
    @Override
    void stop() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("the lift is stopping now!");
    }
    
}
