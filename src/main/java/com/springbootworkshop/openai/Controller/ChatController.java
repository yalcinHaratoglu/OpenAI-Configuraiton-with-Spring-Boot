package com.springbootworkshop.openai.Controller;

import com.springbootworkshop.openai.Service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/prompt")
    public String chat(@RequestBody String prompt){
        return chatService.chat(prompt);
    }
}
