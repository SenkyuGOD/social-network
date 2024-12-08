package com.senkyu.socialnetwork.chat.service;

import com.senkyu.socialnetwork.chat.model.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    Chat createChat(Long userOneId, Long userTwoId);

    Optional<Chat> FindChatBetweenUsers (Long userOneId, Long userTwoId);

    List<Chat> GetUsersChats(Long userId);
}
