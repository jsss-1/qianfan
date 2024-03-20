package com.jsss.qianfan.controller;

import com.jsss.qianfan.entity.Conversation;
import com.jsss.qianfan.service.ChatService;
import com.jsss.qianfan.util.QianfanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("chat")
public class ChatController {




//    List<Conversation> conversations=new ArrayList<>();
//
//    static int id=1;
//
//    {
//        conversations.add(new Conversation(id++,"1","你好","抱歉，网络出现异常，请你重试或联系客服！TooManyRequests", format(new Date())));
//        conversations.add(new Conversation(id++,"1","你好","抱歉，网络出现异常，请你重试或联系客服！TooManyRequests", format(new Date())));
//    }

    @Autowired
    QianfanUtil qianfanUtil;

    @Autowired
    ChatService chatService;

    private String format(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }



    @GetMapping("/list")
    public String getChat(HttpServletRequest request,Model model){
        String username= (String) request.getSession().getAttribute("username");
        List<Conversation> conversations=chatService.searchByUsername(username);
        conversations.forEach(System.out::println);

        model.addAttribute("conversations",conversations);
        return "chat";
    }



    @PostMapping("/chat")
    public String chat(HttpServletRequest httpServletRequest,@RequestBody Map<String, String> request){
        String username= (String) httpServletRequest.getSession().getAttribute("username");

        String content = request.get("content");

        System.out.println(content);

//        String res="回复";
//        Conversation conversation = new Conversation(id++,username, content, res, format(new Date());
//        conversations.add(conversation);

         String res = qianfanUtil.addMessage(content);
        Conversation conversation = new Conversation(null, username, content, res, format(new Date()));
        chatService.addChat(conversation);

        return "redirect:list";
    }


}
