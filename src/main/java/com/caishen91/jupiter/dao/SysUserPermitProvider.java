package com.caishen91.jupiter.dao;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import com.caishen91.jupiter.model.SysUserPermit;

public class SysUserPermitProvider {
	
	/**
	 * 	批量插入默认权限
	 * @param map
	 * @return
	 */
	public String insertBatch(Map<String, Object> map) {
		List<SysUserPermit> bmpList = (List<SysUserPermit>) map.get("list");
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO sysUserPermit ");
		sb.append("(userId,refId,permit,roleId) ");
		sb.append(" VALUES ");
		MessageFormat mf = new MessageFormat(
				"(#'{'list[{0}].userId},#'{'list[{0}].refId},#'{'list[{0}].permit},#'{'list[{0}].roleId})");
		for (int i = 0; i < bmpList.size(); i++) {
			sb.append(mf.format(new Object[] { i }));
			if (i < bmpList.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
}
