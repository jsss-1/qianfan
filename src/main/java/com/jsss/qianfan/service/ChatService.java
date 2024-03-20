package com.jsss.qianfan.service;

import com.jsss.qianfan.entity.Conversation;

import java.util.List;

public interface ChatService {

    void addChat(Conversation conversation);

    List<Conversation> searchByUsername(String username);

}
