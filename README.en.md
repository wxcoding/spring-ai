# Spring AI Chat Application Example

This is an example project based on the Spring AI framework, demonstrating how to integrate AI conversation capabilities into a Spring Boot application.

## Project Overview

This project contains two main modules:

- **springai-chat** - A comprehensive chat functionality module supporting both synchronous and streaming conversations
- **springai-hello** - A basic AI conversation example module

## Technology Stack

- Java
- Spring Boot
- Spring AI
- OpenAI

## Project Structure

```
spring-ai/
├── springai-chat/           # Chat functionality module
│   ├── src/main/java/com/guanwx/
│   │   ├── SpringAiChatApplication.java    # Main application class
│   │   ├── config/
│   │   │   └── AiConfig.java               # AI configuration class
│   │   └── controller/
│   │       ├── ChatAiController.java       # Chat controller
│   │       ├── ChatController.java         # Basic chat controller
│   │       └── ChatModelController.java    # Model controller
│   └── src/main/resources/
│       └── application.properties           # Configuration file
│
└── springai-hello/          # Basic example module
    ├── src/main/java/com/guanwx/
    │   ├── SpringAiHelloApplication.java    # Main application class
    │   └── controller/
    │       └── TestController.java          # Test controller
    └── src/main/resources/
        └── application.properties           # Configuration file
```

## Features

### springai-chat Module

| Endpoint | Method | Description |
|---------|--------|-------------|
| `/chatai` | GET | Basic chat endpoint |
| `/chatStream` | GET | Streaming chat endpoint (Server-Sent Events) |
| `/chat` | GET | Chat endpoint (default message: "Who are you?") |
| `/chatModel01` | GET | Model-based chat endpoint |
| `/chatModelPrompt` | GET | Prompt template chat endpoint |
| `/prompt` | GET | Parameterized prompt endpoint |

### springai-hello Module

| Endpoint | Method | Description |
|---------|--------|-------------|
| `/test` | GET | Test endpoint |
| `/ai` | GET | AI conversation endpoint |

## Quick Start

### Prerequisites

- JDK 17+
- Maven 3.6+

### Configuration

Configure your OpenAI API key in `application.properties`:

```properties
spring.ai.openai.api-key=your-api-key
```

### Running the Project

**For springai-chat module:**

```bash
cd springai-chat
mvn spring-boot:run
```

**For springai-hello module:**

```bash
cd springai-hello
mvn spring-boot:run
```

### Test Examples

Access the following URLs to test:

```
http://localhost:8080/chatai?message=Hello
http://localhost:8080/chatStream?message=Hello
http://localhost:8080/chat?message=Hello
```

## Core Code Explanation

### AiConfig Configuration Class

```java
@Configuration
public class AiConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder buildChatClient) {
        return buildChatClient.build();
    }
}
```

### Streaming Response Example

```java
@GetMapping(value = "/chatStream", produces = "text/html;charset=UTF-8")
public Flux<String> chatAiStream(@RequestParam(value = "message") String message) {
    return chatClient.prompt()
            .user(message)
            .stream()
            .content();
}
```

## License

This project is intended solely for learning and communication purposes.