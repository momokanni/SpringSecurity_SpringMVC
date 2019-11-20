package com.caishen91.jupiter.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.caishen91.jupiter.model.BlogManager;

public interface BlogManagerDetailsMapper {

	@Select("select * from blog_manager where name = #{name}")
	BlogManager loadBlogManagerDetailsByName(@Param("name") String username);

	@Select("select * from blog_manager where mobile = #{mobile}")
	BlogManager loadBlogManagerDetailsByMobile(@Param("mobile") String username);

}
