package com.caishen91.jupiter.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.caishen91.jupiter.model.Share;

public interface ArticleShareMapper {

	@Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into article_share_relation (articleId,createTime,updateTime) values (#{articleId},#{createTime},#{updateTime})")
	void add(Share share);

	@Select("select articleId from article_share_relation where id = #{id}")
	Integer getArIdById(@Param("id") int shareId);

	@SelectProvider(type = ArticleShareProvider.class,method = "queryShareCountByParamMap")
	int queryShareCountByParamMap(Map<String, Object> paramMap);

	@Delete("delete from article_share_relation where articleId = #{articleId}")
	void deleteShareByArId(@Param("articleId") int arId);

	@UpdateProvider(type = ArticleShareProvider.class,method = "updateBatchShareStatusById")
	int updateBatchShareStatusById(@Param("arIds") String arIds,@Param("blogId") int blogId, @Param("currentShare") int currentShare, 
								   @Param("expectShare") int expectShare, @Param("updateTime") String updateTime,
								   @Param("otherStatus") String otherStatus);

	@DeleteProvider(type = ArticleShareProvider.class,method = "deleteBatchShareByArId")
	void deleteBatchShareByArId(@Param("arIds") String arIds);

	@UpdateProvider(type = ArticleShareProvider.class,method = "updateShareStatusById")
	int updateShareStatusById(@Param("arIds") String arIds,@Param("blogId") int blogId, @Param("currentShare") int currentShare, 
								   @Param("expectShare") int expectShare, @Param("updateTime") String updateTime,
								   @Param("otherStatus") String otherStatus);
}
