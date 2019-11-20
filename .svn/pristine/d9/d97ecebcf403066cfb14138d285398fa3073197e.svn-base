package com.caishen91.jupiter.service;

import java.util.List;
import java.util.Set;

import com.caishen91.jupiter.model.BlogManagerPermit;

public interface IBlogManagerPermitService {

	void insertBatch(List<BlogManagerPermit> bmpList);

	String getAllPermission(int blogId);

	void updateBlogAuth(int blogId,int bmId, Object[] blogPermitId);

	Set<String> getManagerAuthPermission(int managerId, int blogId);

	void removeAllPermissionByBmIdAndBlogId(int managerId, int blogId);

	Set<String> getBmPermission(String id, String blogId);
}
