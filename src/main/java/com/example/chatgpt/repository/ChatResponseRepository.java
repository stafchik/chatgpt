package com.example.chatgpt.repository;

import com.example.chatgpt.model.ChatResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatResponseRepository extends JpaRepository<ChatResponse, Long> {
}
