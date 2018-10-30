package com.xrj.netty;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserChannelRleation {

	private static Map<String, Channel> manager = new HashMap<>();
	
	public static void put(String senderId, Channel channel) {
		manager.put(senderId, channel);
	}
	
	public static Channel get(String senderId) {
		return manager.get(senderId);
	}
	
	public static void output() {
		for (HashMap.Entry<String, Channel> entry : manager.entrySet()) {
			log.debug("UserId:{}, ChannelId:{}", entry.getKey(), entry.getValue().id().asLongText());
		}
	}
	
}
