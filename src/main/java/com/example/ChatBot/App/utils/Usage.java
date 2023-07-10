package com.example.ChatBot.App.utils;

import lombok.Data;

@Data
public class Usage {
    private String total_tokens;
    private String prompt_tokens;
    private int completion_tokens;
}
