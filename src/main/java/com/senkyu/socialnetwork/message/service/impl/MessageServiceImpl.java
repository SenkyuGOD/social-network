package com.senkyu.socialnetwork.message.service.impl;

import com.senkyu.socialnetwork.chat.model.Chat;
import com.senkyu.socialnetwork.chat.repository.ChatRepository;
import com.senkyu.socialnetwork.message.model.Message;
import com.senkyu.socialnetwork.message.repository.MessageRepository;
import com.senkyu.socialnetwork.message.service.MessageService;
import com.senkyu.socialnetwork.user.model.User;
import com.senkyu.socialnetwork.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public MessageServiceImpl(MessageRepository messageRepository, ChatRepository chatRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Message> getMessages(Long chatId) {
        return messageRepository.findByChat_Id(chatId);
    }

    @Override
    public Message sendMessage(Long chatId, Long senderId, String content) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new IllegalArgumentException("Chat not found"));

        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Message message = new Message();
        message.setChat(chat);
        message.setSender(sender);
        message.setContent(content);
        return messageRepository.save(message);
    }


}
