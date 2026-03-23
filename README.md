

# Spring AI 聊天应用示例

这是一个基于 Spring AI 框架的聊天应用示例项目，展示了如何在 Spring Boot 项目中集成 AI 对话能力。

## 项目简介

本项目包含两个主要模块：

- **springai-chat** - 完整的聊天功能模块，支持同步和流式对话
- **springai-hello** - 基础 AI 对话示例模块

## 技术栈

- Java
- Spring Boot
- Spring AI
- OpenAI

## 项目结构

```
spring-ai/
├── springai-chat/           # 聊天功能模块
│   ├── src/main/java/com/guanwx/
│   │   ├── SpringAiChatApplication.java    # 启动类
│   │   ├── config/
│   │   │   └── AiConfig.java               # AI 配置类
│   │   └── controller/
│   │       ├── ChatAiController.java       # 聊天控制器
│   │       ├── ChatController.java         # 基础聊天
│   │       └── ChatModelController.java    # 模型控制器
│   └── src/main/resources/
│       └── application.properties           # 配置文件
│
└── springai-hello/          # 基础示例模块
    ├── src/main/java/com/guanwx/
    │   ├── SpringAiHelloApplication.java    # 启动类
    │   └── controller/
    │       └── TestController.java          # 测试控制器
    └── src/main/resources/
        └── application.properties           # 配置文件
```

## 功能特性

### springai-chat 模块

| 接口路径 | 方法 | 说明 |
|---------|------|------|
| `/chatai` | GET | 基础聊天接口 |
| `/chatStream` | GET | 流式聊天接口（Server-Sent Events） |
| `/chat` | GET | 聊天接口（默认消息：你是谁） |
| `/chatModel01` | GET | 模型聊天接口 |
| `/chatModelPrompt` | GET | Prompt 模板聊天接口 |
| `/prompt` | GET | 带参数的 Prompt 接口 |

### springai-hello 模块

| 接口路径 | 方法 | 说明 |
|---------|------|------|
| `/test` | GET | 测试接口 |
| `/ai` | GET | AI 对话接口 |

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+

### 配置说明

在 `application.properties` 中配置 OpenAI API Key：

```properties
spring.ai.openai.api-key=your-api-key
```

### 运行项目

**springai-chat 模块：**

```bash
cd springai-chat
mvn spring-boot:run
```

**springai-hello 模块：**

```bash
cd springai-hello
mvn spring-boot:run
```

### 测试示例

访问以下地址测试：

```
http://localhost:8080/chatai?message=你好
http://localhost:8080/chatStream?message=你好
http://localhost:8080/chat?message=你好
```

## 核心代码说明

### AiConfig 配置类

```java
@Configuration
public class AiConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder buildChatClient) {
        return buildChatClient.build();
    }
}
```

### 流式响应示例

```java
@GetMapping(value = "/chatStream", produces = "text/html;charset=UTF-8")
public Flux<String> chatAiStream(@RequestParam(value = "message") String message) {
    return chatClient.prompt()
            .user(message)
            .stream()
            .content();
}
```

## 许可证

本项目仅供学习交流使用。