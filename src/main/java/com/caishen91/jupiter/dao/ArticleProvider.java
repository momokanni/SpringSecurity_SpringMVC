package com.caishen91.jupiter.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.StringUtil;

public class ArticleProvider {


    public String getTotalArticleCountByParams(Map<String, Object> params) {

        StringBuilder sb = new StringBuilder();

        sb.append("select count(1) from article_img ari where 1 = 1 ");

        sb.append(getArticleByParamsWhere(params));

        return sb.toString();
    }


    public String getArticleByParams(Map<String, Object> params) {

        StringBuilder sb = new StringBuilder();

        sb.append("select * from article_img ari where 1 = 1");
        sb.append(getArticleByParamsWhere(params));

        sb.append(" order by ari.id desc limit #{offset}, #{pageSize}");
        return sb.toString();
    }

    public String getArticleByParamsWhere(Map<String, Object> params) {

        StringBuilder sb = new StringBuilder();

        String blogId = String.valueOf(params.get("blogId"));
        if (StringUtil.isNotEmpty(blogId) &&!"null".equals(blogId)) {
            sb.append(" and ari.blogId = #{blogId}");
        }
        
        String title = (String)params.get("title");
        if (StringUtil.isNotEmpty(title)) {
            sb.append(" and ari.title like concat('%',#{title}, '%')");
        }
        
        String typeId = (String)params.get("typeId");
        if (StringUtil.isNotEmpty(typeId)) {
            sb.append(" and ari.typeId = #{typeId}");
        }
        
        String managerId = (String)params.get("managerId");
        if (StringUtil.isNotEmpty(managerId)) {
            sb.append(" and ari.blogManagerId = #{managerId}");
        }

        List<Integer> statuses = (List)params.get("statuses");
        if (statuses != null && statuses.size() > 0) {
            sb.append(" and ari.status in ");
            sb.append(StringUtil.buildIntInSql(statuses));
        }
        
        String status = (String) params.get("status");
        if (StringUtil.isNotEmpty(status)) {
            sb.append(" and ari.status = #{status}");
        }
        
        String share = (String) params.get("share");
        if (StringUtil.isNotEmpty(share)) {
            sb.append(" and ari.share = #{share}");
        }
        
        String otherStatus = (String) params.get("otherStatus");
        if (StringUtil.isNotEmpty(otherStatus)) {
            sb.append(" and FIND_IN_SET(#{otherStatus},ari.otherStatus) ");
        }


        Date sDate =(Date)params.get("sDate");
        if (sDate != null) {
            sb.append(" and ari.releaseTime >= #{sDate}");
        }

        Date eDate =(Date)params.get("eDate");
        if (eDate != null) {
            sb.append(" and ari.releaseTime <= #{eDate}");
        }


        String startTime =DateUtil.formatDate((Date)params.get("startTime"), "yyyy-MM-dd HH:mm:ss");
        if (StringUtil.isNotEmpty(startTime) && !"null".equals(startTime)) {
            sb.append(" and ari.releaseTime > #{startTime}");
        }

        String endTime =DateUtil.formatDate((Date)params.get("endTime"), "yyyy-MM-dd HH:mm:ss");
        if (StringUtil.isNotEmpty(endTime) && !"null".equals(endTime)) {
           sb.append(" and ari.releaseTime < #{endTime}");
        }

        return sb.toString();
    }
    
    public String queryListByBlogId(Map<String,Object> params) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("SELECT ari.`id` AS id,ari.`number` AS number,ari.`title` AS title,art.`name` AS typeName,bl.`name` AS LabelName,");
    	sb.append(" ari.`category` AS category,ari.`status` AS 'status',ari.createTime AS createTime");
    	sb.append(" FROM article_img ari");
    	sb.append(" LEFT JOIN article_type art ON art.`id` = ari.`typeId`");
    	sb.append(" LEFT JOIN blog_label bl ON bl.`id` = ari.`labelId`");
    	sb.append(" WHERE ari.`blogId` = #{blogId} ");
    	sb.append(" order by ari.createTime desc limit #{offset}, #{pageCount}");
    	return sb.toString();
    }
    
    public String queryForCustomerByBlogId(Map<String,Object> params) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("SELECT ari.`id` AS id,ari.`title` AS title, ari.releaseTime AS 'releaseTime', ari.readCount AS readVolume, ari.collecCount AS collectVolume,");
    	sb.append(" ari.forwardCount AS forwardVolume, ari.ontop AS isTop, ari.`status` AS 'status', ari.thumb AS 'headImg', ari.share AS share");
    	sb.append(" FROM article_img ari");
    	sb.append(" WHERE ");
    	sb.append(" ari.status != ").append(Article.ArticleStatus.DEL.getId());
    	sb.append(getArticleByParamsWhere(params));
    	sb.append(" order by ari.createTime desc limit #{offset}, #{pageCount}");
    	return sb.toString();
    }
    
    public String queryArticleCountByParamMap(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(1) from ");
        sb.append(" (");
        sb.append(" SELECT id FROM article_img ari where status != ").append(Article.ArticleStatus.DEL.getId());
        sb.append(getArticleByParamsWhere(params));
        sb.append(") temp");
        return sb.toString();
    }
    
    public String getCountGroupByTimeAndTitle(Map<String, Object> params) {

        StringBuilder sb = new StringBuilder();
        sb.append("select ari.status , count(*) AS count from article_img ari where 1=1 ");
        sb.append(getArticleByParamsWhere(params));
        sb.append(" GROUP BY ari.status");
        return sb.toString();
    }
    
    public String delARById(Map<String, Object> params) {
    	int[] delStatus = (int[]) params.get("delStatus");
		String str = Arrays.toString(delStatus); 
		str = str.substring(1, str.length()-1);
		StringBuilder sb = new StringBuilder();
		sb.append("update article_img set status = #{change}, updateTime = #{updateTime} where id = #{id} ");
		if(delStatus.length > 0) {
			for (int i = 0; i < delStatus.length; i++) {
				if(i == 0) {
					sb.append(" AND (status = ").append(delStatus[i]);
				} else {
					sb.append(" or status = ").append(delStatus[i]);
				}
			}
			sb.append(")");
		}
		return sb.toString();
    }
    
    public String updateArticle(@Param("article") Article article) {
		StringBuilder sb = new StringBuilder();
		sb.append("update article_img set title = #{article.title}, content = #{article.content}, typeId = #{article.typeId}, labelId = #{article.labelId}, thumb = #{article.thumb},");
		sb.append(" releaseTime = #{article.releaseTime}, status = #{article.status}, updateTime = #{article.updateTime},audioName = #{article.audioName},audioPath = #{article.audioPath},");
		sb.append(" imgCount = #{article.imgCount}, shareContent = #{article.shareContent}, wordCount = #{article.wordCount}, source = #{article.source}, ");
		sb.append(" sourceId = #{article.sourceId},otherStatus = #{article.otherStatus} ");
		sb.append(" where id = #{article.id} ");
		sb.append(" AND (status = ").append(Article.ArticleStatus.draft.getId());
		sb.append(" OR status = ").append(Article.ArticleStatus.Offline.getId()).append(")");
		
		return sb.toString();
    }
    
    public String getARListByType(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ari.`id` AS arId, ari.`title` AS title, ari.`readCount` AS readVolume, ari.`forwardCount` AS forwardVolume, ");
		sb.append("ari.laudCount AS laudVolume, ari.`thumb` AS headImg, ari.releaseTime AS time, b.`headImgMb` AS blogImg, b.name AS blogName FROM article_img ari ");
		sb.append(" LEFT JOIN blog b ON b.id = ari.`blogId`");
		sb.append(" WHERE 1=1");
		sb.append(getArticleByParamsWhere(params));
		sb.append(" order by ari.releaseTime desc limit #{offset}, #{pageCount}");
		return sb.toString();
    }
    
    public String getPullDownARList(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ari.`id` AS arId, ari.`title` AS title, ari.`readCount` AS readVolume, ari.`forwardCount` AS forwardVolume, ari.laudCount AS laudVolume, ");
		sb.append("ari.`thumb` AS headImg, ari.releaseTime AS time, b.`headImgMb` AS blogImg, b.name AS blogName FROM article_img ari ");
		sb.append(" LEFT JOIN blog b ON b.id = ari.`blogId`");
		sb.append(" WHERE 1=1");
		sb.append(getArticleByParamsWhere(params));
		sb.append(" order by ari.releaseTime ASC limit #{offset}, #{pageCount}");
		return sb.toString();
    }
    
    public String getPullUpARList(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ari.`id` AS arId, ari.`title` AS title, ari.`readCount` AS readVolume, ari.`forwardCount` AS forwardVolume, ari.laudCount AS laudVolume, ");
		sb.append("ari.`thumb` AS headImg, ari.releaseTime AS time, b.`headImgMb` AS blogImg, b.name AS blogName FROM article_img ari ");
		sb.append(" LEFT JOIN blog b ON b.id = ari.`blogId`");
		sb.append(" WHERE 1=1");
		sb.append(getArticleByParamsWhere(params));
		sb.append(" order by ari.releaseTime DESC limit #{offset}, #{pageCount}");
		return sb.toString();
    }

    public String getArListByIds(Map<String, Object> params) {
    	String arIds = params.get("arIds").toString();
 		int blogId = Integer.valueOf(params.get("blogId").toString());
 		
        StringBuilder sb = new StringBuilder();
        sb.append("select * from article_img where id in");
        sb.append(" (");
        sb.append(arIds);
        sb.append(") and blogId = ").append(blogId);
        return sb.toString();
    }

}


