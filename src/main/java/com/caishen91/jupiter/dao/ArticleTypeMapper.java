package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.vo.ArticleTypeVO;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ArticleTypeMapper {

    @SelectProvider(type = ArticleTypeProvider.class,method = "getTotalAticleTypeCountByParams")
    int getTotalAticleTypeCountByParams(Map queryMap);

    @SelectProvider(type = ArticleTypeProvider.class,method = "getAticleTypeByParams")
    List<ArticleType> getAticleTypeByParams(Map queryMap);

    @Select("select * from article_type where id=#{id}")
    ArticleType getArticleTypetById(int id);

    @Update("update article_type set status = #{status} where id = #{id}")
    boolean setArticleTypeStatus(ArticleType articleType);

    @Insert("insert into article_type "
            + "					("
            + "					name,createTime,status,seq"
            + "					)" +
            " 			values"
            + "					("
            + "					#{name},#{createTime},#{status},#{seq}"
            + "					)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addArticleType(ArticleType articleType);

    @Update("update article_type set name = #{name}, "
            + "						 updateTime = #{updateTime},"
            + "						 seq = #{seq}"
            + "				   where id = #{id}")
    boolean updateArticleType(ArticleType articleType);

    @Select("select * from article_type ")
    List<ArticleType> getArticleTypets();

    @Select("select * from article_type where status = #{status}")
	List<ArticleType> getListByStatus(@Param("status") int status);

    @Select("select id AS arTypeId, name AS name,seq AS seq from article_type where status = #{status} ORDER BY seq ASC")
	List<ArticleTypeVO> getAllTypeByStatus(@Param("status") int status);

}
