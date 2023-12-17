package com.example.chatgpt.service;

import com.example.chatgpt.client.OpenAiClient;
import com.example.chatgpt.dto.ChatRequestDTO;
import com.example.chatgpt.dto.ChatResponseDTO;
import org.springframework.stereotype.Service;


@Service
public class ChatDatabaseService {
    private final ChatRequestService chatRequestService;
    private final ChatResponseService chatResponseService;
    private final OpenAiClient openAiClient;

    public ChatDatabaseService(ChatRequestService chatRequestService, ChatResponseService chatResponseService, OpenAiClient openAiClient) {
        this.chatRequestService = chatRequestService;
        this.chatResponseService = chatResponseService;
        this.openAiClient = openAiClient;
    }

    public ChatResponseDTO processUserInput(ChatRequestDTO chatRequestDTO) {
        String userInput = chatRequestDTO.getUserInput();
        chatRequestService.saveChatRequest(chatRequestDTO);
        String chatGPTResponse = openAiClient.getChatGPTResponse(userInput);
        ChatResponseDTO chatResponseDTO = new ChatResponseDTO();
        chatResponseDTO.setChatGPTResponse(chatGPTResponse);
        chatResponseService.saveChatResponse(chatResponseDTO);
        return chatResponseDTO;
    }
}
