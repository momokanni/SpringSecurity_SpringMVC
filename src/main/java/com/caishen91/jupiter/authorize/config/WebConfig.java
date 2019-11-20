package com.caishen91.jupiter.authorize.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.caishen91.jupiter.authorize.session.ExpiredSessionStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
@EnableWebMvc
@ComponentScan("com.caishen91.jupiter.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean 
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/webapp/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public ObjectMapper objectMapper() {
		
		return new ObjectMapper();
	}
	
	/**
	 * 	并发登录导致前一个session失效时的处理策略配置
	 * @return
	 */
	@Bean
	public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
		
		return new ExpiredSessionStrategy();
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
	
	//配置静态资源的处理  使DispatcherServlet对静态资源的请求转发到Servlet容器默认的Servlet上，而不是使用DispatcherServlet本身来处理此类请求
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);

		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);

		converters.add(fastConverter);
	}
}
