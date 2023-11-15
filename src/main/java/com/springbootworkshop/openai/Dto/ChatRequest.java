package com.springbootworkshop.openai.Dto;

import com.springbootworkshop.openai.Model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
    private String model;
    private List<Message> messages;

    public ChatRequest(String model,String prompt){
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }
}
