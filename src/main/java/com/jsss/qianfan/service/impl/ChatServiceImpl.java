package com.jsss.qianfan.service.impl;

import com.jsss.qianfan.dao.ChatMapper;
import com.jsss.qianfan.entity.Conversation;
import com.jsss.qianfan.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatMapper;

    @Override
    public void addChat(Conversation conversation) {
        chatMapper.insert(conversation);
    }

    @Override
    public List<Conversation> searchByUsername(String username) {
        return chatMapper.getByUsername(username);
    }
}
