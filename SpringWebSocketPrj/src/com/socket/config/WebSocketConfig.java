package com.socket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.sockjs.frame.Jackson2SockJsMessageCodec;

import com.socket.service.ChatHandler;

@Profile("!stomp")
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	@Autowired
	private ChatHandler chatHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatHandler, "/ws/chat").setAllowedOrigins("*").withSockJS();
	}
}
