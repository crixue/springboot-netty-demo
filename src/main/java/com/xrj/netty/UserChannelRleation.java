package com.xrj.netty;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.Channel;

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
			System.out.println("UserId: " + entry.getKey() 
							+ ", ChannelId: " + entry.getValue().id().asLongText());
		}
	}
	
}
