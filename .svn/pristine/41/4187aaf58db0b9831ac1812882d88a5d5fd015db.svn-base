package com.caishen91.jupiter.authorize.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.caishen91.jupiter.authorize.enums.EnabledStatus;
import com.caishen91.jupiter.authorize.enums.LockStatus;
import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.exception.BaseAuthenticationException;
import com.caishen91.jupiter.authorize.model.AdminDetailsModel;
import com.caishen91.jupiter.dao.AdministratorDetailsMapper;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.impl.BaseService;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;

@Component(value = "administratorDetailsService")
@Transactional(rollbackFor = Exception.class)
public class AdministratorDetailsService extends BaseService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdministratorDetailsMapper mapper = writableSQLSession.getMapper(AdministratorDetailsMapper.class);
		SysUser administrator = mapper.loadAdminDetailsById(username);
		if(administrator == null) {
			throw new BaseAuthenticationException(ResultEnums.USER_NOT_EXISTS.getCode(),ResultEnums.USER_NOT_EXISTS.getMsg());
		} else {
			boolean enabled = EnabledStatus.getValue(administrator.getStatus());
			boolean lock = LockStatus.getValue(administrator.getLockStatus());
			String adminId = IDEncryptor.getInstance().encryptWithoutException(administrator.getId());
			String roleId = IDEncryptor.getInstance().encryptWithoutException(administrator.getRoleId());
			List<GrantedAuthority> authorizes = null;
			if(!StringUtil.isEmpty(administrator.getAuthorities())) {
				authorizes = AuthorityUtils.commaSeparatedStringToAuthorityList(administrator.getAuthorities());
			}
			AdminDetailsModel admin = new AdminDetailsModel(adminId,roleId,administrator.getLoginName(),administrator.getPasswd(),authorizes,true,lock,true,enabled);
			return admin;
		}
	}

}
