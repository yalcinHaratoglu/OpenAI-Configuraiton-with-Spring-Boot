package com.springbootworkshop.openai.Service.impl;

import com.springbootworkshop.openai.Service.WelcomeService;
import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {
    @Override
    public String sayHi(String name) {
        return "Hello! " + name;
    }
}
