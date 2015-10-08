/**2012-5-17**/

package com.cq.model.facade;

/**
 * 客户程序，客户程序不直接与子系统交互，转而通过门面执行相关操作，对采用哪个子系统，或则子系统的具体运作过程一无所知 本例模仿门面模式的保安系统
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-17 陈强新建
 */
public class Client {
    
    private static SecurityFacade sf;
    
    public static void main() {
        sf.active();
    }
}
