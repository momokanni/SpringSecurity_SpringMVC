package com.caishen91.jupiter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.caishen91.jupiter.model.AuthTree;
import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.model.BlogPermit;
import com.caishen91.jupiter.model.SubBmAuthTree;

public interface BlogPermitMapper {
	
	/**
	 * 	查询公司类型商户号默认权限
	 * @return
	 */
	@Select("select id,authorize from blog_permit where companyType = 0")
	List<Map<String, Object>> getCompanyDefaultPermit();
	/**
	 * 	查询个人类型商户号的默认权限
	 * @return
	 */
	@Select("select id,authorize from blog_permit where personalType = 0")
	List<Map<String, Object>> getPersonalDefaultPermit();
	
	@Select("select id,name AS 'title',parentId,level from blog_permit")
	List<AuthTree> getAllPermission();
	
	@SelectProvider(method = "getPermitById",type = BlogPermitProvider.class)
	List<BlogPermit> getPermitById(@Param("authStr") String authStr);
	
	@Select("select authorize from blog_permit where url = #{url}")
	BlogPermit getBlogPermitByUrl(@Param("url") String url);
	
	@SelectProvider(method = "getMenuTreeByIds",type = BlogPermitProvider.class)
	List<BlogMenuTree> getMenuTreeByIds(@Param("authStr") String authorizeStr);
	
	@SelectProvider(method = "getBmAuthByIds",type = BlogPermitProvider.class)
	List<SubBmAuthTree> getBmAuthByIds(@Param("authStr") String authorizeStr);
	

	
}
