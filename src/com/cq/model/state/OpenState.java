/**2012-5-26**/

package com.cq.model.state;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class OpenState extends State {
    
    /**
     * @param context
     */
    OpenState() {
        super();
        // TODO 自动生成构造函数存根注释，构造函数实现时请删除此注释
    }
    
    /**
     * @see com.cq.model.state.State#close()
     */
    @Override
    void close() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        context.setState(Context.close);
        context.getState().close();
        
    }
    
    /**
     * @see com.cq.model.state.State#open()
     */
    @Override
    void open() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("the lift is opening now!");
    }
    
    /**
     * no,this state can't run,do nothing
     * 
     * @see com.cq.model.state.State#run()
     */
    @Override
    void run() {
        
    }
    
    /**
     *打开状态下电梯已经是停止的了，不用做任何事情
     * 
     * @see com.cq.model.state.State#stop()
     */
    @Override
    void stop() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        
    }
    
}
