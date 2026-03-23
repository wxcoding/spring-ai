package com.guanwx.controller;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: guanwx
 * @CreateTime: 2026/3/21 星期六 1:57
 * @Description:
 * @Version: 1.0
 */

@RestController
public class ChatModelController {

    @Autowired
    private ChatModel chatModel;

    @GetMapping("/chatModel01")
    public String chatModel(@RequestParam(value = "message") String message){
        return chatModel.call(message);
    }

    @GetMapping("/chatModelPrompt")
    public String chatModelPrompt(@RequestParam(value = "message") String message){
        ChatResponse chatResponse = chatModel.call(new Prompt(message,
                ChatOptions.builder().build()));
        return chatResponse.getResult().getOutput().getContent();
    }

    // 提示词操作
    @GetMapping("/prompt")
    public String prompt(@RequestParam(value = "name" ) String name,
                         @RequestParam(value = "voice") String voice) {

        String userText= """
            给我推荐北京的至少三种美食
            """;
        UserMessage userMessage = new UserMessage(userText);
        String systemText= """
            你是一个美食咨询助手，可以帮助人们查询美食信息。
            你的名字是{name},
            你应该用你的名字和{voice}的饮食习惯回复用户的请求。
            """;
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemText);
        //替换占位符
        Message systemMessage = systemPromptTemplate
                .createMessage(Map.of("name", name, "voice", voice));
        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
        List<Generation> results = chatModel.call(prompt).getResults();
        return results.stream().map(x->x.getOutput().getContent()).collect(Collectors.joining(""));
    }
}
