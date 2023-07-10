package com.example.ChatBot.App.client;

import com.example.ChatBot.App.utils.OpenAiServiceType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor
public class OpenAiApiClient {

    @Value("${openai.api_key}")
    private String openApiKey;

    private final HttpClient httpClient;

    public String postToOpenAi(String requestMessage, OpenAiServiceType openAiServiceType) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(selectUri(openAiServiceType))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + openApiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestMessage)).build();
        System.out.println("HTTPRequest :: " + httpRequest);
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());;
        System.out.println("HTTPResponse :: " + httpResponse);
        String chatGPTResponse = httpResponse.body();
        System.out.println("ChatGPTResponse"  + chatGPTResponse);
        return chatGPTResponse;
    }

    private URI selectUri(OpenAiServiceType service) {
        return URI.create(switch (service) {
            case DALL_E -> "https://api.openai.com/v1/images/generations";
            case GPT_3 -> "https://api.openai.com/v1/chat/completions";
        });
    }
}

