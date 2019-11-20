package com.caishen91.jupiter.service;

import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.dto.BlogDTO;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.vo.BlogDetailVO;
import com.caishen91.jupiter.vo.BlogInfoVO;

public interface ISysBlogService {

	int querySignBlogCount(BlogDTO blogDto, String pageNo, String perPageNo);
	
	int queryUnSignBlogCount(BlogDTO blogDto, String pageNo, String perPageNo);

	List<BlogInfoVO> queryBlogList(Map<String, Object> paramMap);

	OperationResult addBlogAndManager(BlogDTO blogDTO);

	int updateBlogStatus(int blogId, int status);

	int updateBlogAuthStatus(int blogId, int authCode);

	BlogDetailVO queryBlogDetail(int id);

	int getCountByNickName(String managerNickName);

	int getCountByMobile(String mobile);

	List<Map<String, Object>> querySignBlogList(BlogDTO blogDto, String pageNo, String perPageNo);

	List<Map<String, Object>> queryUnSignBlogList(BlogDTO blogDto, String pageNo, String perPageNo);


}
