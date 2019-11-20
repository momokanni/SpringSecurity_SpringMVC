package com.caishen91.jupiter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.caishen91.jupiter.model.AuthTree;
import com.caishen91.jupiter.model.Blog;

public interface BlogMapper {
	
	/**
	 * 	查询公司类型商户号默认权限
	 * @return
	 */
	@Select("select id from blog_permit where companyType = 0")
	List<Integer> getCompanyDefaultPermit();
	/**
	 * 	查询个人类型商户号的默认权限
	 * @return
	 */
	@Select("select id from blog_permit where personalType = 0")
	List<Integer> getPersonalDefaultPermit();
	
	@Select("select id,name AS 'title',parentId,level from blog_permit")
	List<AuthTree> getAllPermission();
	
	@Select("select * from blog where id = #{id}")
	Blog getBlogById(@Param("id") int id);
	

	
}
