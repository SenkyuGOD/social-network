package com.senkyu.socialnetwork.chat.service.impl;

import com.senkyu.socialnetwork.chat.model.Chat;
import com.senkyu.socialnetwork.chat.repository.ChatRepository;
import com.senkyu.socialnetwork.chat.service.ChatService;
import com.senkyu.socialnetwork.user.model.User;
import com.senkyu.socialnetwork.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatServiceImpl(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Chat createChat(Long userOneId, Long userTwoId) {
        User userOne = userRepository.findById(userOneId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        User userTwo = userRepository.findById(userTwoId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Chat chat = new Chat();
        chat.setUserOne(userOne);
        chat.setUserTwo(userTwo);


        return chatRepository.save(chat);
    }

    @Override
    public Optional<Chat> FindChatBetweenUsers(Long userOneId, Long userTwoId) {
        return chatRepository.findChatByUsersIds(userOneId, userTwoId);
    }

    @Override
    public List<Chat> GetUsersChats(Long userId) {
        return chatRepository.findAllByUsersId(userId);
    }


}
