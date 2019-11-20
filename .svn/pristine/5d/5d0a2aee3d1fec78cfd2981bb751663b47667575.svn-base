package com.caishen91.jupiter.dao;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.model.BlogManagerPermit;

public class BlogManagerPermitProvider {

	/**
	 * 	批量插入默认权限
	 * @param map
	 * @return
	 */
	public String insertBatch(Map<String, Object> map) {
		List<BlogManagerPermit> bmpList = (List<BlogManagerPermit>) map.get("list");
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO blog_manager_permit ");
		sb.append("(bmId,blogId,bpId,createDate,updateDate) ");
		sb.append(" VALUES ");
		MessageFormat mf = new MessageFormat(
				"(#'{'list[{0}].bmId},#'{'list[{0}].blogId},#'{'list[{0}].bpId},#'{'list[{0}].createTime},#'{'list[{0}].updateTime})");
		for (int i = 0; i < bmpList.size(); i++) {
			sb.append(mf.format(new Object[] { i }));
			if (i < bmpList.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
}
