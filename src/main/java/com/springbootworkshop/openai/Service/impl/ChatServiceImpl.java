package com.springbootworkshop.openai.Service.impl;

import com.springbootworkshop.openai.Dto.ChatRequest;
import com.springbootworkshop.openai.Dto.ChatResponse;
import com.springbootworkshop.openai.Service.ChatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements ChatService {
    @Qualifier("openAiRestTemplate")
    private final RestTemplate restTemplate;

    public ChatServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String URL;

    @Override
    public String chat(String prompt) {
        ChatRequest request = new ChatRequest(model,prompt);
        ChatResponse response = restTemplate.postForObject(URL,request,ChatResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }
}
