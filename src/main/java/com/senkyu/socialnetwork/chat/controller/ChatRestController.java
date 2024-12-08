package com.senkyu.socialnetwork.chat.controller;

import com.senkyu.socialnetwork.chat.model.Chat;
import com.senkyu.socialnetwork.chat.service.ChatService;
import com.senkyu.socialnetwork.message.model.Message;
import com.senkyu.socialnetwork.message.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    private final ChatService chatService;
    private final MessageService messageService;

    public ChatRestController(ChatService chatService, MessageService messageService) {
        this.chatService = chatService;
        this.messageService = messageService;
    }

    @PostMapping
    public Chat createChat(@RequestParam Long userOneId, @RequestParam Long userTwoId) {
        return chatService.createChat(userOneId, userTwoId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserChats(@PathVariable Long userId) {
        List<Chat> chats = chatService.GetUsersChats(userId);

        if(chats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(chats);
    }

    @GetMapping("/{chatId}/messages")
    public List<Message> getMessages(@PathVariable Long chatId) {
        return messageService.getMessages(chatId);
    }

    @PostMapping("/{chatId}/messages")
    public Message sendMessage(
            @PathVariable Long chatId,
            @RequestParam Long senderId,
            @RequestParam String content) {
        return messageService.sendMessage(chatId, senderId, content);
    }
}

