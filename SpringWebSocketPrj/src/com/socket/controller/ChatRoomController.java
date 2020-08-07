package com.socket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socket.dto.ChatRoom;
import com.socket.service.ChatRoomService;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {
	@Autowired
	private ChatRoomService service;
	private final AtomicInteger seq = new AtomicInteger(0);

	@PostMapping(value = "/rooms", headers = { "Content-type=application/json" })
	public Map<String, Object> insertRoom(@RequestBody String name, @RequestBody int size) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.insertChatRoom(ChatRoom.create(name, size));
		result.put("result", Boolean.TRUE);
		return result;
	}

	@GetMapping("/rooms")
	public Map<String, Object> getRooms() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ChatRoom> chatRooms = service.getChatRoomList();
		result.put("result", Boolean.TRUE);
		result.put("rooms", chatRooms);
		return result;
	}

	@GetMapping("/rooms/{id}")
	public Map<String, Object> getRoom(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		ChatRoom chatRoom = service.getChatRoom(id);
		result.put("result", Boolean.TRUE);
		result.put("room", chatRoom);
		result.put("member", "member" + seq.incrementAndGet());
		return result;
	}

	@PutMapping(value = "/rooms", headers = { "Content-type=application/json" })
	public Map<String, Object> updateRoom(@RequestBody String name, @RequestBody int size) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.updateChatRoom(ChatRoom.create(name, size));
		result.put("result", Boolean.TRUE);
		return result;
	}

	@DeleteMapping("/rooms/{id}")
	public Map<String, Object> deleteRoom(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.deleteChatRoom(id);
		result.put("result", Boolean.TRUE);
		return result;
	}
}
