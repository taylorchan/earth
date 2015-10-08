/**2012-5-26**/

/**2012-5-26**/

package com.cq.model.prototype;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Mail implements Cloneable {
    
    private String destiny;
    
    
    private String title;
    
    private String content;
    
    private String tail;
    
    
    Mail(AdvTemplate adv) {
        this.content = adv.getContent();
        this.title = adv.getTitle();
    }
    
    /**
     * 覆盖object中的clone方法，执行在内存中以二进制流的形式拷贝对象
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Mail clone() {
        Mail m = null;
        try {
            m = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        return m;
    }
    
    /**
     * @return 获取 destiny属性值
     */
    public String getDestiny() {
        return destiny;
    }
    
    /**
     * @param destiny 设置 destiny 属性值为参数值 destiny
     */
    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }
    
    /**
     * @return 获取 title属性值
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title 设置 title 属性值为参数值 title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @return 获取 content属性值
     */
    public String getContent() {
        return content;
    }
    
    /**
     * @param content 设置 content 属性值为参数值 content
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * @return 获取 tail属性值
     */
    public String getTail() {
        return tail;
    }
    
    /**
     * @param tail 设置 tail 属性值为参数值 tail
     */
    public void setTail(String tail) {
        this.tail = tail;
    }

}
