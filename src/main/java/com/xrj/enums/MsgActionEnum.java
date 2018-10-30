package com.xrj.enums;

public enum MsgActionEnum {

	CONNECT(1, "第一次(或重连)初始化连接"),
	COMMENT(2, "评论消息"),	
	KEEPALIVE(3, "客户端保持心跳");
	
	public final Integer type;
	public final String content;
	
	MsgActionEnum(Integer type, String content){
		this.type = type;
		this.content = content;
	}
	
	public Integer getType() {
		return type;
	}
}
