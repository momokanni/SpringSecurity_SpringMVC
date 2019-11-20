package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.util.StringUtil;

import java.util.List;
import java.util.Map;

public class AccountProvider {

   public String getTotalSysUserCountByParams(Map params) {
	   
	   StringBuilder sb = new StringBuilder();
	   
	   sb.append("select count(1) from sys_user where 1 = 1 ");
	   
	   sb.append(getAccountsByParamsWhere(params));
	   
	   return sb.toString();
   }
   
   
   public String getSysUserByParams(Map params) {
	   
	   StringBuilder sb = new StringBuilder();
	   
	   sb.append("select * from sys_user where 1 = 1");
	   sb.append(getAccountsByParamsWhere(params));
	   
	   sb.append(" order by id desc limit #{offset}, #{pageSize}");
	   return sb.toString();
   }
   
   public String getAccountsByParamsWhere(Map params) {
	   
	   StringBuilder sb = new StringBuilder();
	   
	   String name = (String)params.get("name");
	   if (StringUtil.isNotEmpty(name)) {
		   sb.append(" and name like concat('%',#{name}, '%')");
	   }

	   String  mobile= (String)params.get("mobile");
	   if (StringUtil.isNotEmpty(mobile)) {
		   sb.append(" and mobile like concat('%',#{mobile}, '%')");
	   }
	   
	   List<Integer> statuses = (List)params.get("statuses");
	   if (statuses != null && statuses.size() > 0) {
		   sb.append(" and status in ");
		   sb.append(StringUtil.buildIntInSql(statuses));
	   }

	   
	   return sb.toString();
   }



	public String queryLableList(Map params) {

		StringBuilder sb = new StringBuilder();
		Integer blogId = (Integer) params.get("blogId");
		if (blogId!=0) {
			sb.append("select bl.`id` AS id ,bl.`name` AS name, bl.`description` AS description ,bl.status AS status from blog_label bl where blogId = #{blogId}");
		}
		sb.append(getLableListParamsWhere(params));
		sb.append(" order by id desc");
		return sb.toString();
	}

	public String getLableListParamsWhere(Map params) {

		StringBuilder sb = new StringBuilder();

		String name = (String)params.get("name");
		if (StringUtil.isNotEmpty(name)) {
			sb.append(" and name like concat('%',#{name}, '%')");
		}

		List<Integer> statuses = (List)params.get("statuses");
		if (statuses != null && statuses.size() > 0) {
			sb.append(" and status in ");
			sb.append(StringUtil.buildIntInSql(statuses));
		}


		return sb.toString();
	}


}
