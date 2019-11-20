package com.caishen91.jupiter.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleCollection;
import com.caishen91.jupiter.model.ArticleKeyWords;
import com.caishen91.jupiter.model.ArticleLaud;
import com.caishen91.jupiter.model.ArticleRead;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.vo.ARDetailVO;
import com.caishen91.jupiter.vo.ArticleVO;
import com.caishen91.jupiter.vo.MobileARListVO;
import com.caishen91.jupiter.vo.ReadArticleVO;

public interface ArticleMapper {

    @SelectProvider(type = ArticleProvider.class, method = "getTotalArticleCountByParams")
    int getTotalArticleCountByParams(Map queryMap);

    @SelectProvider(type = ArticleProvider.class, method = "getArticleByParams")
    List<Article> getArticleByParams(Map queryMap);

    @Select("select * from blog where id = #{blogId}")
    Blog getBlogNameById(@Param("blogId") int blogId);

    @Select("select * from article_img where id = #{id}")
    Article getArticleById(@Param("id") int id);

    @Update("update article_img set status = #{status} where id = #{id}")
    void setArticleStatus(Article article);

    @Select("select * from blog where name like concat('%',#{blogName}, '%')")
    Blog getBlogIdByName(String blogName);

    @Select("select count(*) from article_img where blogId = #{blogId}")
	int queryArticleCountByBlogId(@Param("blogId") int blogId);

    @SelectProvider(type = ArticleProvider.class,method = "queryListByBlogId")
	List<ArticleVO> queryListByBlogId(Map<String, Object> param);

    @Update("update article_img set status = #{status} where id = #{id}")
	int updateARStatus(@Param("id") int blId, @Param("status") int status);

    @Select("select * from blog_label where id= #{labelId} ")
    BlogLabel getBlogLabelById(@Param("labelId") int labelId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into article_img (number,title,content,category,typeId,labelId,thumb,readCount,collecCount,forwardCount,ontop,blogId,blogManagerId,status,releaseTime,createTime,updateTime,audioName,audioPath,imgCount,shareContent,wordCount,source,sourceId,otherStatus) values (#{number},#{title},#{content},#{category},#{typeId},#{labelId},#{thumb},#{readCount},#{collecCount},#{forwardCount},#{ontop},#{blogId},#{blogManagerId},#{status},#{releaseTime},#{createTime},#{updateTime},#{audioName},#{audioPath},#{imgCount},#{shareContent},#{wordCount},#{source},#{sourceId},#{otherStatus})")
	int save(Article ar);

    @Select("select count(*) from article_img where title = #{title} and status != 5 and id != #{arId} and blogId = #{blogId}")
	int getARCountByTitle(@Param("title") String title, @Param("arId") int arId, @Param("blogId") int blogId);
    
	@SelectProvider(type = ArticleProvider.class,method = "queryForCustomerByBlogId")
	List<ArticleVO> queryForCustomerByBlogId(Map<String, Object> paramMap);

	@SelectProvider(type = ArticleProvider.class,method = "queryArticleCountByParamMap")
	int queryArticleCountByParamMap(Map<String, Object> paramMap);

	@SelectProvider(type = ArticleProvider.class,method = "getCountGroupByTimeAndTitle")
	List<Map<String, Object>> getCountGroupByTimeAndTitle(Map<String, Object> paramMap);

	@Update("update article_img set ontop = #{change},updateTime = #{updateTime} where id = #{id} and ontop = #{current}")
	int updateIsTopStatus(@Param("id") int arId, @Param("current") int current, @Param("change") int change, @Param("updateTime")String updateTime);

    @Select("select * from article_img  where status=2 order by releaseTime desc  ")
    List<Article> getArticleInfo();

    @Select("select * from article_img where DATE_SUB(#{date},INTERVAL 7 DAY)<=DATE(releaseTime) and typeId =#{typeId} and status=2 and id not in (#{id}) order by RAND() limit 5 ")
    List<Article> getRmdArticleInfo(@Param("date") Date date,@Param("typeId") int typeId,@Param("id") int id);

    @Update("update article_img set ontop = #{change} where blogId = #{blogId} AND ontop = #{current}")
	void updateIsTopStatusByBlogId(@Param("blogId") int blogId, @Param("current") int current, @Param("change") int change);

    @Update("update article_img set status = #{status}, releaseTime = #{updateTime}, ontop = #{top}, updateTime = #{updateTime} where id = #{id}")
	int updateARStatusById(@Param("id") int arId, @Param("status") int change, @Param("top") int topStatus, @Param("updateTime")String updateTime);

    @Select("select * from article_img where blogId =#{blogId} and status=#{status} order by releaseTime desc")
    List<Article> getArticleByBlogId(@Param("blogId") int blogId ,@Param("status") int status);

    @UpdateProvider(type = ArticleProvider.class,method = "delARById")
	int delARById(@Param("id") int arId, @Param("delStatus") int[] delStatus, @Param("change") int change, @Param("updateTime")String updateTime);

    @Select("SELECT id AS id, title AS title, content AS content, typeId AS 'type', labelId AS label, thumb AS url,date_format(releaseTime,'%Y-%m-%d %k:%i:%S') AS 'time',audioName AS 'audioName',audioPath AS 'audioPath',imgCount AS 'imgCount',shareContent AS 'shareContent',wordCount AS 'wordCount', sourceId AS 'articleSourceId',otherStatus FROM article_img WHERE id = #{id} AND blogId = #{blogId}")
	ARDetailVO getARDetailByIdAndBlogId(@Param("id") int arId, @Param("blogId") int blogId);

    @UpdateProvider(type = ArticleProvider.class,method = "updateArticle")
	int updateArticle(@Param("article") Article ar);

    @Select("select * from article_collection where userId=#{wapUserId} and status=1 order by createTime desc")
    List<ArticleCollection> getArticleCollectionByWapUserId(@Param("wapUserId") int wapUserId);

    @Select("SELECT ari.`id` AS id,ari.`title` AS title, ari.releaseTime AS 'releaseTime', ari.readCount AS readVolume, ari.collecCount AS collectVolume,"
    		+ "ari.forwardCount AS forwardVolume, ari.ontop AS isTop, ari.`status` AS 'status', ari.thumb AS 'headImg', ari.share AS 'share' "
    		+ " FROM article_img ari"
    		+ " WHERE ari.blogId = #{blogId} AND ari.ontop = #{isTop}")
	ArticleVO queryTopAR(@Param("blogId") int blogId, @Param("isTop") int isTop);
    
	@SelectProvider(type = ArticleProvider.class, method = "getARListByType")
	List<MobileARListVO> getARListByType(Map<String, Object> paramMap);

	@SelectProvider(type = ArticleProvider.class, method = "getPullDownARList")
	List<MobileARListVO> getPullDownARList(Map<String, Object> paramMap);

	@SelectProvider(type = ArticleProvider.class, method = "getPullUpARList")
	List<MobileARListVO> getPullUpARList(Map<String, Object> paramMap);

    @Insert("insert into article_read "
            + "					("
            + "					articleId,userId,createTime"
            + "					)" +
            " 			values"
            + "					("
            + "					#{articleId},#{userId},#{createTime}"
            + "					)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addArticleRead(ArticleRead articleRead);

    @Update("update article_img set readCount = #{readCount},"
            + "				    updateTime = #{updateTime}"
            + "				   where id = #{id}")
    void updateArticleReadCount(Article article);

    @Select("select * from article_laud where articleId=#{id} and userId=#{wapUserId} and status=1")
    ArticleLaud getArticleByUserId(@Param("id")int id, @Param("wapUserId")int wapUserId);

    @Insert("insert into article_laud "
            + "					("
            + "					articleId,userId,createTime,status"
            + "					)" +
            " 			values"
            + "					("
            + "					#{articleId},#{userId},#{createTime},#{status}"
            + "					)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addArticleLaud(ArticleLaud iarticleLaud);

    @Update("update article_img set laudCount = #{laudCount},"
            + "				    updateTime = #{updateTime}"
            + "				   where id = #{id}")
    void updateArticleLuadCount(Article article);

    @Select("select * from article_collection where articleId=#{id} and userId=#{wapUserId} and status=1")
    ArticleCollection getArticleCollection(@Param("id")int id, @Param("wapUserId")int wapUserId);

    @Update("update article_img set collecCount = #{collecCount},"
            + "				    updateTime = #{updateTime}"
            + "				   where id = #{id}")
    void updateArticleCollectionCount(Article article);

    @Insert("insert into article_collection "
            + "					("
            + "					articleId,userId,createTime,status"
            + "					)" +
            " 			values"
            + "					("
            + "					#{articleId},#{userId},#{createTime},#{status}"
            + "					)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addArticleCollection(ArticleCollection iarticleCollection);

    @Select("SELECT count(1) from article_img   WHERE blogId = #{blogId} AND status = #{status} and  DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(releaseTime) order by releaseTime desc")
    int queryArticleLaundCountByParamMap(Map<String, Object> paramMap);

    @Select("SELECT ari.`id` AS id,ari.`title` AS title, ari.releaseTime AS 'releaseTime', ari.readCount AS readVolume, ari.collecCount AS collectVolume,"
            + "ari.forwardCount AS forwardVolume,ari.thumb AS 'headImg' "
            + " FROM article_img ari"
            + " WHERE ari.blogId = #{blogId} AND ari.status = #{status} and  DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(ari.releaseTime) order by ari.releaseTime desc LIMIT #{offset}, #{pageCount}")
    List<ArticleVO> queryForCustomerLaundByBlogId(Map<String, Object> paramMap);

    @Select("SELECT count(DISTINCT(ar.`articleId`)) FROM article_read ar LEFT JOIN article_img ai ON ai.`id` = ar.`articleId` WHERE ar.userId = #{id} AND ai.`status` = #{status} ")
	int queryReadCountByUserId(@Param("id") int id, @Param("status") int status);
    
    @Select("SELECT DISTINCT(ai.`id`) AS arid, ai.`number` AS number, ai.`title` AS title, atype.`name` AS typeName, bl.`name` AS labelName, ai.`category` AS category, ar.`createTime` AS  readTime "
    		+ "FROM article_img ai "
    		+ "LEFT JOIN article_read ar ON ar.`articleId` = ai.`id` "
    		+ "LEFT JOIN article_type atype ON atype.`id` = ai.`typeId` "
    		+ "LEFT JOIN blog_label bl ON bl.`id` = ai.`labelId` "
    		+ "WHERE ar.`userId` = #{userId} AND ai.`status` = #{status} GROUP BY ar.`articleId` "
    		+ " ORDER BY ar.createTime DESC LIMIT #{offset}, #{pageCount}")
	List<ReadArticleVO> queryReadListByUserId(Map<String, Object> paramMap);

    @Select("SELECT count(ac.`articleId`) FROM article_collection ac LEFT JOIN article_img ai ON ai.`id` = ac.`articleId` WHERE ac.userId = #{id} AND ai.`status` = #{status} ")
	int queryCollectCountByUserId(@Param("id") int id, @Param("status") int status);

    @Select("SELECT DISTINCT(ai.`id`) AS arid, ai.`number` AS number, ai.`title` AS title, atype.`name` AS typeName, bl.`name` AS labelName, ai.`category` AS category, ac.`createTime` AS  readTime "
    		+ "FROM article_img ai "
    		+ "LEFT JOIN article_collection ac ON ac.`articleId` = ai.`id` "
    		+ "LEFT JOIN article_type atype ON atype.`id` = ai.`typeId` "
    		+ "LEFT JOIN blog_label bl ON bl.`id` = ai.`labelId` "
    		+ "WHERE ac.`userId` = #{userId} AND ai.`status` = #{status} GROUP BY ac.`articleId` "
    		+ " ORDER BY ac.createTime DESC LIMIT #{offset}, #{pageCount}")
	List<ReadArticleVO> queryCollectListByUserId(Map<String, Object> paramMap);

    @Select("UPDATE article_img SET status = #{updateStatus},updateTime = #{updateTime} WHERE otherStatus = #{otherStatus} AND status = #{currentStatus} AND releaseTime <= #{endTime} ")
	void update5MinToBeReleased(@Param("updateStatus") int upStatus, @Param("updateTime") Date currentDate, @Param("currentStatus") int status, @Param("endTime") String endTime,@Param("otherStatus") int otherStatus);

    @Update("update article_laud set status=#{status},updateTime = #{updateTime} where id=#{id}")
    void updateArticleLuad(ArticleLaud articleLaud);

    @Update("update article_collection set status=#{status},updateTime = #{updateTime} where id=#{id}")
    void updateArticleCollection(ArticleCollection articleCollection);

    @Select("select * from article_collection where articleId=#{id} and userId=#{wapUserId}")
    ArticleCollection getArticleCollections(@Param("id") int id, @Param("wapUserId") int wapUserId);

    @Select("select * from article_laud where articleId=#{id} and userId=#{wapUserId}")
    ArticleLaud getArticleByUserIds(@Param("id") int id, @Param("wapUserId") int wapUserId);

    @Update("update article_img set status = #{status}, share = #{share},updateTime = #{updateTime} where id = #{id} and share = #{currentShare}")
	int updateARShareStatus(@Param("id") int arId,@Param("status") int status, @Param("share") int shareStatus, @Param("currentShare") int currentStatus, @Param("updateTime") String updateTime);

    @Select("select * from article_img where blogId = #{blogId} and status = #{status} and share = #{shareStatus}")
	List<Article> getBlogArticleByShare(@Param("blogId") int blogId,@Param("status") int currentStatus, @Param("shareStatus") int shareStatus);

    @SelectProvider(type = ArticleProvider.class, method = "getArListByIds")
	List<Article> getArListByIds(@Param("arIds")String arIds, @Param("blogId") int blogId);

    @Select("select * from article_img where blogId = #{blogId} and status != 5 and title = #{title}")
	List<Article> getArticleByTitleAndBlogId(@Param("blogId") int blogId, @Param("title") String title);

    @Select("select count(*) from article_img where blogId = #{blogId} and status != 5 and title = #{title}")
	int getARCountByTitleAndBlogId(@Param("title") String title, @Param("blogId") int blogId);

    @Select("select * from article_img where releaseTime <= #{releaseTime} and status = #{status}")
	List<Article> getAllPendingShareArticle(@Param("releaseTime") String endTime,@Param("status") int status);

    @Update("UPDATE article_img SET status = #{status},share = #{share},updateTime = #{updateTime} WHERE id = #{id} ")
	void updateARShareStatusAndOtherStatusById(@Param("id") int id,@Param("status") int status,@Param("share") int share,
			@Param("updateTime") String updateTime);

    @Select("select * from article_key_words where blogId = #{blogId}")
	List<ArticleKeyWords> getKeyWordsByBlogId(@Param("blogId") int blogId);
}
