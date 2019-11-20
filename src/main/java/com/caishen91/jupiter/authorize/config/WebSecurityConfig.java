package com.caishen91.jupiter.authorize.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import com.alibaba.excel.util.StringUtils;
import com.caishen91.jupiter.authorize.access.BaseAccessDecisionManager;
import com.caishen91.jupiter.authorize.authentication.AdminAuthenticationConfig;
import com.caishen91.jupiter.authorize.authentication.BlogAuthenticationConfig;
import com.caishen91.jupiter.authorize.metadata.BaseFilterInvocationSecurityMetadataSource;
import com.caishen91.jupiter.authorize.properties.SecurityConstants;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.filter.GlobalFilter;

/**
 * 	springSecurity启动类及基础配置类
 * @author Administrator
 *
 */
@EnableWebSecurity
@Order(value = Integer.MIN_VALUE + 2)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	@Order(value = Integer.MIN_VALUE)
	@Configuration
	public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private AuthenticationEntryPoint baseAuthenticationEntryPoint;
		
		@Autowired
		private AccessDeniedHandler baseAccessDeniedHandler;
		
		@Autowired
		private AuthenticationSuccessHandler ownAuthenticationSuccessHandler;
		
		@Autowired
		private AuthenticationFailureHandler ownAuthenctiationFailureHandler;
		
		@Autowired
		private UserDetailsService administratorDetailsService;
		
		@Autowired
		private DataSource dataSourceWrite;
		
		@Autowired
		private BlogAuthenticationConfig blogAuthenticationConfig;
		
		@Autowired
		private AdminAuthenticationConfig adminAuthenticationConfig;
		
		@Autowired
		private LogoutSuccessHandler baseLogoutSuccessHandler;
		
		@Autowired
		private SessionInformationExpiredStrategy sessionStrategy;
		
		@Autowired
		private BaseFilterInvocationSecurityMetadataSource baseFilterInvocationSecurityMetadataSource;
		
		@Bean
		public AccessDecisionManager accessDecisionManager() {
			return new BaseAccessDecisionManager();
		}
		
		@Bean
		public PersistentTokenRepository persistentTokenRepository() {
			JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
			tokenRepository.setDataSource(dataSourceWrite);
			return tokenRepository;
		}
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.apply(adminAuthenticationConfig)
	        	.and()
	        	.apply(blogAuthenticationConfig)
	        	.and()
	        	.authorizeRequests().antMatchers(Config.DEBT_DOMAIN_LOGIN,SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM).permitAll().anyRequest().authenticated()
	        	.and()
	        	.formLogin().loginPage(Config.DEBT_DOMAIN_LOGIN).loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
	        		.successHandler(ownAuthenticationSuccessHandler)
	        		.failureHandler(ownAuthenctiationFailureHandler)
	        	.and()
	        	.authorizeRequests().anyRequest().authenticated()
	        	.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					@Override
					public <O extends FilterSecurityInterceptor> O postProcess(O object) {
						object.setAccessDecisionManager(accessDecisionManager());
						object.setSecurityMetadataSource(baseFilterInvocationSecurityMetadataSource);
			            return object;
					}
				})
	        	.and()
	        	.exceptionHandling().authenticationEntryPoint(baseAuthenticationEntryPoint).accessDeniedHandler(baseAccessDeniedHandler)
	        	.and()
	        	.logout().logoutUrl("/logout").logoutSuccessHandler(baseLogoutSuccessHandler).deleteCookies("JSESSIONID")
	        	.and()
	        	.sessionManagement()
	        		 // 防止篡改session
	        		.sessionFixation().migrateSession()
        			.invalidSessionUrl(Config.BM_DOMAIN_LOGIN)
        			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        			.maximumSessions(1)
        			.expiredSessionStrategy(sessionStrategy)
        		.and()
        		.and()
	        	.rememberMe()
	        	.tokenRepository(persistentTokenRepository())
	        	.tokenValiditySeconds(Config.TOKEN_VALIDITY_SECONDS)
	        	.userDetailsService(administratorDetailsService)
	        	.and()
	        	.csrf().disable()
	        	;
	        
	        http.addFilterBefore(new GlobalFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
		
		@Override
		public void configure(WebSecurity web) {
			String[] avoidUrl = StringUtils.commaDelimitedListToStringArray(Config.STATIC_AVOID_PATH);
			// 解决静态资源被拦截的问题
			logger.info("需要规避拦截的静态资源路径有: {}", Config.STATIC_AVOID_PATH);
			web.ignoring().antMatchers(avoidUrl);
		}
	}
	
	@Order(value = Integer.MIN_VALUE + 1)
	@Configuration
	public static class BlogSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private AuthenticationSuccessHandler ownAuthenticationSuccessHandler;
		
		@Autowired
		private AuthenticationFailureHandler ownAuthenctiationFailureHandler;
		
		@Autowired
		private DataSource dataSourceRead;
		
		@Autowired
		private UserDetailsService blogManagerDetailsService;
		
		@Autowired
		private BlogAuthenticationConfig blogAuthenticationConfig;
		
		@Autowired
		private LogoutSuccessHandler baseLogoutSuccessHandler;
		
		@Autowired
		private SessionInformationExpiredStrategy sessionStrategy;
		
		@Autowired
		private AdminAuthenticationConfig adminAuthenticationConfig;
		
		@Bean
		public AccessDecisionManager accessDecisionManager() {
			return new BaseAccessDecisionManager();
		}
		
		@Bean
		public PersistentTokenRepository repository() {
			JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
			tokenRepository.setDataSource(dataSourceRead);
			return tokenRepository;
		}
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.apply(blogAuthenticationConfig)
	        	.and()
	        	.apply(adminAuthenticationConfig)
	        	.and()
	        	.authorizeRequests().antMatchers(Config.BM_DOMAIN_LOGIN,SecurityConstants.BLOG_LOGIN_PROCESSING_URL_FORM).permitAll().anyRequest().authenticated()
	        	.and()
	        	.formLogin().loginPage(Config.BM_DOMAIN_LOGIN).loginProcessingUrl(SecurityConstants.BLOG_LOGIN_PROCESSING_URL_FORM)
	        		.successHandler(ownAuthenticationSuccessHandler)
	        		.failureHandler(ownAuthenctiationFailureHandler)
	        	.and()
	        	.authorizeRequests().anyRequest().authenticated()
	        	.and()
	        	.logout().logoutUrl("/logout").logoutSuccessHandler(baseLogoutSuccessHandler).deleteCookies("JSESSIONID")
	        	.and()
	        	.sessionManagement()
	        		.invalidSessionUrl(Config.BM_DOMAIN_LOGIN)
	        		.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	        		.maximumSessions(1)
	        		.expiredSessionStrategy(sessionStrategy)
	        	.and()
	        	.and()
	        	.rememberMe()
	        	.tokenRepository(repository())
	        	.tokenValiditySeconds(Config.TOKEN_VALIDITY_SECONDS)
	        	.userDetailsService(blogManagerDetailsService)
	        	.and()
	        	.csrf().disable()
	        	;
	    }
	}
	 
}
