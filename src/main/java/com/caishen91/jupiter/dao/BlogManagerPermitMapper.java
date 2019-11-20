package com.caishen91.jupiter.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.caishen91.jupiter.model.BlogManagerPermit;

public interface BlogManagerPermitMapper {

	/**
	 * 	创建商户号管理员时批量插入管理员权限关联数据
	 * @param bmpList
	 */
	@Options(useGeneratedKeys = true)
	@InsertProvider(method = "insertBatch",type = BlogManagerPermitProvider.class )
	void insertBatch(@Param("list") List<BlogManagerPermit> bmpList);
	/**
	 * 	根据商户ID和商户管理员ID查询已拥有权限ID集合
	 * @param blogId
	 * @param adminId
	 * @return
	 */
	@Select("select bpId from blog_manager_permit where blogId = #{blogId} and bmId = #{bmId}")
	Set<String> getBlogPermission(@Param("blogId")int blogId, @Param("bmId") int adminId);
	
	@Delete("delete from blog_manager_permit where blogId = #{blogId} and bmId = #{bmId}")
	void revocationBlogManagerAuthAll(@Param("blogId") int blogId, @Param("bmId") int bmId);
	
	@Options(useGeneratedKeys = true)
	@InsertProvider(method = "insertBatch",type = BlogManagerPermitProvider.class )
	void updateBlogManagerPermit(@Param("list") List<BlogManagerPermit> rpList);
	
	@Select("select bpId from blog_manager_permit where bmId = #{bmId} and blogId = #{blogId} ")
	Set<String> getSuperManagerAuthPermission(@Param("bmId") int managerId, @Param("blogId") int blogId);
	
	@Select("SELECT CONCAT('ROLE_',bp.authorize) FROM blog_permit bp LEFT JOIN blog_manager_permit bmp ON bmp.bpId = bp.id WHERE bmp.bmId = #{bmId} and bmp.blogId = #{blogId}")
	Set<String> getBmPermission(@Param("bmId") int mId, @Param("blogId") int bId);
	
}
