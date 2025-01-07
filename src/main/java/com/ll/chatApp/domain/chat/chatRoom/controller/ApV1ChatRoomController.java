package com.ll.chatApp.domain.chat.chatRoom.controller;

import com.ll.chatApp.domain.chat.chatRoom.dto.RequestCreateRoom;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/rooms")
@CrossOrigin(origins = "https://cdpn.io")
public class ApV1ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping
    public List<ChatRoom> getChatRooms() {
        List<ChatRoom> chatRooms  = chatRoomService.getAll();
        return chatRooms;
    }

    @GetMapping("/api/v1/chat/rooms/{roomId}")
    public ChatRoom getChatRoom(@PathVariable("roomId") Long roomId) {
        ChatRoom chatRoom = chatRoomService.getChatRoom(roomId);
        return chatRoom;
    }

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody RequestCreateRoom requestCreateRoom) {
        ChatRoom chatRoom = chatRoomService.create(requestCreateRoom.getName());
        return chatRoom;
    }
}
