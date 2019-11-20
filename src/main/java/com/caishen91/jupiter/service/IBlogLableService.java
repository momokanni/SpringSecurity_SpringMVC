package com.caishen91.jupiter.service;

import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.model.BlogLabel;

public interface IBlogLableService {

	int queryLabelCountByBlogId(int blogId);

	List<BlogLabel> queryLabelListByBlogId(int blogId, int status);

	int updateBLStatus(int blId, int status);

	BlogLabel getLabelById(int label);

    List<BlogLabel> getLabelByBlogId(int id);

	int getLabelByStatus(int id, int status);

	boolean addLable(BlogLabel blogLabel);

	void setBlogLabelStatus(BlogLabel blogLabel);

	boolean updateLable(BlogLabel blogLabel);

	List<BlogLabel> getLabelsByBlogIdByStatus(int id, int id1);

	List<BlogLabel> getLabelListByBlogId(Map<String, Object> paramMap);

    List<BlogLabel> queryLableList(Map<String, Object> paramMap);

    BlogLabel getLabelByName(String name, int blogId);
}
