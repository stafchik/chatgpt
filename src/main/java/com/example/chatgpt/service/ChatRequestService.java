package com.example.chatgpt.service;

import com.example.chatgpt.dto.ChatRequestDTO;
import com.example.chatgpt.model.ChatRequest;
import com.example.chatgpt.repository.ChatRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatRequestService {
    private final ChatRequestRepository chatRequestRepository;

    public ChatRequestService(ChatRequestRepository chatRequestRepository) {
        this.chatRequestRepository = chatRequestRepository;
    }
    @Transactional
    public void saveChatRequest(ChatRequestDTO chatRequestDTO) {
        ChatRequest requestEntity = new ChatRequest();
        requestEntity.setUserInput(chatRequestDTO.getUserInput());
        requestEntity.setResponseMessage(chatRequestDTO.getMessageResponse());
        chatRequestRepository.save(requestEntity);
    }
}
