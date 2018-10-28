package com.xrj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages="com.xrj.netty")
@ComponentScan(basePackages="com.xrj")
public class NettyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettyApplication.class, args);
	}
}
