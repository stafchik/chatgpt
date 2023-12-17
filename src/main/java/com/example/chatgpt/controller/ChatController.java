package com.example.chatgpt.controller;

import com.example.chatgpt.dto.ChatRequestDTO;
import com.example.chatgpt.dto.ChatResponseDTO;
import com.example.chatgpt.service.ChatDatabaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatDatabaseService chatDatabaseService;

    public ChatController(ChatDatabaseService chatDatabaseService) {
        this.chatDatabaseService = chatDatabaseService;
    }

    @PostMapping("/process-user-input")
    public ResponseEntity<?> processUserInput(@RequestBody ChatRequestDTO chatRequestDTO) {
        if (chatRequestDTO == null || chatRequestDTO.getUserInput() == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            ChatResponseDTO response = chatDatabaseService.processUserInput(chatRequestDTO);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            chatRequestDTO.setMessageResponse(e.getMessage().substring(0, 254));
            chatDatabaseService.processUserInput(chatRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }
}
