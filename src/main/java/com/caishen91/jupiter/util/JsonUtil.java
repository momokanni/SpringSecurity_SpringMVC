package com.caishen91.jupiter.util;

import java.util.Collection;
import java.util.List;

import com.caishen91.jupiter.model.BaseAuthTree;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/**
 * 	json工具类
 * @author Administrator
 *
 */
public class JsonUtil {

	public static JSONArray extractNotNullAttr(Collection<? extends BaseAuthTree> tree) {
		JsonConfig jsonConfig = new JsonConfig();
        PropertyFilter filter = new PropertyFilter() {
                public boolean apply(Object object, String fieldName, Object fieldValue) {
                if(fieldValue instanceof List){
                    List<Object> list = (List<Object>) fieldValue;
                    if (list.size()==0) {
                        return true;
                    }
                }
                return null == fieldValue || "".equals(fieldValue);
                }
        };
        jsonConfig.setJsonPropertyFilter(filter);

        JSONArray jsonArray = JSONArray.fromObject(tree,jsonConfig);
        return jsonArray;
	}
}
