package com.springbootworkshop.openai.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIRestTemplateConfig {
    @Value("${openai.api.key}")
    private String OPENAI_API_KEY;
    @Bean
    @Qualifier("openAiRestTemplate")
    public RestTemplate openAIRestTemplate(){
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add((request, body, execution) -> {
           request.getHeaders().add("Authorization","Bearer" + OPENAI_API_KEY);
           return execution.execute(request,body);
        });
        return template;
    }
}
