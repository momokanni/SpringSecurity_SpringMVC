package com.caishen91.jupiter.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.caishen91.jupiter.dto.BlogDTO;
import com.caishen91.jupiter.dto.BlogManagerDTO;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogFocus;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.model.Notice;
import com.caishen91.jupiter.vo.BlogDetailVO;
import com.caishen91.jupiter.vo.BlogManagerVO;
import com.caishen91.jupiter.vo.MobileARListVO;

public interface SysBlogManagerMapper {

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into blog_manager (nickName,mobile,name,password,isManager,status,blogId,createTime,updateTime) values (#{managerNickName},#{mobile},#{managerName},#{password},#{isManager},#{managerStatus},#{id},#{createTime},#{updateTime})")
	void addManager(BlogDTO blogDTO);

	@Select("select * from blog_manager where id = #{id} and blogId = #{blogId}")
	BlogManager getBlogManagerById(@Param("id") int id, @Param("blogId") int blogId);

	@Select("select * from blog_manager where mobile = #{mobile} and password = #{password} and status = #{status}")
	BlogManager queryBMByMobile(@Param("mobile") String mobile, @Param("password") String pwd,@Param("status") int status);

	@Select("select * from blog_manager where nickName = #{nickName} and password = #{password} and status = #{status}")
	BlogManager queryBMByNickName(@Param("nickName") String nickName, @Param("password") String pwd,@Param("status") int status);

	@Select("select * from blog where id= #{blogId} ")
    Blog getBlogById(@Param("blogId") int blogId);

	@Select("select * from article_img where blogId= #{id} ")
	List<Article> getArticleByBlogId(@Param("id") int id);

	@Select("select count(1) from blog_focus where BlogId=#{id} and status=1 and  DATEDIFF(createTime,#{date})=-1 ")
	int getBlogFocusCountByBlogIdYesterday(@Param("id")int id ,@Param("date") Date date);

	@Select("select count(1) from article_collection where articleId=#{id} and  DATEDIFF(createTime,#{date})=-1 ")
	int getYesterdayCollecCount(@Param("id")int id ,@Param("date")Date date);

	@Select("select count(1) from article_read where articleId=#{id} and  DATEDIFF(createTime,#{date})=-1 ")
	int getYesterdayReadCount(@Param("id") int id ,@Param("date")Date date);

	@Select("select count(1) from article_forward where articleId=#{id} and  DATEDIFF(createTime,#{date})=-1 ")
	int getYesterdayForwardCount(@Param("id") int id ,@Param("date")Date date);

	@SelectProvider(type = SysBlogManagerProvider.class,method = "getNoticeByType")
	Notice getNoticeByType(@Param("typeId") int[] platforms,@Param("status") int status);

	@Select("select * from article_img where blogManagerId=#{id} and status=#{status} order by createTime desc limit 1 ")
	Article getArticleDrafts(@Param("id")int id,@Param("status") int status);

	@Select("select * from article_img where blogManagerId=#{id} and status=#{status} and  DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(releaseTime) order by releaseTime desc ")
	List<Article> getArticleLauched(@Param("id") int id, @Param("status")int status);

	@Select("select * from article_type where id= #{id} ")
	ArticleType getArticleTypeByArticlrId(@Param("id")int id);

	@SelectProvider(type = SysBlogManagerProvider.class,method = "queryBMCountByBlogId")
	int queryBMCountByBlogId(@Param("blogId") int blogId,@Param("statusArrary") int[] statusArray);

	@SelectProvider(type = SysBlogManagerProvider.class,method = "queryBMListByBlogId")
	List<BlogManagerVO> queryBMListByBlogId(Map<String, Object> param);

	@Update("update blog_manager set status = #{status} where id = #{id}")
	int updateBMStatus(@Param("id")int bmId, @Param("status")int status);

	@Select("select * from blog_manager where id=#{id}")
	BlogManager getBMById(int bmId);

	@Update("update blog_manager set password = #{pwd} where id = #{id}")
	int updateBMPwd(BlogManagerDTO blogManagerDTO);

	@Select("select count(1) from article_img where blogManagerId=#{id} and status=#{status} and  DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(releaseTime) order by releaseTime desc ")
	int getArticleLauchedCount(@Param("id")int id,@Param("status") int status);

	@Update("update blog set name = #{name}, "
			+ "						 description = #{description},"
			+ "						 email = #{email},"
			+ " 					 pushUrl = #{pushUrl},"
			+ "						 updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	void updateBlog(Blog blog);

	@Select("select * from blog_manager where id= #{id}")
	BlogManager getfindOldPwd(@Param("id") int id);

	@Update("update blog_manager set password = #{password}, "
			+ "						 updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	void updatePwd(BlogManager blogManager);

	@Update("update blog set headImg = #{headImg}"
			+ "				   where id = #{id}")
	void uploadHeadImg(Blog blog);

	@Update("update article_img set status = #{status},"
			+ "				    updateTime = #{updateTime},"
			+ "				    releaseTime = #{releaseTime}"
			+ "				   where id = #{id}")
	void updateArticleDraft(Article article);

	@Select("select * from blog_manager where blogId= #{blogId}  and isManager = #{type}")
	List<BlogManager> getSubBlogManager(@Param("blogId") int blogId,@Param("type") int type);

	@Select("select * from blog_manager")
	List<BlogManager> getBlogManager();

	@Insert("insert into blog_manager "
			+ "					("
			+ "					nickName,mobile,name,password,isManager,status,blogId,createTime"
			+ "					)" +
			" 			values"
			+ "					("
			+ "					#{nickName},#{mobile},#{name},#{password},#{isManager},#{status},#{blogId},#{createTime}"
			+ "					)")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void addSubBlogManager(BlogManager blogManager);

	@Update("update blog set headImgMb = #{headImgMb}"
			+ "				   where id = #{id}")
	void uploadHeadImgMb(Blog blog);

	@Update("update blog_manager set status = #{status},"
			+ "				    updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	void setSubBlogManagerStatus(BlogManager blogManager);


	@Update("update blog_manager set password = #{password},"
			+ "				    updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	void resetPwd(BlogManager blogManager);

	@Insert("insert into blog_focus "
			+ "					("
			+ "					blogId,userId,status,createTime"
			+ "					)" +
			" 			values"
			+ "					("
			+ "					#{blogId},#{userId},#{status},#{createTime}"
			+ "					)")
	@Options(useGeneratedKeys = true, keyProperty = "id")
    void addBlogFocus(BlogFocus blogFocus);

	@Update("update blog set fansCount = #{fansCount},"
			+ "				    updateTime = #{updateTime}"
			+ "				   where id = #{id}")
	void updateBlogFocus(Blog blog);

	@Select("select * from blog_focus where blogId= #{blogId}  and userId = #{wapUserId} and status = 1")
	BlogFocus getBlogFocusByUserId(@Param("blogId") int blogId, @Param("wapUserId") int wapUserId);

	@SelectProvider(type = SysBlogManagerProvider.class, method = "getBlogArticleListByParam")
	List<MobileARListVO> getBlogArticleListByParam(Map<String, Object> paramMap);

	@Update("update blog_focus set status =#{status},updateTime = #{updateTime} where id = #{id}")
	void updateBlogFouse(BlogFocus blogFocus);

	@Select("select * from blog_focus where blogId= #{blogId}  and userId = #{wapUserId}")
	BlogFocus getBlogFocusByUserIds(@Param("blogId") int blogId, @Param("wapUserId") int wapUserId);

	@Select("select * from blog_manager where mobile= #{mobile}")
    BlogManager getBlogManagerBymobile(String mobile);

	@Select("select * from blog_manager where nickName= #{nickName}")
	BlogManager getBlogManagerBynickname(String nickName);

	@Select("select * from blog_manager where blogId= #{blogId}")
	BlogManager getBMByBlogId(@Param("blogId") int blogId);

	@Select("select * from notice where type <> #{id} and status=#{status} order by releaseTime desc ")
	List<Notice> getBlogNoticeByType(@Param("id") int id,@Param("status") int status);

	@Select("select * from blog where name=#{blogName} ")
	Blog getBlogByName(String blogName);

	@Select("select * from blog_focus where blogId=#{blogId} AND userId = #{userId} ")
	BlogFocus getBlogFocusById(@Param("blogId") int blogId, @Param("userId") int userId);

	@Select("select name AS 'blogName',headImgMb AS 'headImg' from blog WHERE `name` != ''")
	List<BlogDetailVO> getAll();

	@Select("select id from blog_manager where blogId = #{blogId} and isManager = #{isManager}")
	int getBmIdByBlogId(@Param("blogId") int blogId, @Param("isManager") int isManager);

	@Update("update blog_manager set authorities = #{authorities} where id = #{id}")
	void updateBlogManagerAuth(@Param("id") int id,@Param("authorities") String authStr);

	@Select("select * from blog_manager where blogId= #{blogId} and isManager = #{isManager}")
	BlogManager getBmByIdAndType(@Param("blogId") int id, @Param("isManager") int type);

	@Select("update blog_manager set status = #{status} where blogId = #{blogId}")
	void updateBmStatusBatch(@Param("blogId") int blogId, @Param("status") int code);

	@Select("select * from blog_manager where blogId= #{blogId} ")
	Set<BlogManager> getBmListByBlogId(@Param("blogId") int blogId);

	@Select("select id,name AS 'blogName' from blog WHERE `name` != '' and headImgMb != ''")
	List<BlogDetailVO> getNotEmptyAll();
}
