package com.caishen91.jupiter.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.StringUtil;

public class SysBlogManagerProvider {

	public String queryBMListByBlogId(Map<String,Object> params) {
		int[] statusArrary = (int[]) params.get("statusArrary");
		String str = Arrays.toString(statusArrary); 
		str = str.substring(1, str.length()-1);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT bm.`id`,bm.`mobile`,bm.`name`,bm.`nickName`,bm.`status` FROM blog_manager bm WHERE bm.`blogId` = #{blogId} and status in ");
		sb.append("(");
		sb.append(str);
		sb.append(")");
		sb.append(" order by createTime desc limit #{offset}, #{pageCount}");
		return sb.toString();
	}
	
	public String queryBMCountByBlogId(Map<String,Object> params) {
		int[] statusArrary = (int[]) params.get("statusArrary");
		String str = Arrays.toString(statusArrary); 
		str = str.substring(1, str.length()-1);
		StringBuilder sb = new StringBuilder();
		sb.append("select count(id) from blog_manager where blogId = #{blogId} and status in ");
		sb.append("(");
		sb.append(str);
		sb.append(")");
		return sb.toString();
	}
	
	public String getNoticeByType(Map<String,Object> params) {
		int[] statusArrary = (int[]) params.get("typeId");
		String str = Arrays.toString(statusArrary); 
		str = str.substring(1, str.length()-1);
		StringBuilder sb = new StringBuilder();
		sb.append("select * from notice where type in ");
		sb.append("(");
		sb.append(str);
		sb.append(") and status = #{status} order by releaseTime desc limit 1");
		return sb.toString();
	}
	
	public String getBlogArticleListByParam(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ari.`id` AS arId, ari.`title` AS title, ari.`readCount` AS readVolume, ari.`thumb` AS headImg , ari.releaseTime AS time");
		sb.append(" FROM article_img ari ");
		sb.append(" LEFT JOIN blog b ON b.id = ari.`blogId`");
		sb.append(" WHERE 1=1");
		sb.append(getParamsWhere(params));
		sb.append(" order by ari.releaseTime DESC limit #{offset}, #{pageCount}");
		return sb.toString();
    }
	
	public String getParamsWhere(Map<String, Object> params) {

        StringBuilder sb = new StringBuilder();

        String blogId = String.valueOf(params.get("blogId"));
        if (StringUtil.isNotEmpty(blogId) &&!"null".equals(blogId)) {
            sb.append(" and ari.blogId = #{blogId}");
        }
        
        String status = (String) params.get("status");
        if (StringUtil.isNotEmpty(status)) {
            sb.append(" and ari.status = #{status}");
        }
        
        String labelId = (String)params.get("labelId");
        if (StringUtil.isNotEmpty(labelId)) {
            sb.append(" and ari.labelId = #{labelId}");
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
