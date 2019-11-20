package com.caishen91.jupiter.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.caishen91.jupiter.authorize.config.WebSecurityConfig;
import com.caishen91.jupiter.dao.BlogManagerPermitMapper;
import com.caishen91.jupiter.dao.BlogPermitMapper;
import com.caishen91.jupiter.model.BaseAuthTree;
import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.model.BlogPermit;
import com.caishen91.jupiter.model.SubBmAuthTree;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.util.TreeUtil;

@Service
public class BlogPermitServiceImpl extends BaseService implements IBlogPermitService{
	
	private static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Override
	public List<Map<String, Object>> getCompanyDefaultPermit() {
		BlogPermitMapper blogPermitMapper = writableSQLSession.getMapper(BlogPermitMapper.class);
		return blogPermitMapper.getCompanyDefaultPermit();
	}

	@Override
	public List<Map<String, Object>> getPersonalDefaultPermit() {
		BlogPermitMapper blogPermitMapper = writableSQLSession.getMapper(BlogPermitMapper.class);
		return blogPermitMapper.getPersonalDefaultPermit();
	}

	@Override
	public BlogPermit getBlogPermitByUrl(String url) {
		BlogPermitMapper blogPermitMapper = writableSQLSession.getMapper(BlogPermitMapper.class);
		return blogPermitMapper.getBlogPermitByUrl(url);
	}

	/**
	 * 	组装商户端菜单树
	 */
	@Override
	public List<BlogMenuTree> getMenu(int blogId, int bmId) {
		BlogPermitMapper blogPermitMapper = writableSQLSession.getMapper(BlogPermitMapper.class);
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		/**
		 * 	1.  查出当前登录管理员所拥有的权限
		 * 	2.  再通过权限表【权限类型】获取菜单
		 * 	3.  将菜单组装成tree,并返回
		 */
		Set<String> bmpList = blogManagerPermitMapper.getBlogPermission(blogId, bmId);
		if(bmpList == null || bmpList.size() == 0) {
			return null;
		}
		// 将当前登录管理员所拥有的权限集合转换成以逗号分隔的字符串
		String authorizeStr = String.join(",", bmpList.toArray(new String[bmpList.size()]));
		List<BlogMenuTree> menuTree = blogPermitMapper.getMenuTreeByIds(authorizeStr);
		try {
			menuTree = TreeUtil.getTree(menuTree, "id");
		} catch (Exception e) {
			menuTree = null;
			logger.error(e.getMessage());
		}
		return menuTree;
	}

	@Override
	public List<SubBmAuthTree> getBmAuth(int bmId, int normalManagerId, int blogId) {
		BlogPermitMapper blogPermitMapper = writableSQLSession.getMapper(BlogPermitMapper.class);
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		/**
		 * 	1.  查出当前登录管理员所拥有的权限
		 * 	2.  再通过权限表【权限类型】获取菜单
		 * 	3.  将菜单组装成tree,并返回
		 */
		Set<String> bmpList = blogManagerPermitMapper.getBlogPermission(blogId, bmId);
		// 将当前登录管理员所拥有的权限集合转换成以逗号分隔的字符串
		String authorizeStr = String.join(",", bmpList.toArray(new String[bmpList.size()]));
		List<SubBmAuthTree> menuTree = blogPermitMapper.getBmAuthByIds(authorizeStr);
		
		Set<String> allReadyPermissions = blogManagerPermitMapper.getSuperManagerAuthPermission(normalManagerId, blogId);
		try {
			menuTree = TreeUtil.getTree(menuTree, "id");
			for (String permission : allReadyPermissions) {
				for (SubBmAuthTree tree : menuTree) {
					int transPermission = Integer.valueOf(permission);
					int transId = Integer.valueOf(tree.getId());
					if(transPermission == transId && tree.getChildren() == null) {
						tree.setChecked(true);
					}
					childCheck((List<SubBmAuthTree>) tree.getChildren(),permission);
				}
			}

		} catch (Exception e) {
			menuTree = null;
			logger.error(e.getMessage());
		}
		return menuTree;
	}

	private void childCheck(List<? extends BaseAuthTree> children,String permission) {
		for (SubBmAuthTree child : (List<SubBmAuthTree>) children) {
			int transPermission = Integer.valueOf(permission);
			int transId = Integer.valueOf(child.getId());
			if(transPermission == transId && child.getChildren() == null ) {
				child.setChecked(true);
			} else if (transPermission == transId && child.getChildren() != null ) {
				childCheck((List<SubBmAuthTree>) child.getChildren(),permission);
			} else if (transPermission != transId && child.getChildren() != null ) {
				childCheck((List<SubBmAuthTree>) child.getChildren(),permission);
			}
		}
	}
}
