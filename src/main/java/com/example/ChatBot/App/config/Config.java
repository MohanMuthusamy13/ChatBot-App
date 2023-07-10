package com.example.ChatBot.App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class Config {
    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }
}
