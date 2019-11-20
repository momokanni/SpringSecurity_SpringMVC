package com.caishen91.jupiter.authorize.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.authorize.properties.SecurityConstants;

/**
 * 	系统管理登录验证逻辑提供者
 * @author Administrator
 *
 */
@Component(value = "blogUserNamePasswordAuthenticationProvider")
public class BlogUserNamePasswordAuthenticationProvider implements AuthenticationProvider {
	
	private UserDetailsService blogManagerDetailsService;
	
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String userName = token.getPrincipal().toString();
		if(userName.startsWith(SecurityConstants.SYSTEM_ADMINISTRATOR_PREFIX)) {
			throw new InternalAuthenticationServiceException("用户不存在");
		}
		
		BlogManagerDetailsModel user = (BlogManagerDetailsModel) blogManagerDetailsService.loadUserByUsername(userName);
		if(user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		
		if(!user.isEnabled()) {
			throw new DisabledException("请激活账户");
		}
		
		if(!user.isAccountNonLocked()) {
			throw new DisabledException("请认证后登录");
		}
		
		if(this.passwordEncoder.matches(token.getCredentials().toString(), user.getPassword())) {
			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
			result.setDetails(token.getDetails());
			return result;
		} else {
			throw new BadCredentialsException("密码不正确");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	public void setBlogManagerDetailsService(UserDetailsService blogManagerDetailsService) {
		this.blogManagerDetailsService = blogManagerDetailsService;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
}
