/**2012-5-26**/

package com.cq.model.state;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class RunState extends State {
    
    /**
     * @param context
     */
    RunState() {
        super();
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    /**
     * 电梯在运行的时候门肯定是关闭着的，此方法不用做任何事情
     * 
     * @see com.cq.model.state.State#close()
     */
    @Override
    void close() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        
    }
    
    /**
     * 运行的时候能开门么？
     * 
     * @see com.cq.model.state.State#open()
     */
    @Override
    void open() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        // do nothing
    }
    
    /**
     * @see com.cq.model.state.State#run()
     */
    @Override
    void run() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("the lift is running now!");
    }
    
    /**
     * @see com.cq.model.state.State#stop()
     */
    @Override
    void stop() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        // context.stop();
        context.setState(Context.stop);
        context.getState().stop();
    }
    
}
