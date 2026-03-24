package com.guanwx.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guanwx
 * @CreateTime: 2026/3/24 星期二 9:50
 * @Description:
 * @Version: 1.0
 */

@RestController
public class ChatQwenController {

    @Autowired
    private OllamaChatModel ollamaChatModel;

    @GetMapping("/ai/ollama")
    public String generate(@RequestParam(value = "message", defaultValue = "hello")
                           String message) {
        String response = this.ollamaChatModel.call(message);
        System.out.println("response : "+response);
        return response;
    }

}
