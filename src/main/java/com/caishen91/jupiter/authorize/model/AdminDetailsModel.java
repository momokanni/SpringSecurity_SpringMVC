package com.caishen91.jupiter.authorize.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 	系统管理-管理员实体
 * @author Administrator
 *
 */
public class AdminDetailsModel implements UserDetails {

	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String roleId;
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean lock;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	public AdminDetailsModel(String id,String roleId,String userName,String password,List<GrantedAuthority> authorities,boolean accountNonExpired,boolean lock,boolean credentialsNonExpired,boolean enabled) {
		this.id = id;
		this.roleId = roleId;
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.lock = lock;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return lock;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	@Override
	public boolean isEnabled() {

		return enabled;
	}
	
	public String getId() {
		return id;
	}

	public String getRoleId() {
		return roleId;
	}
	
}
