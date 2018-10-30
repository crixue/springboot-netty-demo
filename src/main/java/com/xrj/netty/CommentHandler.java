package com.xrj.netty;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.xrj.common.ServerResponse;
import com.xrj.enums.MsgActionEnum;
import com.xrj.pojo.User;
import com.xrj.service.CommentService;
import com.xrj.service.UserService;
import com.xrj.util.JwtTokenUtil;
import com.xrj.util.JwtUser;
import com.xrj.util.SpringUtil;
import com.xrj.vo.CommentVO;

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
		CommentService commentService = SpringUtil.getBean("commentService", CommentService.class);
		UserService userService = SpringUtil.getBean("userService", UserService.class);
		String content = msg.text();
		
		Channel channel = ctx.channel();
		
		//解析用户的消息
		CommentVO commentVO = null;
		User user = null;
		if (StringUtils.isNotBlank(content)) {
			commentVO = JSONObject.parseObject(content, CommentVO.class);
			String userUuid = StringUtils.EMPTY;
			if (StringUtils.isNotBlank(commentVO.getAuthToken())) {
				String authToken = commentVO.getAuthToken();
				JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
				JwtUser jwtUser = jwtTokenUtil.getJwtUser(authToken);
				if (jwtUser != null) {
					userUuid = jwtUser.getUuid();
					
					user = userService.getUserByUuid(userUuid);
					commentVO.setUserUuid(userUuid);
					BeanUtils.copyProperties(user, commentVO);
				}
			}
			
			String randomUuid = UUID.randomUUID().toString();
			if (commentVO.getActionType() == MsgActionEnum.CONNECT.getType()) {  //初次连接建立关系
				UserChannelRleation.put(userUuid == null ? randomUuid : userUuid,
						channel);
				UserChannelRleation.output();
				
			} else if (commentVO.getActionType() == MsgActionEnum.COMMENT.getType()) {  //用户发评论
				commentVO.setUuid(randomUuid);
				commentVO.setAddTime(new Date());
				int ret = commentService.insertComment(commentVO);
				if (ret == 0) { //TODO
					
				}
				
			}
			
		} else {
			commentVO = new CommentVO();
		}
		commentVO.setCurrentUserNums(users.size());
		
		String json = JSONObject.toJSONString(ServerResponse.createBySucessResReturnData(commentVO));
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
