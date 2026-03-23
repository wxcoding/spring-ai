package com.guanwx.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @Author: guanwx
 * @CreateTime: 2026/3/21 星期六 1:23
 * @Description:
 * @Version: 1.0
 */

@RestController
public class ChatAiController {

    @Autowired
    private ChatClient chatClient;

    // 角色预设
    @GetMapping("/chatai")
    public String chatAi(@RequestParam(value = "message") String message){
        return chatClient.prompt().user(message).call().content();
    }

    // 流式输出
    @GetMapping(value = "/chatStream", produces = "text/html;charset=UTF-8")
    public Flux<String> chatAiStream(@RequestParam(value = "message") String message){
        return chatClient.prompt().user(message).stream().content();
    }


}
