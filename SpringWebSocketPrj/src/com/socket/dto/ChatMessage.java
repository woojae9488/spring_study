package com.socket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {
	private String chatRoomId;
	private String writer;
	private String message;
	private MessageType type;
}

enum MessageType {
	JOIN("join"), CHAT("chat"), EXIT("exit");

	private String type;

	MessageType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
