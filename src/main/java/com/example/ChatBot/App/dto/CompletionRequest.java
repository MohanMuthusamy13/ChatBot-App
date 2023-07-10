package com.example.ChatBot.App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.ChatBot.App.utils.Constants.*;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class CompletionRequest {

    private String model;
    private List<Map<String, String>> messages;

    public static CompletionRequest fromRequestMessage(String requestMessage) {
        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> roleAndContent1 = new HashMap<>();
        roleAndContent1.put(ROLE, SYSTEM);
        roleAndContent1.put(CONTENT, SYSTEM_CUSTOM_MESSAGE);
        messages.add(roleAndContent1);

        Map<String, String> roleAndContent2 = new HashMap<>();
        roleAndContent2.put(ROLE, USER);
        roleAndContent2.put(CONTENT, requestMessage);
        messages.add(roleAndContent2);

        return new CompletionRequest(CHATGPT_MODEL_NAME, messages);
    }
}
