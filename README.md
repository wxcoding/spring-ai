# Spring AI 学习项目

这是一个基于 Spring AI 框架的学习项目，包含了 Spring AI 的各种核心功能示例，涵盖了聊天、函数调用、RAG、多模态等多个方面。

## 项目结构

```
spring-ai/
├── springai-hello          # 入门示例
├── springai-chat           # 聊天功能示例
├── springai-function       # 函数调用示例
├── springai-ollama         # Ollama 集成示例
├── springai-alibaba        # 阿里云通义千问集成
├── other                   # 多模态示例（图像、音频）
├── rag                     # RAG 检索增强生成示例
└── all                     # 综合示例
```

## 技术栈

- **Spring Boot**: 3.3.8
- **Spring AI**: AI 集成框架
- **OpenAI**: GPT 模型集成
- **Ollama**: 本地大模型运行
- **阿里云 DashScope**: 通义千问模型
- **Vector Store**: 向量数据库存储

## 模块说明

### 1. springai-hello
入门级示例，演示了最基本的 AI 聊天功能。

**主要功能**：
- 简单的 AI 对话接口
- OpenAI ChatModel 的基本使用

**接口示例**：
- `GET /test?test=xxx` - 测试接口
- `GET /ai?message=xxx` - AI 对话接口

### 2. springai-chat
聊天功能进阶示例，展示了更丰富的聊天交互方式。

**主要功能**：
- ChatModel 的多种调用方式
- Prompt 提示词模板使用
- 系统提示词配置
- 对话上下文管理

**核心类**：
- [ChatModelController.java](springai-chat/src/main/java/com/guanwx/controller/ChatModelController.java) - ChatModel 使用示例
- [ChatController.java](springai-chat/src/main/java/com/guanwx/controller/ChatController.java) - 聊天控制器
- [ChatAiController.java](springai-chat/src/main/java/com/guanwx/controller/ChatAiController.java) - AI 聊天控制器

### 3. springai-function
函数调用（Function Calling）示例，演示如何让 AI 调用自定义函数。

**主要功能**：
- 自定义函数定义与注册
- AI 自动选择并调用函数
- 函数参数自动解析

**示例函数**：
- `addOperation` - 加法运算
- `mulOperation` - 乘法运算

**核心类**：
- [CalculatorService.java](springai-function/src/main/java/com/guanwx/config/CalculatorService.java) - 计算器服务函数定义
- [FunctionController.java](springai-function/src/main/java/com/guanwx/controller/FunctionController.java) - 函数调用控制器

### 4. springai-ollama
Ollama 本地模型集成示例。

**主要功能**：
- 本地大模型部署与调用
- OllamaChatModel 使用
- 本地模型配置

**核心类**：
- [ChatQwenController.java](springai-ollama/src/main/java/com/guanwx/controller/ChatQwenController.java) - Ollama 聊天控制器

### 5. springai-alibaba
阿里云通义千问（Qwen）集成示例。

**主要功能**：
- 阿里云 DashScope API 集成
- ChatClient 高级用法
- 对话记忆（Chat Memory）
- 日志记录 Advisor

**核心类**：
- [QwenController.java](springai-alibaba/src/main/java/com/guanwx/controller/QwenController.java) - 通义千问控制器

### 6. springai-other
多模态功能示例，包含图像生成和语音合成。

**主要功能**：
- **图像生成**：使用 AI 生成图像
- **语音合成**：文本转语音（TTS）

**核心类**：
- [ImageModelController.java](other/src/main/java/com/guanwx/controller/ImageModelController.java) - 图像生成控制器
- [AudioModelController.java](other/src/main/java/com/guanwx/controller/AudioModelController.java) - 语音合成控制器

**接口示例**：
- `GET /image?msg=xxx` - 生成图像
- `GET /tts` - 文本转语音

### 7. springai-rag
RAG（Retrieval-Augmented Generation）检索增强生成示例。

**主要功能**：
- 向量数据库存储
- 文档向量化
- 基于检索的问答系统
- QuestionAnswerAdvisor 使用

**核心类**：
- [RagController.java](rag/src/main/java/com/guanwx/controller/RagController.java) - RAG 控制器
- [RagConfig.java](rag/src/main/java/com/guanwx/config/RagConfig.java) - RAG 配置

**接口示例**：
- `GET /rag?input=xxx` - RAG 问答接口

### 8. springai-all
综合示例，整合了多种功能。

**主要功能**：
- RAG 功能
- 函数调用
- 综合应用场景

**核心类**：
- [RecruitServiceFunction.java](all/src/main/java/com/guanwx/func/RecruitServiceFunction.java) - 招聘服务函数
- [ChatController.java](all/src/main/java/com/guanwx/controller/ChatController.java) - 聊天控制器

## 快速开始

### 前置要求

- JDK 17+
- Maven 3.6+
- OpenAI API Key（如使用 OpenAI）
- 阿里云 DashScope API Key（如使用通义千问）
- Ollama（如使用本地模型）

### 配置

在各模块的 `application.properties` 中配置相应的 API Key：

```properties
# OpenAI 配置
spring.ai.openai.api-key=your-api-key
spring.ai.openai.base-url=https://api.openai.com

# 阿里云 DashScope 配置
spring.ai.dashscope.api-key=your-dashscope-api-key

# Ollama 配置
spring.ai.ollama.base-url=http://localhost:11434
```

### 运行

```bash
# 进入项目根目录
cd spring-ai

# 编译项目
mvn clean install

# 运行指定模块
cd springai-hello
mvn spring-boot:run
```

## 核心概念

### ChatModel vs ChatClient

- **ChatModel**: 底层模型接口，提供基本的对话能力
- **ChatClient**: 高级客户端，提供更丰富的功能（如 Advisor、Memory 等）

### Function Calling

函数调用允许 AI 模型调用预定义的函数，扩展 AI 的能力边界：

```java
@Bean
@Description("加法运算")
public Function<AddOperation, Integer> addOperation() {
    return request -> request.a + request.b;
}
```

### RAG（检索增强生成）

RAG 通过检索相关文档来增强 AI 的回答质量：

1. 文档向量化并存储到向量数据库
2. 用户提问时检索相关文档
3. 将检索结果作为上下文提供给 AI

## 学习路径建议

1. **入门阶段**：从 `springai-hello` 开始，了解基本的 AI 调用
2. **进阶阶段**：学习 `springai-chat`，掌握 Prompt 工程和对话管理
3. **函数调用**：通过 `springai-function` 学习如何扩展 AI 能力
4. **多模态**：在 `other` 模块中学习图像和语音处理
5. **高级应用**：学习 `rag` 模块，掌握 RAG 技术
6. **模型集成**：了解 `springai-ollama` 和 `springai-alibaba`，学习不同模型的集成

## 参考资料

- [Spring AI 官方文档](https://docs.spring.io/spring-ai/reference/)
- [OpenAI API 文档](https://platform.openai.com/docs)
- [阿里云 DashScope 文档](https://help.aliyun.com/zh/dashscope/)
- [Ollama 官网](https://ollama.ai/)