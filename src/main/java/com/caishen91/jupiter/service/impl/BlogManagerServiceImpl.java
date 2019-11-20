package com.caishen91.jupiter.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.caishen91.jupiter.dao.SysBlogManagerMapper;
import com.caishen91.jupiter.dto.BlogDTO;
import com.caishen91.jupiter.dto.BlogManagerDTO;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogFocus;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.model.Notice;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.vo.BlogDetailVO;
import com.caishen91.jupiter.vo.BlogManagerVO;
import com.caishen91.jupiter.vo.MobileARListVO;

@Service
public class BlogManagerServiceImpl extends BaseService implements IBlogManagerService{

	@Override
	public void addManager(BlogDTO blogDTO) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.addManager(blogDTO);
	}

	@Override
	public BlogManager getUserById(int id,int blogId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogManagerById(id,blogId);
	}

	
	@Override
	public BlogManager getBMByLoginNamePasswd(String username, String pwd) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		BlogManager bm = null;
		if(CommonUtil.isInteger(username)) {
			// 手机号密码
			bm = blogManagerMapper.queryBMByMobile(username,pwd,CommonStatus.available.getStatus());
		} else {
			bm = blogManagerMapper.queryBMByNickName(username,pwd,CommonStatus.available.getStatus());
		}
		return bm;
	}

	@Override
	public Blog getBlogById(int blogId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogById(blogId);
	}

	@Override
	public List<Article> getArticleByBlogId(int id) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getArticleByBlogId(id);
	}

	@Override
	public int getBlogFocusCountByBlogIdYesterday(int id, Date date) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogFocusCountByBlogIdYesterday(id,date);
	}

	@Override
	public int getYesterdayCollecCount(int id,Date date) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getYesterdayCollecCount(id,date);
	}

	@Override
	public int getYesterdayReadCount(int id,Date date) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getYesterdayReadCount(id,date);
	}

	@Override
	public int getYesterdayForwardCount(int id,Date date) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getYesterdayForwardCount(id,date);
	}

	@Override
	public Notice getNoticeByType(int[] platforms,int status) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getNoticeByType(platforms,status);
	}

	@Override
	public Article getArticleDrafts(int id,int status) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getArticleDrafts(id,status);
	}

	@Override
	public List<Article> getArticleLauched(int id, int status) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getArticleLauched(id,status);
	}

	@Override
	public ArticleType getArticleTypeByArticlrId(int id) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getArticleTypeByArticlrId(id);
	}

	@Override
	public int queryBMCountByBlogId(int blogId,int[] statusArray) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.queryBMCountByBlogId(blogId,statusArray);
	}

	@Override
	public List<BlogManagerVO> queryBMListByBlogId(Map<String, Object> param) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.queryBMListByBlogId(param);
	}

	@Override
	public int updateBMStatus(int bmId, int status) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.updateBMStatus(bmId,status);
	}

	@Override
	public BlogManager getBMById(int bmId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBMById(bmId);
	}

	@Override
	public int updateBMPwd(BlogManagerDTO blogManagerDTO) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.updateBMPwd(blogManagerDTO);
	}

	@Override
	public int getArticleLauchedCount(int id, int status) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getArticleLauchedCount(id,status);
	}

	@Override
	public boolean updateBlog(Blog blog) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.updateBlog(blog);
		return true;
	}

	@Override
	public BlogManager getfindOldPwd(int id) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getfindOldPwd(id);
	}

	@Override
	public boolean updatePwd(BlogManager blogManager) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		 blogManagerMapper.updatePwd(blogManager);
		return true;
	}

	@Override
	public void uploadHeadImg(Blog blog) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.uploadHeadImg(blog);
	}

	@Override
	public boolean updateArticleDraft(Article article) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.updateArticleDraft(article);
		return true;
	}

	@Override
	public List<BlogManager> getSubBlogManager(int blogId,int type) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getSubBlogManager(blogId,type);
	}

	@Override
	public List<BlogManager> getBlogManager() {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogManager();
	}

	@Override
	public boolean addSubBlogManager(BlogManager blogManager) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.addSubBlogManager(blogManager);
		return true;


	}

	@Override
	public void uploadHeadImgMb(Blog blog) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.uploadHeadImgMb(blog);
	}

	@Override
	public void setSubBlogManagerStatus(BlogManager blogManager) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.setSubBlogManagerStatus(blogManager);
	}

	@Override
	public boolean resetPwd(BlogManager blogManager) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.resetPwd(blogManager);
		return true;
	}

	@Override
	public void addBlogFocus(BlogFocus blogFocus) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.addBlogFocus(blogFocus);
	}

	@Override
	public void updateBlogFocus(Blog blog) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.updateBlogFocus(blog);
	}

	@Override
	public BlogFocus getBlogFocusByUserId(int blogId, int wapUserId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return  blogManagerMapper.getBlogFocusByUserId(blogId,wapUserId);
	}

	@Override
	public List<MobileARListVO> getBlogArticleListByParam(Map<String, Object> paramMap) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogArticleListByParam(paramMap);
	}

	@Override
	public void updateBlogFouse(BlogFocus blogFocus) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		 blogManagerMapper.updateBlogFouse(blogFocus);
	}

	@Override
	public BlogFocus getBlogFocusByUserIds(int blogId, int wapUserId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogFocusByUserIds(blogId,wapUserId);
	}

	@Override
	public BlogManager getBlogManagerBymobile(String mobile) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogManagerBymobile(mobile);
	}

	@Override
	public BlogManager getBlogManagerBynickname(String nickName) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogManagerBynickname(nickName);
	}

	@Override
	public BlogManager getBMByBlogId(int blogId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBMByBlogId(blogId);
	}

	@Override
	public List<Notice> getBlogNoticeByType(int id, int status) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogNoticeByType(id,status);
	}

	@Override
	public Blog getBlogByName(String blogName) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogByName(blogName);
	}

	@Override
	public BlogFocus getBlogFocusById(int blogId, int userId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBlogFocusById(blogId,userId);
	}

	@Override
	public List<BlogDetailVO> getAll() {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getAll();
	}

	@Override
	public void updateBlogManagerAuth(int id, String authStr) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.updateBlogManagerAuth(id,authStr);
	}

	@Override
	public BlogManager getBmByIdAndType(int id, int type) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBmByIdAndType(id,type);
	}

	@Override
	public void updateBmStatusBatch(int blogId, int code) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		blogManagerMapper.updateBmStatusBatch(blogId,code);
	}

	@Override
	public Set<BlogManager> getBmListByBlogId(int blogId) {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getBmListByBlogId(blogId);
	}

	@Override
	public List<BlogDetailVO> getNotEmptyAll() {
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		return blogManagerMapper.getNotEmptyAll();
	}
}
