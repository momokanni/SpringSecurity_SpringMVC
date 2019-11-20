package com.caishen91.jupiter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.caishen91.jupiter.authorize.enums.BlogEnabledStatus;
import com.caishen91.jupiter.authorize.util.PasswordEncoderUtil;
import com.caishen91.jupiter.dao.SysBlogMapper;
import com.caishen91.jupiter.dto.BlogDTO;
import com.caishen91.jupiter.enums.BlogAuthStatus;
import com.caishen91.jupiter.enums.BlogType;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.BlogManagerPermit;
import com.caishen91.jupiter.service.IBlogManagerPermitService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.service.ISysBlogService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.vo.BlogDetailVO;
import com.caishen91.jupiter.vo.BlogInfoVO;

@Service
public class SysBlogServiceImpl extends BaseService implements ISysBlogService{

	private static Logger logger = LoggerFactory.getLogger(SysBlogServiceImpl.class);
	
	@Autowired
	private IBlogManagerService managerService;
	
	@Autowired
	IBlogManagerPermitService blogManagerPermitService;
	
	@Autowired
	IBlogPermitService blogPermitService;
	
	/**
	 * 	获取已认证公众号总数
	 */
	@Override
	public int querySignBlogCount(BlogDTO blogDto,String pageNo, String perPageNo) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
		paramMap.put("blogName", blogDto.getBlogName());
		paramMap.put("managerName", blogDto.getManagerName());
		paramMap.put("mobile", blogDto.getMobile());
		paramMap.put("blogType", blogDto.getBlogType());
		paramMap.put("blogStatus", blogDto.getBlogStatus());
		paramMap.put("authStatus", String.valueOf(BlogAuthStatus.CERTIFIED.getAuthCode()));
		return blogMapper.queryBlogCount(paramMap);
	}
	
	/**
	 * 	获取未认证公众号总数
	 */
	@Override
	public int queryUnSignBlogCount(BlogDTO blogDto, String pageNo, String perPageNo) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
		paramMap.put("blogName", blogDto.getBlogName());
		paramMap.put("managerName", blogDto.getManagerName());
		paramMap.put("mobile", blogDto.getMobile());
		paramMap.put("blogType", blogDto.getBlogType());
		paramMap.put("blogStatus", blogDto.getBlogStatus());
		paramMap.put("authStatus", String.valueOf(BlogAuthStatus.UNCERTIFIED.getAuthCode()));
		return blogMapper.queryBlogCount(paramMap);
	}

	/**
	 * 	查询公众号列表
	 */
	@Deprecated
	@Override
	public List<BlogInfoVO> queryBlogList(Map<String, Object> paramMap) {
		
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		return blogMapper.queryBlogList(paramMap);
	}

	/**
	 * 	创建公众号
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public OperationResult addBlogAndManager(BlogDTO blogDTO) {
		OperationResult result = new OperationResult();
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		try {
			Date current = new Date();
			blogDTO.setCreateTime(current);
			blogDTO.setUpdateTime(current);
			blogDTO.setBlogStatus(String.valueOf(CommonStatus.available.getStatus()));
			blogDTO.setAuthStatus(String.valueOf(BlogAuthStatus.UNCERTIFIED.getAuthCode()));
			blogDTO.setFansCount(0);
			// 1.  创建商户
			blogMapper.createBlog(blogDTO);
			blogDTO.setId(blogDTO.getId());
			blogDTO.setManagerStatus(BlogEnabledStatus.ENABLED.getCode());
			blogDTO.setPassword(PasswordEncoderUtil.encode(blogDTO.getPassword()));
			// 新创建的商户ID
			int blogId = blogDTO.getId();
			// 2. 创建商户管理员
			managerService.addManager(blogDTO);
			/**
			 * 	将默认权限添加到【管理员权限关联表】
			 * 	1. 根据商户类型查出对应的权限
			 * 	2. 组装管理员权限关联表权限数据 批量插入
			 */
			List<Map<String, Object>> permits = null;
			if(Integer.valueOf(blogDTO.getBlogType()) == BlogType.COMPANY.getType()) {
				permits = blogPermitService.getCompanyDefaultPermit();
			} else {
				permits = blogPermitService.getPersonalDefaultPermit();
			}
			List<String> authorizes = null;
			List<BlogManagerPermit> bmpList = null;
			if(permits != null && permits.size() > 0) {
				bmpList = new ArrayList<BlogManagerPermit>();
				authorizes = new ArrayList<String>();
				for (Map<String, Object> permit : permits) {
					BlogManagerPermit bmp = new BlogManagerPermit();
					bmp.setBlogId(blogId);
					bmp.setBmId(blogDTO.getId());
					bmp.setBpId(Integer.valueOf(permit.get("id").toString()));
					bmp.setCreateTime(new Date());
					bmp.setUpdateTime(new Date());
					bmpList.add(bmp);
					authorizes.add("ROLE_" + permit.get("authorize").toString());
				}
				
				blogManagerPermitService.insertBatch(bmpList);
				// 将权限标识更新到管理员信息中
				String authStr = String.join(",", authorizes.toArray(new String[authorizes.size()]));
				managerService.updateBlogManagerAuth(blogDTO.getId(),authStr);
				result.setStatus(true);
			} else {
				result.setStatus(false);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.setStatus(false);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	@Override
	public int updateBlogStatus(int blogId, int status) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		return blogMapper.updateStatus(blogId,status);
	}

	@Override
	public int updateBlogAuthStatus(int blogId, int authCode) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		return blogMapper.updateBlogAuthStatus(blogId,authCode);
	}

	@Override
	public BlogDetailVO queryBlogDetail(int id) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		return blogMapper.queryBlogDetail(id);
	}

	@Override
	public int getCountByNickName(String managerNickName) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		return blogMapper.getCountByNickName(managerNickName);
	}

	@Override
	public int getCountByMobile(String mobile) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		return blogMapper.getCountByMobile(mobile);
	}

	@Override
	public List<Map<String, Object>> querySignBlogList(BlogDTO blogDto, String pageNo, String perPageNo) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		
		Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
		paramMap.put("blogName", blogDto.getBlogName());
		paramMap.put("managerName", blogDto.getManagerName());
		paramMap.put("mobile", blogDto.getMobile());
		paramMap.put("blogType", blogDto.getBlogType());
		paramMap.put("blogStatus", blogDto.getBlogStatus());
		paramMap.put("authStatus", String.valueOf(BlogAuthStatus.CERTIFIED.getAuthCode()));
		
		List<BlogInfoVO> blogList = blogMapper.querySignBlogList(paramMap);
		List<Map<String, Object>> listResultMap = null;
        if (null != blogList && blogList.size() > 0) {
        	listResultMap = new ArrayList<>();
        	for (BlogInfoVO blogVO : blogList) {
        		Map<String, Object> resultMap = new HashMap<>();
        		String blogIdStr = IDEncryptor.getInstance().encryptWithoutException(blogVO.getBlogId());
        		resultMap.put("blogName", blogVO.getBlogName() == null ? "-" : blogVO.getBlogName());
        		resultMap.put("blogManagerName", blogVO.getBlogManagerName());
                resultMap.put("mobile", blogVO.getMobile());
                resultMap.put("blogType", BlogType.getBlogType(blogVO.getBlogType()).getMsg());
                resultMap.put("authStatus", BlogAuthStatus.getBlogAuthStatus(blogVO.getAuthStatus()).getMsg());
                resultMap.put("fansCount", blogVO.getFansCount());
                resultMap.put("subAccount", blogVO.getSubAccount());
                resultMap.put("blogStatus", CommonStatus.getCommonStatus(blogVO.getBlogStatus()).getDesc());
                
                List<Action> actions = new ArrayList<Action>();
                // 查看操作
                Action blogDetail = ActionFactory.build(ActionFactory.CATEGORY_LOOK, "/manager/blog/getBlogDtl?id=" + blogIdStr, ActionFactory.TARGET_SELF,
                		ActionFactory.OPTYPE_LINK,"",ActionFactory.REQ_TYPE_LINK, "");
                actions.add(blogDetail);
                
                // 查看操作
                Action auth = ActionFactory.build(ActionFactory.ALLOT_AUTH, "", "",
                        ActionFactory.OPTYPE_SCRIPT, "/manager/blogPermit/getAllPermission?id=" + blogIdStr, ActionFactory.REQ_TYPE_DIV, "blogRolePermit");
                actions.add(auth);
                
                
                // 博客状态：无效（启用） && 有效（禁用）
                if (blogVO.getBlogStatus() == CommonStatus.unAvailable.getStatus()) {
                	// 无效（启用）
                	Action uncertified = ActionFactory.build(ActionFactory.SYSUSER_ONLINE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blog/upOpenStatus?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upBlogStatusON");
                    actions.add(uncertified);
				} else {
					// 有效（禁用）
					Action certified = ActionFactory.build(ActionFactory.SYSUSER_OFFLINE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blog/upCloseStatus?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upBlogStatusOff");
                    actions.add(certified);
				}
                
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
			}
        }
		return listResultMap;
	}

	@Override
	public List<Map<String, Object>> queryUnSignBlogList(BlogDTO blogDto, String pageNo, String perPageNo) {
		SysBlogMapper blogMapper = writableSQLSession.getMapper(SysBlogMapper.class);
		
		Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
		paramMap.put("blogName", blogDto.getBlogName());
		paramMap.put("managerName", blogDto.getManagerName());
		paramMap.put("mobile", blogDto.getMobile());
		paramMap.put("blogType", blogDto.getBlogType());
		paramMap.put("blogStatus", blogDto.getBlogStatus());
		paramMap.put("authStatus", String.valueOf(BlogAuthStatus.UNCERTIFIED.getAuthCode()));
		
		List<BlogInfoVO> blogList = blogMapper.querySignBlogList(paramMap);
		List<Map<String, Object>> listResultMap = null;
        if (null != blogList && blogList.size() > 0) {
        	listResultMap = new ArrayList<>();
        	for (BlogInfoVO blogVO : blogList) {
        		Map<String, Object> resultMap = new HashMap<>();
        		String blogIdStr = IDEncryptor.getInstance().encryptWithoutException(blogVO.getBlogId());
        		resultMap.put("blogName", blogVO.getBlogName() == null ? "-" : blogVO.getBlogName());
        		resultMap.put("blogManagerName", blogVO.getBlogManagerName());
                resultMap.put("mobile", blogVO.getMobile());
                resultMap.put("blogType", BlogType.getBlogType(blogVO.getBlogType()).getMsg());
                resultMap.put("authStatus", BlogAuthStatus.getBlogAuthStatus(blogVO.getAuthStatus()).getMsg());
                resultMap.put("fansCount", blogVO.getFansCount());
                resultMap.put("subAccount", blogVO.getSubAccount());
                resultMap.put("blogStatus", CommonStatus.getCommonStatus(blogVO.getBlogStatus()).getDesc());
                
                List<Action> actions = new ArrayList<Action>();
                // 查看操作
                Action blogDetail = ActionFactory.build(ActionFactory.CATEGORY_LOOK, "/manager/blog/getBlogDtl?id=" + blogIdStr, ActionFactory.TARGET_SELF,
                		ActionFactory.OPTYPE_LINK,"",ActionFactory.REQ_TYPE_LINK, "");
                actions.add(blogDetail);
                
                // 未认证添加认证操作
                if (blogVO.getAuthStatus() == BlogAuthStatus.UNCERTIFIED.getAuthCode()) {
                	Action authentication = ActionFactory.build(ActionFactory.AUTHENTICATION, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blog/upOpenAuth?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "updateBlogAuth");
                    actions.add(authentication);
				}
                
                // 博客状态：无效（启用） && 有效（禁用）
                if (blogVO.getBlogStatus() == CommonStatus.unAvailable.getStatus()) {
                	// 无效（启用）
                	Action uncertified = ActionFactory.build(ActionFactory.SYSUSER_ONLINE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blog/upOpenStatus?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upBlogStatusON");
                    actions.add(uncertified);
				} else {
					// 有效（禁用）
					Action certified = ActionFactory.build(ActionFactory.SYSUSER_OFFLINE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blog/upCloseStatus?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upBlogStatusOff");
                    actions.add(certified);
				}
                
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
			}
        }
		return listResultMap;
	}
}
