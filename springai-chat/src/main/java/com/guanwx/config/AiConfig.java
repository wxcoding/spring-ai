package com.guanwx.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: guanwx
 * @CreateTime: 2026/3/21 星期六 1:24
 * @Description:
 * @Version: 1.0
 */

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder buildChatClient){
        return buildChatClient.defaultSystem("我是一个Java工程师...").build();
    }


}
