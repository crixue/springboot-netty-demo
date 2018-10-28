package com.xrj.netty;

import com.alibaba.fastjson.JSONObject;
import com.xrj.common.ServerResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 处理消息的handler
 * TextWebSocketFrame： 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 * @author crixue
 *
 */
public class CommentHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
	

	// 用于记录和管理所有客户端的channel
	public static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		String content = msg.text();
		
		Channel channel = ctx.channel();
		
		String json = JSONObject.toJSONString(ServerResponse.createBySucessResReturnData(content));
		users.writeAndFlush(new TextWebSocketFrame(json));
		
	}
	
	/**
	 * 当客户端连接服务端之后（打开连接）
	 * 获取客户端的channle，并且放到ChannelGroup中去进行管理
	 */
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		users.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		String channelId = ctx.channel().id().asShortText();
		System.out.println("客户端被移除，channelId为：" + channelId);
		
		// 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
		users.remove(ctx.channel());
	}

}
