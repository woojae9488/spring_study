package com.socket.dto;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class ChatRoom {
	private String id;
	private String name;
	private int size;
	private Set<WebSocketSession> sessions = new HashSet<>();

	public static ChatRoom create(@NonNull String name, int size) {
		ChatRoom room = new ChatRoom();
		room.id = UUID.randomUUID().toString();
		room.name = name;
		room.size = size;
		return room;
	}

	public void join(WebSocketSession session) {
		sessions.add(session);
	}

	public void handleMessage(WebSocketSession session, ChatMessage chatMessage, ObjectMapper objectMapper) {
		if (chatMessage.getType() == MessageType.JOIN) {
			join(session);
			chatMessage.setMessage(chatMessage.getWriter() + "was join this room.");
		}
		broadcast(chatMessage, objectMapper);
	}

	public <T> void broadcast(T messageObject, ObjectMapper objectMapper) {
		try {
			TextMessage message = new TextMessage(objectMapper.writeValueAsString(messageObject));
			sessions.parallelStream().forEach(session -> {
				try {
					session.sendMessage(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
