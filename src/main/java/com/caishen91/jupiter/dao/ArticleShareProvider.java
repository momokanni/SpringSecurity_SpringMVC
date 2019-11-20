package com.caishen91.jupiter.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.StringUtil;

public class ArticleShareProvider {

	 	public String queryShareCountByParamMap(Map<String, Object> params) {

	        StringBuilder sb = new StringBuilder();
	        sb.append("select count(1) from ");
	        sb.append(" (");
	        sb.append(" SELECT id FROM article_img ari where 1=1 ");
	        sb.append(getArticleByParamsWhere(params));
	        sb.append(") temp");
	        return sb.toString();
	 	}
	 	
	 	/**
	 	 * 	单个移除
	 	 * @param params
	 	 * @return
	 	 */
	 	public String updateShareStatusById(Map<String, Object> params) {
	 		String arIds = params.get("arIds").toString();
	 		int blogId = Integer.valueOf(params.get("blogId").toString());
	 		int currentShare = Integer.valueOf(params.get("currentShare").toString());
	 		int expectShare = Integer.valueOf(params.get("expectShare").toString());
	 		String updateTime = params.get("updateTime").toString();
	 		String otherStatus = params.get("otherStatus").toString();
	 		
			StringBuilder sb = new StringBuilder();
			sb.append("update article_img set ")
			.append(" otherStatus = ").append(otherStatus)
			.append(", updateTime = '").append(updateTime).append("'")
			.append(" where id in ");
			sb.append("(");
			sb.append(arIds);
			sb.append(") and share = ").append(currentShare)
			.append(" and blogId = ").append(blogId);
			return sb.toString();
	 	}
	 	
	 	/**
	 	 * 	批量移除
	 	 * @param params
	 	 * @return
	 	 */
	 	public String updateBatchShareStatusById(Map<String, Object> params) {
	 		String arIds = params.get("arIds").toString();
	 		int blogId = Integer.valueOf(params.get("blogId").toString());
	 		int currentShare = Integer.valueOf(params.get("currentShare").toString());
	 		int expectShare = Integer.valueOf(params.get("expectShare").toString());
	 		String updateTime = params.get("updateTime").toString();
	 		String otherStatus = params.get("otherStatus").toString();
	 		
			StringBuilder sb = new StringBuilder();
			sb.append("update article_img set ")
			.append(" otherStatus = replace(otherStatus,'1','").append(otherStatus).append("')")
			.append(", updateTime = '").append(updateTime).append("'")
			.append(" where id in ");
			sb.append("(");
			sb.append(arIds);
			sb.append(") and share = ").append(currentShare)
			.append(" and blogId = ").append(blogId);
			return sb.toString();
	 	}
	 	
	 	/**
	 	 * 	批量移除
	 	 * @param params
	 	 * @return
	 	 */
	 	public String deleteBatchShareByArId(Map<String, Object> params) {
	 		String arIds = params.get("arIds").toString();
	 		
			StringBuilder sb = new StringBuilder();
			sb.append("delete from article_share_relation ")
			.append(" where articleId in ");
			sb.append("(");
			sb.append(arIds);
			sb.append(");");
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
}
