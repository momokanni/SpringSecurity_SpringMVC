package com.caishen91.jupiter.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.caishen91.jupiter.dao.ArticleMapper;
import com.caishen91.jupiter.dao.BlogMapper;
import com.caishen91.jupiter.dto.ArticleDTO;
import com.caishen91.jupiter.enums.ArticleOtherStatus;
import com.caishen91.jupiter.enums.ArticleReleaseType;
import com.caishen91.jupiter.enums.CategoryType;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleCollection;
import com.caishen91.jupiter.model.ArticleKeyWords;
import com.caishen91.jupiter.model.ArticleLaud;
import com.caishen91.jupiter.model.ArticleRead;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.HtmlUtil;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.vo.ARDetailVO;
import com.caishen91.jupiter.vo.ArticleVO;
import com.caishen91.jupiter.vo.MobileARListVO;
import com.caishen91.jupiter.vo.ReadArticleVO;

@Service
public class ArticleServiceImpl extends BaseService implements IArticleService {
	
    @Override
    public int getTotalArticleCountByParams(Map queryMap) {
        ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getTotalArticleCountByParams(queryMap);
    }

    @Override
    public List<Article> getArticleByParams(Map queryMap) {
        ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getArticleByParams(queryMap);
    }

    @Override
    public Blog getBlogNameById(int blogId) {
        ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getBlogNameById(blogId);
    }

    @Override
    public Article getArticleById(int id) {
        ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getArticleById(id);
    }

    @Override
    public boolean setArticleStatus(Article article) {
        ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        articleMapper.setArticleStatus(article);
        return true;
    }

    @Override
    public Blog getBlogIdByName(String blogName) {
        ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getBlogIdByName(blogName);
    }

    @Override
	public int queryArticleCountByBlogId(int blogId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.queryArticleCountByBlogId(blogId);
	}

	@Override
	public List<ArticleVO> queryListByBlogId(Map<String, Object> param) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.queryListByBlogId(param);
	}

	@Override
	public int updateARStatus(int arId, int status) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.updateARStatus(arId,status);
	}

    @Override
    public BlogLabel getBlogLabelById(int labelId) {
        ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getBlogLabelById(labelId);
    }

	@Override
	public int saveDraft(ArticleDTO arDto) {
		BlogMapper blogMapper = writableSQLSession.getMapper(BlogMapper.class);
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		Article ar = new Article();
		ar.setNumber(CommonUtil.gennumber());
		ar.setTitle(arDto.getTitle());
		ar.setContent(arDto.getContent());
		ar.setCategory(CategoryType.ARTICLE_IMG.getCode());
		ar.setTypeId(Integer.valueOf(arDto.getType()));
		ar.setLabelId(Integer.valueOf(arDto.getLabel()));
		ar.setThumb(arDto.getThumb());
		ar.setReadCount(0);
		ar.setCollecCount(0);
		ar.setForwardCount(0);
		ar.setLaudCount(0);
		ar.setOntop(Article.ArticleOntop.no.getId());
		ar.setBlogId(arDto.getBlogId());
		ar.setBlogManagerId(arDto.getManagerId());
		ar.setStatus(Article.ArticleStatus.draft.getId());
		ar.setReleaseTime(StringUtil.isEmpty(arDto.getTime()) ? null : DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm:ss"));
		ar.setCreateTime(new Date());
		ar.setUpdateTime(new Date());
		ar.setAudioPath(arDto.getAudioPath());
		ar.setAudioName(arDto.getAudioName());
		ar.setShareContent(arDto.getShareContent());
		ar.setImgCount(HtmlUtil.getImgStr(arDto.getContent()).size());
		ar.setWordCount(arDto.getWordCount());
		ar.setSourceId(arDto.getArticleSourceId() == null ? 0 : arDto.getArticleSourceId());
		if(arDto.getArticleSourceId() != null && arDto.getArticleSourceId() != 0) {
			Blog blog = blogMapper.getBlogById(arDto.getArticleSourceId());
			ar.setSource(blog.getHeadImgMb());
		}
		ar.setOtherStatus(arDto.getOtherStatus() == null ? String.valueOf(ArticleOtherStatus.NO_STATUS.getType()) : arDto.getOtherStatus());
		return articleMapper.save(ar);
	}

	@Override
	public Article saveArticle(ArticleDTO arDto) {
		BlogMapper blogMapper = writableSQLSession.getMapper(BlogMapper.class);
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		Article ar = new Article();
		ar.setNumber(CommonUtil.gennumber());
		ar.setTitle(arDto.getTitle());
		ar.setContent(arDto.getContent());
		ar.setCategory(CategoryType.ARTICLE_IMG.getCode());
		ar.setTypeId(Integer.valueOf(arDto.getType()));
		ar.setLabelId(Integer.valueOf(arDto.getLabel()));
		ar.setThumb(arDto.getThumb());
		ar.setReadCount(0);
		ar.setCollecCount(0);
		ar.setForwardCount(0);
		ar.setLaudCount(0);
		ar.setOntop(Article.ArticleOntop.no.getId());
		ar.setBlogId(arDto.getBlogId());
		ar.setBlogManagerId(arDto.getManagerId());
		ar.setAudioName(arDto.getAudioName());
		ar.setAudioPath(arDto.getAudioPath());
		ar.setShareContent(arDto.getShareContent());
		ar.setImgCount(HtmlUtil.getImgStr(arDto.getContent()).size());
		ar.setWordCount(arDto.getWordCount() == null ? 0 : arDto.getWordCount());
		ar.setSourceId(arDto.getArticleSourceId() == null ? 0 : arDto.getArticleSourceId());
		if(arDto.getArticleSourceId() != null && arDto.getArticleSourceId() != 0) {
			Blog blog = blogMapper.getBlogById(arDto.getArticleSourceId());
			ar.setSource(blog.getHeadImgMb());
		}
		// 如果是立即发布，状态为 已发布，发布时间为当前时间
		if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.RIGHT_NOW.getCode()) {
			ar.setStatus(Article.ArticleStatus.hasBeenReleased.getId());
			ar.setReleaseTime(new Date());
		} else {
			ar.setStatus(Article.ArticleStatus.toBeReleased.getId());
			ar.setReleaseTime(arDto.getTime().equals("") ? new Date() : DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		ar.setOtherStatus(arDto.getOtherStatus() == null ? String.valueOf(ArticleOtherStatus.NO_STATUS.getType()) : arDto.getOtherStatus());
		ar.setCreateTime(new Date());
		ar.setUpdateTime(new Date());
		articleMapper.save(ar);
		return ar;
	}

	@Override
	public int getARCountByTitle(String title,int arId,int blogId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getARCountByTitle(title,arId,blogId);
	}

	@Override
	public List<ArticleVO> queryForCustomerByBlogId(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.queryForCustomerByBlogId(paramMap);
	}

	@Override
	public int queryArticleCountByParamMap(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.queryArticleCountByParamMap(paramMap);
	}

	@Override
	public List<Map<String, Object>> getCountGroupByTimeAndTitle(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getCountGroupByTimeAndTitle(paramMap);
	}

	@Override
	public int updateIsTopStatus(int arId,int current, int change,String updateTime) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.updateIsTopStatus(arId,current,change,updateTime);
	}

	@Override
	public List<Article> getArticleInfo() {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleInfo();
	}

	@Override
	public List<Article> getRmdArticleInfo(Date date,int typeId,int id) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getRmdArticleInfo(date,typeId,id);
	}

	@Override
	public void updateIsTopByBlogId(int blogId, int current, int change) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        articleMapper.updateIsTopStatusByBlogId(blogId,current,change);
	}

	@Override
	public int updateARStatusById(int arId, int change,int topStatus,String updateTime) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.updateARStatusById(arId,change,topStatus,updateTime);
	}
	
	@Override
	public List<Article> getArticleByBlogId(int blogId,int status) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleByBlogId(blogId,status);
	}

	@Override
	public int delARById(int arId, int[] delStatus, int change, String updateTime) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.delARById(arId,delStatus,change,updateTime);
	}

	@Override
	public ARDetailVO getARDetailByIdAndBlogId(int arId, int blogId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
        return articleMapper.getARDetailByIdAndBlogId(arId,blogId);
	}

	@Override
	public int updateArticle(ArticleDTO arDto) {
		BlogMapper blogMapper = writableSQLSession.getMapper(BlogMapper.class);
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		Article ar = new Article();
		ar.setId(Integer.valueOf(arDto.getId()));
		ar.setTitle(arDto.getTitle());
		ar.setContent(arDto.getContent());
		ar.setTypeId(Integer.valueOf(arDto.getType()));
		ar.setLabelId(Integer.valueOf(arDto.getLabel()));
		ar.setThumb(arDto.getThumb());
		// 如果是立即发布，状态为 已发布，发布时间为当前时间
		if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.RIGHT_NOW.getCode()) {
			ar.setStatus(Article.ArticleStatus.hasBeenReleased.getId());
			ar.setReleaseTime(new Date());
		} else {
			ar.setStatus(Article.ArticleStatus.toBeReleased.getId());
			ar.setReleaseTime(arDto.getTime().equals("") ? null : DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		ar.setOtherStatus(arDto.getOtherStatus() == null ? String.valueOf(ArticleOtherStatus.NO_STATUS.getType()) : arDto.getOtherStatus());
		ar.setUpdateTime(new Date());
		ar.setAudioName(arDto.getAudioName());
		ar.setAudioPath(arDto.getAudioPath());
		ar.setShareContent(arDto.getShareContent());
		ar.setWordCount(arDto.getWordCount() == null ? 0 : arDto.getWordCount());
		ar.setImgCount(HtmlUtil.getImgStr(arDto.getContent()).size());
		ar.setSourceId(arDto.getArticleSourceId() == null ? 0 : arDto.getArticleSourceId());
		if(arDto.getArticleSourceId() != null && arDto.getArticleSourceId() != 0) {
			Blog blog = blogMapper.getBlogById(arDto.getArticleSourceId());
			ar.setSource(blog.getHeadImgMb());
		}
        return articleMapper.updateArticle(ar);
	}

	@Override
	public int updateDraft(ArticleDTO arDto) {
		BlogMapper blogMapper = writableSQLSession.getMapper(BlogMapper.class);
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		Article ar = new Article();
		ar.setId(Integer.valueOf(arDto.getId()));
		ar.setTitle(arDto.getTitle());
		ar.setContent(arDto.getContent());
		ar.setTypeId(Integer.valueOf(arDto.getType()));
		ar.setLabelId(Integer.valueOf(arDto.getLabel()));
		ar.setThumb(arDto.getThumb());
		ar.setStatus(Article.ArticleStatus.draft.getId());
		ar.setReleaseTime(StringUtil.isEmpty(arDto.getTime()) ? null : DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm:ss"));
		ar.setUpdateTime(new Date());
		ar.setAudioName(arDto.getAudioName());
		ar.setAudioPath(arDto.getAudioPath());
		ar.setShareContent(arDto.getShareContent());
		ar.setImgCount(HtmlUtil.getImgStr(arDto.getContent()).size());
		ar.setWordCount(arDto.getWordCount());
		ar.setSourceId(arDto.getArticleSourceId() == null ? 0 : arDto.getArticleSourceId());
		if(arDto.getArticleSourceId() != null && arDto.getArticleSourceId() != 0) {
			Blog blog = blogMapper.getBlogById(arDto.getArticleSourceId());
			ar.setSource(blog.getHeadImgMb());
		}
		ar.setOtherStatus(arDto.getOtherStatus() == null ? String.valueOf(ArticleOtherStatus.NO_STATUS.getType()) : arDto.getOtherStatus());
		return articleMapper.updateArticle(ar);
	}

	@Override
	public List<ArticleCollection> getArticleCollectionByWapUserId(int wapUserId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleCollectionByWapUserId(wapUserId);
	}

	@Override
	public ArticleVO queryTopAR(int blogId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.queryTopAR(blogId,Article.ArticleOntop.top.getId());
	}

	@Override
	public List<MobileARListVO> getARListByType(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getARListByType(paramMap);
	}

	@Override
	public List<MobileARListVO> getPullDownARList(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getPullDownARList(paramMap);
	}

	@Override
	public List<MobileARListVO> getPullUpARList(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getPullUpARList(paramMap);
	}

	@Override
	public void addArticleRead(ArticleRead articleRead) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.addArticleRead(articleRead);
	}

	@Override
	public void updateArticleReadCount(Article article) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.updateArticleReadCount(article);
	}

	@Override
	public ArticleLaud getArticleByUserId(int id, int wapUserId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleByUserId(id,wapUserId);
	}

	@Override
	public void addArticleLaud(ArticleLaud iarticleLaud) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.addArticleLaud(iarticleLaud);
	}

	@Override
	public void updateArticleLuadCount(Article article) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.updateArticleLuadCount(article);

	}

	@Override
	public ArticleCollection getArticleCollection(int id, int wapUserId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleCollection(id,wapUserId);
	}

	@Override
	public void updateArticleCollectionCount(Article article) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.updateArticleCollectionCount(article);
	}

	@Override
	public void addArticleCollection(ArticleCollection iarticleCollection) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.addArticleCollection(iarticleCollection);
	}

	@Override
	public int queryArticleLaundCountByParamMap(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.queryArticleLaundCountByParamMap(paramMap);
	}

	@Override
	public List<ArticleVO> queryForCustomerLaundByBlogId(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.queryForCustomerLaundByBlogId(paramMap);
	}

	@Override
	public int queryReadCountByUserId(int id, int status) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.queryReadCountByUserId(id,status);
	}

	@Override
	public List<ReadArticleVO> queryReadListByUserId(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.queryReadListByUserId(paramMap);
	}

	@Override
	public int queryCollectCountByUserId(int id, int status) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.queryCollectCountByUserId(id,status);
	}

	@Override
	public List<ReadArticleVO> queryCollectListByUserId(Map<String, Object> paramMap) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.queryCollectListByUserId(paramMap);
	}

	@Override
	public void update5MinToBeReleased(int upStatus, Date currentTime, int currentStatus, String endTime) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.update5MinToBeReleased(upStatus,currentTime,currentStatus,endTime,ArticleOtherStatus.NO_STATUS.getType());
	}
	
	@Override
	public int updateARShareStatusById(int arId,int status, int shareStatus, int currentStatus, String updateTime) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.updateARShareStatus(arId,status,shareStatus,currentStatus,updateTime);
	}

	@Override
	public void updateArticleLuad(ArticleLaud articleLaud) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.updateArticleLuad(articleLaud);
	}

	@Override
	public void updateArticleCollection(ArticleCollection articleCollection) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.updateArticleCollection(articleCollection);
	}

	@Override
	public ArticleCollection getArticleCollections(int id, int wapUserId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleCollections(id,wapUserId);
	}

	@Override
	public ArticleLaud getArticleByUserIds(int id, int wapUserId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleByUserIds(id,wapUserId);
	}

	@Override
	public List<Article> getBlogArticleByShare(int blogId, int currentStatus, int shareStatus) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getBlogArticleByShare(blogId,currentStatus,shareStatus);
	}

	@Override
	public List<Article> getArListByIds(String arIds, int blogId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArListByIds(arIds,blogId);
	}

	@Override
	public List<Article> getArticleByTitleAndBlogId(int blogId, String title) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getArticleByTitleAndBlogId(blogId,title);
	}

	@Override
	public int getARCountByTitleAndBlogId(String title, int blogId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getARCountByTitleAndBlogId(title,blogId);
	}

	@Override
	public void updateARShareStatusAndOtherStatusById(int id,int status ,int share,String updateTime) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		articleMapper.updateARShareStatusAndOtherStatusById(id,status,share,updateTime);
	}

	@Override
	public List<ArticleKeyWords> getKeyWordsByBlogId(int blogId) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		return articleMapper.getKeyWordsByBlogId(blogId);
	}

}
