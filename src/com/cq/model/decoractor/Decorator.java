/**2012-3-19**/

package com.cq.model.decoractor;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public class Decorator implements Component {
	
	//当然也可以添加属性
    

    // 此处的component为原始的功能类，这里需要依赖它，基于组合的实现
    // 装饰者模式基于组合来实现
    protected Component component;
  
	public Decorator(Component component) {
        this.component = component;
    }
    
    @Override
    public void operation() {
        component.operation();
        System.out.println("add new operation");
    }
    
    
    public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

}
