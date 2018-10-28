package com.xrj;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.xrj.netty.WSServer;

@Component
public class NettyBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			try {
				WSServer.getInstance().start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
