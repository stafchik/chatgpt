package com.example.chatgpt.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class OpenAiClient {
    private final RestTemplate restTemplate;
    @Value("${openai.api.key}")
    private String apiKey;
    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String url;

    public OpenAiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getChatGPTResponse(String userInput) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        String requestBody = "{\"input\": \"" + userInput + "\"}";
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, request, String.class);
        return response.getBody();
    }
}

