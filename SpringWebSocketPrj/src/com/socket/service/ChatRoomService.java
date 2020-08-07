package com.socket.service;

import java.util.List;

import com.socket.dto.ChatRoom;

public interface ChatRoomService {
	public void insertChatRoom(ChatRoom chatRoom);

	public List<ChatRoom> getChatRoomList();

	public ChatRoom getChatRoom(String id);

	public void updateChatRoom(ChatRoom chatRoom);

	public void deleteChatRoom(String id);
}
