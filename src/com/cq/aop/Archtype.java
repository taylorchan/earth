/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.aop;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-10-7
 * @version : 1.0
 */
public class Archtype implements IArchtype{
    
    public Archtype() {
        super();
    }
    
    @Override
    public String log(String content){
        System.out.println("在方法中,执行记录内容#" + content );
        return content;
    }
}
