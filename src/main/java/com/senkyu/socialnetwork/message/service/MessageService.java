package com.senkyu.socialnetwork.message.service;

import com.senkyu.socialnetwork.message.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getMessages(Long chatId);

    Message sendMessage(Long chatId, Long senderId, String content);
}
