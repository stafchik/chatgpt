package com.example.chatgpt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIRestTemplateConfig {

    @Bean
    public RestTemplate gptRestTemplate() {
        return new RestTemplate();
    }

}
