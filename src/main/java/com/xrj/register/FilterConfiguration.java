package com.xrj.register;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import com.xrj.filter.JwtAuthenticationTokenFilter;

@Configuration
public class FilterConfiguration {
	
	@Bean
	public FilterRegistrationBean<OncePerRequestFilter> jwtAuthenticationTokenFilterBean() {
		FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtAuthenticationTokenFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
		registrationBean.setName("jwtAuthenticationTokenFilterBean have inited....");
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<OncePerRequestFilter> deviceTokenFilterFilterBean() {
		FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtAuthenticationTokenFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE + 1);
		registrationBean.setName("deviceTokenFilterFilterBean have inited....");
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean<OncePerRequestFilter> processTokenFilterBean() {
		FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtAuthenticationTokenFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE + 2);
		registrationBean.setName("processTokenFilterBean have inited....");
		return registrationBean;
	}
}
