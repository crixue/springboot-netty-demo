package com.xrj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.xrj.util.SpringUtil;

import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages="com.xrj.netty")
@ComponentScan(basePackages="com.xrj")
@ServletComponentScan  //Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册
@EnableCaching
public class NettyApplication {

	@Bean
	public SpringUtil getSpringUtil() {
		return new SpringUtil();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NettyApplication.class, args);
	}
}
