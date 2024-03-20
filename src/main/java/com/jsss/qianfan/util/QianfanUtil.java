package com.jsss.qianfan.util;

import com.baidubce.qianfan.Qianfan;
import com.baidubce.qianfan.model.chat.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QianfanUtil {

    @Autowired
    Qianfan qianfan;

    public String addMessage(String content) {

        ChatResponse response = qianfan.chatCompletion()
                //.model("ERNIE-Bot-4")  //使用model指定预置模型 默认模型是ERNIE-Bot-turbo
                .addMessage("user", content) // 添加用户消息 (此方法可以调用多次，以实现多轮对话的消息传递)
                .temperature(0.7) // 自定义超参数
                .execute(); // 发起请求


        return response.getResult();

    }
    public void executeStream(String content) {

        qianfan.chatCompletion()
                .addMessage("user", content)
                .executeStream() // 发起流式请求
                .forEachRemaining(chunk -> System.out.print(chunk.getResult())); // 流式迭代，并打印消息


    }



}
