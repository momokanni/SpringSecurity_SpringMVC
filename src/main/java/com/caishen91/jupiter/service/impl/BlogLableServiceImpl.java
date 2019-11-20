package com.caishen91.jupiter.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.caishen91.jupiter.dao.BlogLabelMapper;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.service.IBlogLableService;

@Service
public class BlogLableServiceImpl extends BaseService implements IBlogLableService {

	@Override
	public int queryLabelCountByBlogId(int blogId) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.queryLabelCountByBlogId(blogId);
	}

	@Override
	public List<BlogLabel> queryLabelListByBlogId(int blogId,int status) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.queryLabelListByBlogId(blogId,status);
	}

	@Override
	public int updateBLStatus(int blId, int status) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.updateBLStatus(blId,status);
	}

	@Override
	public BlogLabel getLabelById(int label) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.getLabelById(label);
	}

	@Override
	public List<BlogLabel> getLabelByBlogId(int id) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.getLabelByBlogId(id);
	}

	@Override
	public int getLabelByStatus(int id, int status) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.getLabelByStatus(id,status);
	}

	@Override
	public boolean addLable(BlogLabel blogLabel) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		
		return labelManager.addLable(blogLabel);
	}

	@Override
	public void setBlogLabelStatus(BlogLabel blogLabel) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		labelManager.setBlogLabelStatus(blogLabel);
	}

	@Override
	public boolean updateLable(BlogLabel blogLabel) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.updateLable(blogLabel);
	}

	@Override
	public List<BlogLabel> getLabelsByBlogIdByStatus(int id, int status) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return  labelManager.getLabelsByBlogIdByStatus(id,status);
	}

	@Override
	public List<BlogLabel> getLabelListByBlogId(Map<String, Object> paramMap) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.getLabelListByBlogId(paramMap);
	}

	@Override
	public List<BlogLabel> queryLableList(Map<String, Object> paramMap) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.queryLableList(paramMap);
	}

	@Override
	public BlogLabel getLabelByName(String name,int blogId) {
		BlogLabelMapper labelManager = writableSQLSession.getMapper(BlogLabelMapper.class);
		return labelManager.getLabelByName(name,blogId);
	}

}
