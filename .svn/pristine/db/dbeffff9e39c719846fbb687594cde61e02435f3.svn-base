package com.caishen91.jupiter.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caishen91.jupiter.dao.ArticleMapper;
import com.caishen91.jupiter.dao.ArticleShareMapper;
import com.caishen91.jupiter.dao.BlogMapper;
import com.caishen91.jupiter.enums.ArticleOtherStatus;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.Share;
import com.caishen91.jupiter.service.IArticleShareService;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.ShareUtil;
import com.caishen91.jupiter.util.StringUtil;

@Service
public class ArticleShareServiceImpl extends BaseService implements IArticleShareService {

	@Autowired
	private ShareUtil shareUtil;
	
	@Override
	public int add(int arId) {
		ArticleShareMapper shareMapper = writableSQLSession.getMapper(ArticleShareMapper.class);
		Share share = new Share();
		share.setArticleId(arId);
		share.setCreateTime(new Date());
		share.setUpdateTime(new Date());
		shareMapper.add(share);
		return share.getId();
	}

	@Override
	public Integer getArIdById(int shareId) {
		ArticleShareMapper shareMapper = writableSQLSession.getMapper(ArticleShareMapper.class);
		return shareMapper.getArIdById(shareId);
	}

	@Override
	public int queryShareCountByParamMap(Map<String, Object> paramMap) {
		ArticleShareMapper shareMapper = writableSQLSession.getMapper(ArticleShareMapper.class);
		return shareMapper.queryShareCountByParamMap(paramMap);
	}

	@Override
	public void deleteShareByArId(int arId) {
		ArticleShareMapper shareMapper = writableSQLSession.getMapper(ArticleShareMapper.class);
		shareMapper.deleteShareByArId(arId);
	}

	@Override
	public int updateBatchShareStatusById(String arIds, int blogId, int currentShare,int expectShare, String updateTime,String otherStatus) {
		ArticleShareMapper shareMapper = writableSQLSession.getMapper(ArticleShareMapper.class);
		
		return shareMapper.updateBatchShareStatusById(arIds,blogId,currentShare,expectShare,updateTime,otherStatus);
	}

	@Override
	public void deleteBatchShareByArId(String arIds) {
		ArticleShareMapper shareMapper = writableSQLSession.getMapper(ArticleShareMapper.class);
		shareMapper.deleteBatchShareByArId(arIds);
	}

	@Override
	public void update5MinToBeShare(String endTime) {
		ArticleMapper articleMapper = writableSQLSession.getMapper(ArticleMapper.class);
		BlogMapper blogMapper = writableSQLSession.getMapper(BlogMapper.class);
		List<Article> arLists = articleMapper.getAllPendingShareArticle(endTime,Article.ArticleStatus.toBeReleased.getId());
		for (Article article : arLists) {
			Blog blog = blogMapper.getBlogById(article.getBlogId());
			if(StringUtil.isNotEmpty(blog.getPushUrl())) {
				shareUtil.shareForTiming(article,blog);
			}
		}
	}

	@Override
	public int updateShareStatusById(String arIds, int blogId, int currentShare, int expectShare,
			String updateTime, String otherStatus) {
		ArticleShareMapper shareMapper = writableSQLSession.getMapper(ArticleShareMapper.class);
		
		return shareMapper.updateShareStatusById(arIds,blogId,currentShare,expectShare,updateTime,otherStatus);
	}

}
