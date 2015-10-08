/**2012-5-25**/

package com.cq.model.adaper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class OuterUser implements IOuterUser {
    
    /**
     * @see com.cq.model.adaper.IOuterUser#getSelfUserInfo()
     */
    @Override
    public Map<String, String> getSelfUserInfo() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        Map<String, String> map = new HashMap<String, String>(3);
        map.put("name", "wang");
        map.put("no", "1");
        return map;
        
    }
}
