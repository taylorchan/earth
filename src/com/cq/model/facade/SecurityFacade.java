/**2012-5-17**/

package com.cq.model.facade;

/**
 * 用户只用启动安保启动，即可启动监视器，灯，报警器等，及通过一个简单的接口及可完成一系列复杂的事情。不用关注具体是怎么做的。
 * 可以同时有一个或多个子系统，每个子系统是一类功能集合。每一个子系统都可以被客户端直接调用， 或者被门面角色调用，子系统不知道门面系统的存在。 使用场景：
 * 1.为一个复杂的子系统提供一个简单的接口 2.引入门面可以将一个子系统与他的客户端以及其他子系统分离开来。提高子系统的独立性和可移植性。
 * 3.简化了层与层之间的依赖关系
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-17 陈强新建
 */
public class SecurityFacade {
    
    private final Camara camara1, camara2;
    
    private final Light light;
    
    private final Alarm alarm;
    
    public SecurityFacade(Camara camara1, Camara camara2, Light light, Alarm alarm) {
        this.camara1 = camara1;
        this.camara2 = camara2;
        this.light = light;
        this.alarm = alarm;
    }
    
    public void active() {
        camara1.turnOn();
        camara2.turnOn();
        light.turnOn();
        alarm.turnOn();
    }
    
    public void deactive() {
        camara1.turnOff();
        camara2.turnOn();
        light.turnOff();
        alarm.turnOff();
    }
}
