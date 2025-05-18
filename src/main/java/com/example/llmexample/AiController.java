package com.example.llmexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AiController {

    private ChatClient chatClient;

    public AiController(ChatClient.Builder chatClientBuilder) { this.chatClient = chatClientBuilder.build();}

    @PostMapping("/askQuestion")
    public String askQuestion(@RequestBody String question) {
        log.info("Question Received : {}", question);
        String response = this.chatClient.prompt().user(question).call().content();
        log.info("Response Received : {}", response);
        return response;
    }
}
