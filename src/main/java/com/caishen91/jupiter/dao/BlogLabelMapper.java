package com.caishen91.jupiter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.caishen91.jupiter.model.BlogLabel;

public interface BlogLabelMapper {

	@Select("select count(*) from blog_label where blogId = #{blogId}")
	int queryLabelCountByBlogId(@Param("blogId") int blogId);

	@Select("select * from blog_label where blogId = #{blogId} and status = ${status}")
	List<BlogLabel> queryLabelListByBlogId(@Param("blogId") int blogId, @Param("status") int status);

	@Update("update blog_label set status = #{status} where id = #{id}")
	int updateBLStatus(@Param("id") int blId, @Param("status") int status);

	@Select("select * from blog_label where id = #{id}")
	BlogLabel getLabelById(@Param("id") int label);

	@Select("select * from blog_label where blogId = #{id}")
    List<BlogLabel> getLabelByBlogId(@Param("id") int id);

	@Select("select count(1) from blog_label where status = #{status} and blogId = #{id}")
	int getLabelByStatus(@Param("id") int id,@Param("status") int status);

	@Insert("insert into blog_label "
			+ "					("
			+ "					name,description,status,blogId,createTime"
			+ "					)" +
			" 			values"
			+ "					("
			+ "					#{name},#{description},#{status},#{blogId},#{createTime}"
			+ "					)")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	boolean addLable(BlogLabel blogLabel);

	@Update("update  blog_label set status = #{status},"
			+ "						 updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	void setBlogLabelStatus(BlogLabel blogLabel);

	@Update("update  blog_label set name = #{name},"
			+ "						 description = #{description},"
			+ "						 updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	boolean updateLable(BlogLabel blogLabel);

	@Select("select * from blog_label where blogId = #{id} and status = #{status}")
	List<BlogLabel> getLabelsByBlogIdByStatus(@Param("id") int id, @Param("status") int status);

	@Select("select * from blog_label where blogId = #{blogId} order by createTime desc limit #{offset}, #{pageCount}")
	List<BlogLabel> getLabelListByBlogId(Map<String, Object> paramMap);


	@SelectProvider(type = AccountProvider.class,method = "queryLableList")
	List<BlogLabel> queryLableList(Map<String, Object> paramMap);

	@Select("select * from blog_label where name = #{name} and blogId = #{blogId}")
    BlogLabel getLabelByName(@Param("name") String name, @Param("blogId") int blogId);
}
