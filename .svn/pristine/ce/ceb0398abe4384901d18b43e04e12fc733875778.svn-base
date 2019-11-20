package com.caishen91.jupiter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.caishen91.jupiter.dto.BlogDTO;
import com.caishen91.jupiter.vo.BlogDetailVO;
import com.caishen91.jupiter.vo.BlogInfoVO;

public interface SysBlogMapper {

	@SelectProvider(type = SysBlogProvider.class,method = "queryBlogCount")
	int queryBlogCount(Map<String, Object> paramMap);

	@SelectProvider(type = SysBlogProvider.class,method = "queryBlogList")
	List<BlogInfoVO> queryBlogList(Map<String, Object> paramMap);

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into blog  (type,enterpriseName,enterpriseType,status,authStatus,fansCount,createTime,updateTime) values (#{blogType},#{enterpriseName},#{enterpriseType},#{blogStatus},#{authStatus},#{fansCount},#{createTime},#{updateTime})")
	void createBlog(BlogDTO blogDTO);

	@Update("update blog set status=#{blogStatus} where id = #{id}")
	int updateStatus(@Param("id")int blogId, @Param("blogStatus")int status);

	@Update("update blog set authStatus=#{authStatus} where id = #{id}")
	int updateBlogAuthStatus(@Param("id") int blogId, @Param("authStatus") int authCode);

	@Select("SELECT b.id,b.`name` AS blogName, b.type AS 'type',b.`headImg` AS headImg,b.`description` AS 'desc',b.`authStatus` AS authStatus,b.`enterpriseName` AS enterpriseName,b.`enterpriseType` AS enterpriseType,b.`email` AS email,b.`scc` AS scc,bm.`name` AS blogManagerName,bm.nickName AS nickName,bm.`mobile` AS mobile FROM blog b LEFT JOIN blog_manager bm ON bm.`blogId` = b.`id` WHERE bm.`isManager` = 1 AND b.id = #{id}")
	BlogDetailVO queryBlogDetail(@Param("id")int id);

	@Select("SELECT COUNT(id) FROM blog_manager WHERE nickName = #{nickName}")
	int getCountByNickName(@Param(value = "nickName") String nickName);

	@Select("SELECT COUNT(id) FROM blog_manager WHERE mobile = #{mobile}")
	int getCountByMobile(@Param("mobile") String mobile);

	@SelectProvider(type = SysBlogProvider.class,method = "queryBlogList")
	List<BlogInfoVO> querySignBlogList(Map<String, Object> paramMap);

}
