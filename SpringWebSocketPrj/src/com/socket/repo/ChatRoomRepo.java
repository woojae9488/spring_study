package com.socket.repo;

import java.util.Collection;

import org.springframework.web.socket.WebSocketSession;

import com.socket.dto.ChatRoom;

public interface ChatRoomRepo {
	public void insert(ChatRoom chatRoom);

	public ChatRoom read(String id);

	public Collection<ChatRoom> readAll();

	public void update(ChatRoom chatRoom);

	public void delete(String id);
	
	public void removeSession(WebSocketSession session);
}
