package com.example.ChatBot.App.service;

import com.example.ChatBot.App.client.OpenAiApiClient;
import com.example.ChatBot.App.dto.CompletionRequest;
import com.example.ChatBot.App.dto.CompletionResponse;
import com.example.ChatBot.App.exception.ResponseNotFoundException;
import com.example.ChatBot.App.utils.OpenAiServiceType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatGPTService {

    private final OpenAiApiClient openAiApiClient;
    private final ObjectMapper objectMapper;

    public String chatWithGPT(String requestMessage, OpenAiServiceType openAiServiceType) throws IOException, InterruptedException {
        CompletionRequest completionRequest = CompletionRequest.fromRequestMessage(requestMessage);
        String request = objectMapper.writeValueAsString(completionRequest);
        String chatBotResponse = openAiApiClient.postToOpenAi(request, openAiServiceType);
        CompletionResponse completionResponse = objectMapper.readValue(chatBotResponse, CompletionResponse.class);
        return completionResponse.getResponse().orElseThrow(
                () -> new ResponseNotFoundException("Could not generate response from chat bot"));
    }

}
