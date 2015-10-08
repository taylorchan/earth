/**2012-3-19**/

/**2012-3-19**/

package com.cq.model.abstractfactory;

/**
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public class AmdFactory implements AbstractFactory{
    /* (non-Javadoc)
     * @see com.cq.model.abstractfactory.AbstractFactory#createCpu()
     */
    @Override
    public Cpu createCpu() {
        // TODO Auto-generated method stub
        return new AmdCpu();
    }

    /* (non-Javadoc)
     * @see com.cq.model.abstractfactory.AbstractFactory#createMainboard()
     */
    @Override
    public Mainboard createMainboard() {
        // TODO Auto-generated method stub
        return new Amdboard();
    }
    
}
