package com.caishen91.jupiter.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.dto.ArticleDTO;
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

public interface IArticleService {
    int getTotalArticleCountByParams(Map queryMap);

    List<Article> getArticleByParams(Map queryMap);

    Blog getBlogNameById(int blogId);

    Article getArticleById(int id);

    boolean setArticleStatus(Article article);

    Blog getBlogIdByName(String blogName);

    int queryArticleCountByBlogId(int blogId);

	List<ArticleVO> queryListByBlogId(Map<String, Object> param);

	int updateARStatus(int arId, int status);

    BlogLabel getBlogLabelById(int labelId);

	int saveDraft(ArticleDTO arDto);

	Article saveArticle(ArticleDTO arDto);

	int getARCountByTitle(String title, int arId, int blogId);

	List<ArticleVO> queryForCustomerByBlogId(Map<String, Object> paramMap);

	int queryArticleCountByParamMap(Map<String, Object> paramMap);

	List<Map<String, Object>> getCountGroupByTimeAndTitle(Map<String, Object> paramMap);

	int updateIsTopStatus(int arId, int current, int change, String updateTime);

    List<Article> getArticleInfo();

    List<Article> getRmdArticleInfo(Date date,int typeId,int id);

	void updateIsTopByBlogId(int blogId, int current, int change);

	int updateARStatusById(int arId, int id, int topStatus, String updateTime);

    List<Article> getArticleByBlogId(int blogId,int status);

	int delARById(int arId, int[] delStatus, int change, String updateTime);

	ARDetailVO getARDetailByIdAndBlogId(int arId, int blogId);

	int updateArticle(ArticleDTO arDto);

	int updateDraft(ArticleDTO arDto);

    List<ArticleCollection> getArticleCollectionByWapUserId(int wapUserId);

	ArticleVO queryTopAR(int blogId);

	List<MobileARListVO> getARListByType(Map<String, Object> paramMap);

	List<MobileARListVO> getPullDownARList(Map<String, Object> paramMap);

	List<MobileARListVO> getPullUpARList(Map<String, Object> paramMap);

    void addArticleRead(ArticleRead articleRead);

	void updateArticleReadCount(Article article);

	ArticleLaud getArticleByUserId(int id, int wapUserId);

	void addArticleLaud(ArticleLaud iarticleLaud);

	void updateArticleLuadCount(Article article);

	ArticleCollection getArticleCollection(int id, int wapUserId);

	void updateArticleCollectionCount(Article article);

	void addArticleCollection(ArticleCollection iarticleCollection);

    int queryArticleLaundCountByParamMap(Map<String, Object> paramMap);

	List<ArticleVO> queryForCustomerLaundByBlogId(Map<String, Object> paramMap);

	int queryReadCountByUserId(int id, int status);

	List<ReadArticleVO> queryReadListByUserId(Map<String, Object> paramMap);

	int queryCollectCountByUserId(int id, int status);

	List<ReadArticleVO> queryCollectListByUserId(Map<String, Object> paramMap);

	void update5MinToBeReleased(int upStatus, Date currentTime, int currentStatus, String endTime);

	void updateArticleLuad(ArticleLaud articleLaud);

	void updateArticleCollection(ArticleCollection articleCollection);

	ArticleCollection getArticleCollections(int id, int wapUserId);

	ArticleLaud getArticleByUserIds(int id, int wapUserId);

	int updateARShareStatusById(int arId,int status, int shareStatus, int currentStatus, String updateTime);

	List<Article> getBlogArticleByShare(int blogId, int id, int status);

	List<Article> getArListByIds(String arIds, int blogId);

	List<Article> getArticleByTitleAndBlogId(int blogId, String title);

	int getARCountByTitleAndBlogId(String title, int blogId);

	void updateARShareStatusAndOtherStatusById(int id,int status, int share,String updateTime);

	List<ArticleKeyWords> getKeyWordsByBlogId(int blogId);

}
