package com.socket.repo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.web.socket.WebSocketSession;

import com.socket.dto.ChatRoom;

@Repository
public class ChatRoomRepoImpl implements ChatRoomRepo {
	private final Map<String, ChatRoom> chatRoomMap;

	public ChatRoomRepoImpl() {
//		chatRoomMap = new HashMap<String, ChatRoom>();
//		chatRoomMap.put("room1", ChatRoom.create("room1", 2));
//		chatRoomMap.put("room2", ChatRoom.create("room2", 5));
//		chatRoomMap.put("room3", ChatRoom.create("room3", 10));
		chatRoomMap = Stream.of(ChatRoom.create("room1", 2), ChatRoom.create("room2", 5), ChatRoom.create("room3", 10))
				.collect(Collectors.toMap(ChatRoom::getId, Function.identity()));
	}

	@Override
	public void insert(ChatRoom chatRoom) {
		chatRoomMap.put(chatRoom.getId(), chatRoom);
	}

	@Override
	public ChatRoom read(String id) {
		return chatRoomMap.get(id);
	}

	@Override
	public Collection<ChatRoom> readAll() {
		return chatRoomMap.values();
	}

	@Override
	public void update(ChatRoom chatRoom) {
		chatRoomMap.put(chatRoom.getId(), chatRoom);
	}

	@Override
	public void delete(String id) {
		chatRoomMap.remove(id);
	}

	@Override
	public void removeSession(WebSocketSession session) {
		Collection<ChatRoom> chatRooms = chatRoomMap.values();
		for (ChatRoom room : chatRooms) {
			room.getSessions().remove(session);
		}
	}
}
