package com.socket.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.socket.dto.ChatMessage;
import com.socket.dto.ChatRoom;
import com.socket.repo.ChatRoomRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile("!stomp")
@Service
public class ChatHandler extends TextWebSocketHandler {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ChatRoomRepo chatRoomRepo;

	public void afterConnectionEstablished(WebSocketSession session) {
		log.info("session connected : {}", session.toString());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("payload : {}", payload);
		ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
		ChatRoom chatRoom = chatRoomRepo.read(chatMessage.getChatRoomId());
		chatRoom.handleMessage(session, chatMessage, objectMapper);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("session disconnected : {}", session.toString());
		chatRoomRepo.removeSession(session);
	}
}
