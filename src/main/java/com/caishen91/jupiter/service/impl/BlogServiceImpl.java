package com.caishen91.jupiter.service.impl;

import org.springframework.stereotype.Service;

import com.caishen91.jupiter.dao.BlogMapper;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.service.IBlogService;

@Service
public class BlogServiceImpl extends BaseService implements IBlogService{

	@Override
	public Blog getBlogById(int id) {
		BlogMapper blogMapper = writableSQLSession.getMapper(BlogMapper.class);
		return blogMapper.getBlogById(id);
	}

}
