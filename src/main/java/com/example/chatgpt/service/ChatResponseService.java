package com.example.chatgpt.service;

import com.example.chatgpt.dto.ChatResponseDTO;
import com.example.chatgpt.model.ChatResponse;
import com.example.chatgpt.repository.ChatResponseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatResponseService {
    private final ChatResponseRepository chatResponseRepository;

    public ChatResponseService(ChatResponseRepository chatResponseRepository) {
        this.chatResponseRepository = chatResponseRepository;
    }
    @Transactional
    public void saveChatResponse(ChatResponseDTO chatResponseDTO) {
        ChatResponse responseEntity = new ChatResponse();
        responseEntity.setChatGPTResponse(chatResponseDTO.getChatGPTResponse());
        chatResponseRepository.save(responseEntity);
    }
}
