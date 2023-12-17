package com.example.chatgpt.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
public class ChatRequestDTO {
    private String userInput;
    private String messageResponse;
}


