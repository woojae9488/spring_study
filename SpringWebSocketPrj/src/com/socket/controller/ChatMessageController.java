package com.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.socket.dto.ChatMessage;

@Controller
public class ChatMessageController {
	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/chat/join")
	public void join(ChatMessage message) {
		message.setMessage(message.getWriter() + " was join this room.");
		template.convertAndSend("/subscribe/chat/room/" + message.getChatRoomId(), message);
	}

	@MessageMapping("/chat/message")
	public void message(ChatMessage message) {
		template.convertAndSend("/subscribe/chat/room/" + message.getChatRoomId(), message);
	}
}
