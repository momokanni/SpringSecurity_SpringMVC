package com.caishen91.jupiter.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

public interface IBlogManagerService {

	void addManager(BlogDTO blogDTO);

	BlogManager getUserById(int id, int blogId);

	BlogManager getBMByLoginNamePasswd(String username, String pwd);

	Blog getBlogById(int blogId);

    List<Article> getArticleByBlogId(int id);

	int getBlogFocusCountByBlogIdYesterday(int id, Date date);

	int getYesterdayCollecCount(int id,Date date);

	int getYesterdayReadCount(int id,Date date);

	int getYesterdayForwardCount(int id,Date date);

	Notice getNoticeByType(int[] platforms,int status);

	Article getArticleDrafts(int id, int status);

	List<Article> getArticleLauched(int id, int status);

	ArticleType getArticleTypeByArticlrId(int id);

	int queryBMCountByBlogId(int blogId,int[] statusArray);

	List<BlogManagerVO> queryBMListByBlogId(Map<String, Object> param);

	int updateBMStatus(int bmId, int status);

	BlogManager getBMById(int bmId);

	int updateBMPwd(BlogManagerDTO blogManagerDTO);

	int getArticleLauchedCount(int id, int status);

	boolean updateBlog(Blog blog);

	BlogManager getfindOldPwd(int id);

	boolean updatePwd(BlogManager blogManager);

	void uploadHeadImg(Blog blog);

	boolean updateArticleDraft(Article article);

	List<BlogManager> getSubBlogManager(int blogId,int type);

	List<BlogManager> getBlogManager();

	boolean addSubBlogManager(BlogManager blogManager);

	void uploadHeadImgMb(Blog blog);

	void setSubBlogManagerStatus(BlogManager blogManager);

	boolean resetPwd(BlogManager blogManager);

    void addBlogFocus(BlogFocus blogFocus);

	void updateBlogFocus(Blog blog);

	BlogFocus getBlogFocusByUserId(int blogId, int wapUserId);

	List<MobileARListVO> getBlogArticleListByParam(Map<String, Object> paramMap);

	void updateBlogFouse(BlogFocus blogFocus);

	BlogFocus getBlogFocusByUserIds(int blogId, int wapUserId);

    BlogManager getBlogManagerBymobile(String mobile);

	BlogManager getBlogManagerBynickname(String nickName);

	BlogManager getBMByBlogId(int blogId);

	List<Notice> getBlogNoticeByType(int id, int id1);

	Blog getBlogByName(String blogName);

	BlogFocus getBlogFocusById(int blogId, int userId);

	List<BlogDetailVO> getAll();

	void updateBlogManagerAuth(int id, String authStr);

	BlogManager getBmByIdAndType(int id, int type);

	void updateBmStatusBatch(int blogId, int code);

	Set<BlogManager> getBmListByBlogId(int blogId);

	List<BlogDetailVO> getNotEmptyAll();
}
