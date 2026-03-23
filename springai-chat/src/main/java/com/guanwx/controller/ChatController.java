package com.guanwx.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guanwx
 * @CreateTime: 2026/3/21 星期六 0:54
 * @Description:
 * @Version: 1.0
 */

@RestController
public class ChatController {

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chat")
    public String chat (@RequestParam (value = "message", defaultValue = "你是谁") String message) {
        return chatClient.prompt() // 提示词
                .user(message) // 用户输入信息
                .call() // 请求大模型
                .content(); // 大模型啊返回信息
    }

}
