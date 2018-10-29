package com.xrj.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

	private static final int READ_IDEL_TIME_OUT = 8; // 读超时
	private static final int WRITE_IDEL_TIME_OUT = 10;// 写超时
	private static final int ALL_IDEL_TIME_OUT = 0; // 所有超时

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		/************************ 支持http协议 **************************/
		// http编解码
		pipeline.addLast(new HttpServerCodec());
		// 支持大数据流传输
		pipeline.addLast(new ChunkedWriteHandler());
		// 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse，几乎在netty中的编程，都会使用到此hanler
		pipeline.addLast(new HttpObjectAggregator(1024 * 60));

		/************************ 支持httpWebsocket **************************/
		/**
		 * websocket 服务器处理的协议，用于指定给客户端连接访问的路由 : /ws 本handler会帮你处理一些繁重的复杂的事 会帮你处理握手动作：
		 * handshaking（close, ping, pong） ping + pong = 心跳
		 * 对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
		 */
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

		/************************ 支持心跳检测 **************************/
		// 针对客户端，如果在1分钟时没有向服务端发送读写心跳(ALL)，则主动断开
		// 如果是读空闲或者写空闲，不处理
		pipeline.addLast(new IdleStateHandler(READ_IDEL_TIME_OUT, WRITE_IDEL_TIME_OUT, ALL_IDEL_TIME_OUT));
		pipeline.addLast(new HeartBeatHandler());

		// 自定义handler
		pipeline.addLast(new CommentHandler());
	}

}
