package com.guanwx.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guanwx
 * @CreateTime: 2026/3/20 星期五 12:54
 * @Description:
 * @Version: 1.0
 */

@RestController
public class TestController {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @GetMapping("/test")
    public String test1 (@RequestParam String test) {
        System.out.println(test);
        return test;
    }

    @GetMapping("/ai")
    public String aiTest(@RequestParam String message) {
        String result = openAiChatModel.call(message);
        System.out.println(result);
        return result;
    }
}
