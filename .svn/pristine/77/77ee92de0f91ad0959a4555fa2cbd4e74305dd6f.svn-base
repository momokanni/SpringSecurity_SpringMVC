package com.caishen91.jupiter.authorize.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component(value = "blogAuthenticationConfig")
public class BlogAuthenticationConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private AuthenticationSuccessHandler ownAuthenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler ownAuthenctiationFailureHandler;
	
	@Autowired
	private UserDetailsService blogManagerDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(HttpSecurity builder) throws Exception {
		/**
		 * 	配置商户端登录
		 */
		BlogUserNamePasswordAuthenticationFilter filter = new BlogUserNamePasswordAuthenticationFilter();
		filter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
		filter.setAuthenticationSuccessHandler(ownAuthenticationSuccessHandler);
		filter.setAuthenticationFailureHandler(ownAuthenctiationFailureHandler);
		
		BlogUserNamePasswordAuthenticationProvider provider = new BlogUserNamePasswordAuthenticationProvider();
		provider.setBlogManagerDetailsService(blogManagerDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		
		builder.authenticationProvider(provider)
			   .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);
		
	}
}
