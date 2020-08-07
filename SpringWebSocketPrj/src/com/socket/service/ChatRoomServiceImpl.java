package com.socket.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socket.dto.ChatRoom;
import com.socket.repo.ChatRoomRepoImpl;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
	@Autowired
	private ChatRoomRepoImpl repo;

	@Override
	public void insertChatRoom(ChatRoom chatRoom) {
		repo.insert(chatRoom);
	}

	@Override
	public List<ChatRoom> getChatRoomList() {
		Collection<ChatRoom> chatRooms = repo.readAll();
		List<ChatRoom> chatRoomList;
		if (chatRooms instanceof List) {
			chatRoomList = (List<ChatRoom>) chatRooms;
		} else {
			chatRoomList = new ArrayList<ChatRoom>(chatRooms);
		}
		return chatRoomList;
	}

	@Override
	public ChatRoom getChatRoom(String id) {
		return repo.read(id);
	}

	@Override
	public void updateChatRoom(ChatRoom chatRoom) {
		repo.update(chatRoom);
	}

	@Override
	public void deleteChatRoom(String id) {
		repo.delete(id);
	}
}
