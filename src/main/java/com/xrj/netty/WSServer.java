package com.xrj.netty;

import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Component
public class WSServer {
	
	private EventLoopGroup mainGroup;
	private EventLoopGroup subGroup;
	private ServerBootstrap bootstrap;
	private ChannelFuture future;
	
	private static class SingletonWSServer {
		static final WSServer instance = new WSServer();
	}
	
	public static WSServer getInstance() {
		return SingletonWSServer.instance;
	}
	
	public WSServer() {
		mainGroup = new NioEventLoopGroup();
		subGroup = new NioEventLoopGroup();
		bootstrap = new ServerBootstrap();
		bootstrap.group(mainGroup, subGroup)
					   .channel(NioServerSocketChannel.class)
					   .childHandler(new ServerInitializer());
	}

	public void start() {
		this.future = bootstrap.bind(12013);
		System.out.println("WSServer 服务启动完毕...");
	}
	
}
