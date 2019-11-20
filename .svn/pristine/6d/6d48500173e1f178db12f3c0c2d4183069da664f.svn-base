package com.caishen91.jupiter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.caishen91.jupiter.dao.BlogManagerPermitMapper;
import com.caishen91.jupiter.dao.BlogPermitMapper;
import com.caishen91.jupiter.dao.SysBlogManagerMapper;
import com.caishen91.jupiter.enums.BlogManagerType;
import com.caishen91.jupiter.model.AuthTree;
import com.caishen91.jupiter.model.BlogManagerPermit;
import com.caishen91.jupiter.model.BlogPermit;
import com.caishen91.jupiter.service.IBlogManagerPermitService;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.TreeUtil;

@Service
public class BlogManagerPermitServiceImpl extends BaseService implements IBlogManagerPermitService{

	@Override
	public void insertBatch(List<BlogManagerPermit> bmpList) {
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		blogManagerPermitMapper.insertBatch(bmpList);
	}

	@Override
	public String getAllPermission(int blogId) {
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		BlogPermitMapper blogPermitMapper = writableSQLSession.getMapper(BlogPermitMapper.class);
		SysBlogManagerMapper blogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		
		List<AuthTree> permissions = blogPermitMapper.getAllPermission();
		// 根据商户号查询超级管理员ID
		int adminId = blogManagerMapper.getBmIdByBlogId(blogId,BlogManagerType.ADMIN.getType());
		Set<String> havedList = blogManagerPermitMapper.getBlogPermission(blogId,adminId);
		for (String havePermitId : havedList) {
			for (AuthTree permission : permissions) {
				if(permission.getId().equals(havePermitId)) {
					permission.setChecked(true);
				}
			}
		}
		try {
			List<AuthTree> tree = TreeUtil.getTree(permissions, "id");
			return JSON.toJSONString(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 	给管理员赋权
	 */
	@Transactional(rollbackOn = {Exception.class})
	@Override
	public void updateBlogAuth(int blogId,int bmId, Object[] blogPermitId) {
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		SysBlogManagerMapper sysBlogManagerMapper = writableSQLSession.getMapper(SysBlogManagerMapper.class);
		BlogPermitMapper blogPermitMapper = writableSQLSession.getMapper(BlogPermitMapper.class);
		
		String authStr = String.join(",", (String[])blogPermitId);
		List<BlogPermit> bpList = blogPermitMapper.getPermitById(authStr);
		
		List<String> authorizes = null;
        List<BlogManagerPermit> rpList = null;
        if (null != blogPermitId && blogPermitId.length > 0) {
        	rpList = new ArrayList<BlogManagerPermit>();
        	authorizes = new ArrayList<String>();
            for (BlogPermit bp : bpList) {
            	BlogManagerPermit blogManagerPermit = new BlogManagerPermit();
            	blogManagerPermit.setBmId(bmId);
            	blogManagerPermit.setBlogId(blogId);
            	blogManagerPermit.setBpId(bp.getId());
            	blogManagerPermit.setCreateTime(new Date());
            	blogManagerPermit.setUpdateTime(new Date());
                rpList.add(blogManagerPermit);
                authorizes.add("ROLE_" + bp.getAuthorize());
            }
        }
        blogManagerPermitMapper.revocationBlogManagerAuthAll(blogId,bmId);
        blogManagerPermitMapper.updateBlogManagerPermit(rpList);
        // 跟新管理员权限标识
        String authorizeStr = String.join(",", authorizes.toArray(new String[authorizes.size()]));
        sysBlogManagerMapper.updateBlogManagerAuth(bmId,authorizeStr);
	}

	@Override
	public Set<String> getManagerAuthPermission(int managerId, int blogId) {
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		return blogManagerPermitMapper.getSuperManagerAuthPermission(managerId,blogId);
	}

	@Override
	public void removeAllPermissionByBmIdAndBlogId(int managerId, int blogId) {
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		blogManagerPermitMapper.revocationBlogManagerAuthAll(blogId,managerId);
	}

	@Override
	public Set<String> getBmPermission(String bmId, String blogId) {
		BlogManagerPermitMapper blogManagerPermitMapper = writableSQLSession.getMapper(BlogManagerPermitMapper.class);
		int mId = IDEncryptor.getInstance().decryptWithoutException(bmId);
		int bId = IDEncryptor.getInstance().decryptWithoutException(blogId);
		return blogManagerPermitMapper.getBmPermission(mId,bId);
	}
}
