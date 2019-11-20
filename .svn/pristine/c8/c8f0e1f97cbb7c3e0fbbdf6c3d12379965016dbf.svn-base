package com.caishen91.jupiter.dao;


import com.caishen91.jupiter.model.SysUserPermit;
import com.caishen91.jupiter.util.StringUtil;

import java.util.List;
import java.util.Map;

public class SysMapperProvider {


	public String getRevelUserIdByBaseInfoId(Map params) {

		StringBuilder sb = new StringBuilder();

		sb.append("select allocatee from apply_allocate_info where baseInfoId = #{baseInfoId} union ");

		sb.append("select auditUserId from apply_audit_info where baseInfoId = #{baseInfoId} union ");

		sb.append("select checkUser from apply_business_check_info where baseInfoId = #{baseInfoId} and checkUser <> 0 ");


		return sb.toString();

	}

	public String getUsersByIds(Map params) {
		StringBuilder sb = new StringBuilder();

		sb.append("select * from sys_user where id in ");

		List<Integer> userIds = (List)params.get("userIds");

		sb.append(StringUtil.buildIntInSql(userIds));

		return sb.toString();
	}

	public String getUsersByDeptIds(Map params) {

		StringBuilder sb = new StringBuilder();

		sb.append("select * from sys_user where deptId in ");

		List<Integer> deptIds = (List)params.get("deptIds");

		sb.append(StringUtil.buildIntInSql(deptIds));

		return sb.toString();
	}


	public String getDeptUsersByParamWhere(Map<String, Object> params) {

		StringBuilder sb = new StringBuilder();

		String name = (String)params.get("name");
		if (StringUtil.isNotEmpty(name)) {
			sb.append(" and name like concat('%', #{name}, '%') ");
		}

		String loginName = (String)params.get("loginName");
		if (StringUtil.isNotEmpty(loginName)) {
			sb.append(" and loginName like concat('%', #{loginName}, '%') ");
		}

		List<Integer> statuses = (List)params.get("statuses");
		if (statuses != null && statuses.size() > 0) {
			sb.append(" and status in ");
			sb.append(StringUtil.buildIntInSql(statuses));
		}

		Integer companyId = (Integer)params.get("companyId");
		if (companyId != null) {
			sb.append(" and companyId = #{companyId} ");
		}

		Integer deptId = (Integer)params.get("deptId");
		if (deptId != null && deptId != 0) {
			sb.append(" and deptId = #{deptId} ");
		}

		return sb.toString();
	}

	public String getTotalDeptUsersByParam(Map<String,Object> params){
		StringBuilder sb = new StringBuilder();

		sb.append("select count(1) from sys_user where 1 = 1 ");
		sb.append(getDeptUsersByParamWhere(params));

		return sb.toString();
	}


	public String getDeptUsersByParam(Map params) {
		StringBuilder sb = new StringBuilder();

		sb.append("select * from sys_user where 1 = 1 ");
		sb.append(getDeptUsersByParamWhere(params));

		sb.append(" order by id desc limit #{offset}, #{pageSize}");

		return sb.toString();
	}

	public String getSysPermitByTags(Map<String, Object> params) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select * from sys_permit where tag in ");
		
		List<String> tags = (List)params.get("tags");
		
		sb.append(StringUtil.buildStrInSql(tags));
		
		return sb.toString();
	}
	public String getUserWithPermits(Map<String, Object> params) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select * from sys_user a, sysUserPermit b where a.id = b.userId and b.refId in");
		
		List<Integer> permitIds = (List)params.get("permitIds");
		
		sb.append(StringUtil.buildIntInSql(permitIds));
		
		sb.append(" and b.permit = 1");
		
		return sb.toString();
	}


 	public void appendSysUserByParamWhere(StringBuffer sb, Map<String, Object> params){		 
		 
		if(StringUtil.isNotEmpty((String)params.get("statuses"))){
			sb.append(" and status  in ("+params.get("statuses")).append(")");
		}
		 
		String loginName= (String)params.get("loginName");
		if(loginName!=null){
			sb.append(" and loginName  like '%"+loginName+"%' ") ;
		}
		String username=(String)params.get("username");
		if(username!=null){
			sb.append(" and username  like '%"+username+"%' ");
		}
	 }

 	
 	/**添加用户菜单权限 	 * 
 	 * @param params
 	 * @return
 	 */
 	public String addSysUserPermitList(Map<String,Object> params){
 		StringBuffer sb = new StringBuffer();
 		List<SysUserPermit> permits=(List<SysUserPermit>)params.get("sysUserPermits");
 		sb.append(" insert into sysUserPermit ( roleId,userId,refId,permit ) values ");
 		boolean frist=true;
 		for(SysUserPermit p:permits){
 			if(!frist){
 				sb.append(",");
 			}
 			frist=false;
 			sb.append(" ( ").append(p.getRoleId()).append(",");
 			sb.append(p.getUserId()).append(",");
 			sb.append(p.getRefId()).append(",");
 			sb.append(p.isPermit()).append(" )");
 		}
 		return sb.toString();
 	}
 	
 	public String getSuggestCommentList(Map<String,Object> params){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from suggest_comment_record where 1=1 ");
		appendSuggestCommonByParamWhere(sb, params);
		sb.append(" order by status asc, createTime desc limit ").append(params.get("offset")).append(" , ");
		sb.append(params.get("pagesize"));
		return sb.toString();
	}
 	
	public String getSuggestCommentListCount(Map<String,Object> params){
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from suggest_comment_record where 1=1 ");
		appendSuggestCommonByParamWhere(sb, params);
		return sb.toString();
	}
 	
 	public void appendSuggestCommonByParamWhere(StringBuffer sb, Map<String, Object> params){		 
		Integer status = (Integer) params.get("status");
		if(status == null){
			status = 2;
		}
		if(status != 2){
			sb.append(" and status  = "+status).append(" "); 
		}
	 }
 	
 	public String getSuggestContentList(Map<String,Object> params){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from suggest_like_content ");
		sb.append(" ORDER BY countTotal DESC limit ").append(params.get("offset")).append(" , ");
		sb.append(params.get("pagesize"));
		return sb.toString();
	}
 	
	public String getSuggestContentListCount(Map<String,Object> params){
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from suggest_like_content  ");
		return sb.toString();
	}
	
	public String getHolidayManageList(Map<String,Object> params){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from holiday_record where 1=1 and status=0 ");
		appendHolidayManageByParamWhere(sb, params);
		sb.append(" order by  createTime asc limit ").append(params.get("offset")).append(" , ");
		sb.append(params.get("pagesize"));
		return sb.toString();
	}
 	
	public String getHolidayManageListCount(Map<String,Object> params){
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from holiday_record where 1=1 and status=0 ");
		appendHolidayManageByParamWhere(sb, params);
		return sb.toString();
	}
	public void appendHolidayManageByParamWhere(StringBuffer sb, Map<String, Object> params){		 
		Integer yearId = Integer.parseInt(params.get("yearId")+"");
		if(yearId != null && yearId > 0){
			sb.append(" and yearId  = "+yearId).append(" "); 
		}
		
	 }
	
}
