package com.example.ChatBot.App.controller;

import com.example.ChatBot.App.dto.ChatBotMessageDTO;
import com.example.ChatBot.App.service.ChatGPTService;
import com.example.ChatBot.App.utils.OpenAiServiceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.example.ChatBot.App.utils.Constants.*;

@Controller
@RequiredArgsConstructor
public class ChatBotController {

    private final ChatGPTService chatGPTService;

    @GetMapping("/")
    public String index() {
        return MAIN_PAGE;
    }

    @PostMapping("/")
    public String chat(Model model, @ModelAttribute ChatBotMessageDTO chatBotMessageDTO) {
        try {
            model.addAttribute(REQUEST, chatBotMessageDTO.getMessage());
            model.addAttribute(RESPONSE, chatGPTService.chatWithGPT(chatBotMessageDTO.getMessage(), OpenAiServiceType.GPT_3));
        } catch (Exception exception) {
            model.addAttribute(RESPONSE, ERROR_IN_RETRIEVING_RESPONSE);
        }
        return MAIN_PAGE;
    }
}
