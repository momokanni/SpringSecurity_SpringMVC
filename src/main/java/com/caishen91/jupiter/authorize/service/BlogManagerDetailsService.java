package com.caishen91.jupiter.authorize.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.caishen91.jupiter.authorize.enums.BlogEnabledStatus;
import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.exception.BaseAuthenticationException;
import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.dao.BlogManagerDetailsMapper;
import com.caishen91.jupiter.dao.BlogMapper;
import com.caishen91.jupiter.enums.BlogAuthStatus;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.impl.BaseService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;

@Component(value = "blogManagerDetailsService")
@Transactional(rollbackFor = Exception.class)
public class BlogManagerDetailsService extends BaseService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BlogMapper blogMapper = writableSQLSession.getMapper(BlogMapper.class);
		BlogManagerDetailsMapper mapper = writableSQLSession.getMapper(BlogManagerDetailsMapper.class);
		/**
		 * 	1.  查询管理员
		 * 	2.  查询对应的商户号
		 * 	3.  验证管理员和商户状态	
		 */
		BlogManager manager = null;
		if(CommonUtil.isMobile(username)) {
			manager = mapper.loadBlogManagerDetailsByMobile(username);
		} else {
			manager = mapper.loadBlogManagerDetailsByName(username);
		}
		if(manager == null) {
			throw new BaseAuthenticationException(ResultEnums.USER_NOT_EXISTS.getCode(),ResultEnums.USER_NOT_EXISTS.getMsg());
		} else {
			Blog blog = blogMapper.getBlogById(manager.getBlogId());
			if(blog != null) {
				boolean enabled = BlogEnabledStatus.getValue(manager.getStatus());
				boolean lock = BlogAuthStatus.getValue(blog.getAuthStatus());
				String bmId = IDEncryptor.getInstance().encryptWithoutException(manager.getId());
				String blogId = IDEncryptor.getInstance().encryptWithoutException(manager.getBlogId());
				List<GrantedAuthority> authorizes = null;
				if(!StringUtil.isEmpty(manager.getAuthorities())) {
					authorizes = AuthorityUtils.commaSeparatedStringToAuthorityList(manager.getAuthorities());
				}
				BlogManagerDetailsModel bm = new BlogManagerDetailsModel(bmId,blogId,manager.getName(),manager.getPassword(),authorizes,true,lock,true,enabled);
				return bm;
			}
			return null;
		}
	}

}
