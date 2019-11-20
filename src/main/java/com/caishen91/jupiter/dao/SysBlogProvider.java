package com.caishen91.jupiter.dao;

import java.util.Map;

import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.StringUtil;

public class SysBlogProvider {
	
	/**
	 * 	根据查询条件，获取数据总数
	 * @param params
	 * @return
	 */
	public String queryBlogCount(Map<String,Object> params) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT count(bl.id) FROM blog bl ");
        sb.append(" LEFT JOIN blog_manager bm ON bm.`blogId` = bl.`id`");
        sb.append(" WHERE bm.`isManager` = 1 ");
        sb.append(appendWhereByParam(params));
        sb.append(" order by bl.createTime DESC ");
		return sb.toString();
	}
	/**
	 * 	查询公众号列表
	 * @param params
	 * @return
	 */
	public String queryBlogList(Map<String,Object> params) {
		StringBuffer sb = new StringBuffer();
        sb.append("SELECT bl.`id` AS blogId, bl.`name` AS blogName, bm.`name` AS blogManagerName, bm.`mobile` AS mobile, ");
        sb.append(" bl.`type` AS blogType, bl.`authStatus` AS authStatus, bl.`fansCount` AS fansCount, b.accountCount AS subAccount, bl.`status` AS blogStatus FROM blog bl");
        sb.append(" INNER JOIN (SELECT COUNT(id) AS accountCount,blogId FROM blog_manager GROUP BY blogId) b ON b.blogId = bl.id ");
        sb.append(" LEFT JOIN blog_manager bm ON bm.`blogId` = bl.`id`");
        sb.append(" WHERE bm.`isManager` = 1");
        sb.append(appendWhereByParam(params));
        sb.append(" order by bl.createTime DESC ");
        return CommonUtil.queryListAndLimit(params, sb);
	}
	
	private String appendWhereByParam(Map<String,Object> params){
        StringBuffer sb = new StringBuffer();

        String blogName = (String)params.get("blogName");
        if (StringUtil.isNotEmpty(blogName)) {
            sb.append(" and bl.name like concat('%', #{blogName}, '%') ");
        }

        String managerName = (String)params.get("managerName");
        if (StringUtil.isNotEmpty(managerName)) {
            sb.append(" and bm.name like concat('%', #{managerName}, '%') ");
        }
        
        String authStatus = (String)params.get("authStatus");
        if (StringUtil.isNotEmpty(authStatus)) {
            sb.append(" and bl.authStatus = #{authStatus} ");
        }

        String mobile = (String)params.get("mobile");
        if (StringUtil.isNotEmpty(mobile)) {
            sb.append(" and bm.mobile like concat('%', #{mobile}, '%') ");
        }
        
        String blogType = (String) params.get("blogType");
        if (StringUtil.isNotEmpty(blogType)) {
            sb.append(" and bl.type like concat('%', #{blogType}, '%') ");
        }
        
        String blogStatus = (String)params.get("blogStatus");
        if (StringUtil.isNotEmpty(blogStatus)) {
            sb.append(" and bl.status like concat('%', #{blogStatus}, '%') ");
        }

        return sb.toString();
    }
}
