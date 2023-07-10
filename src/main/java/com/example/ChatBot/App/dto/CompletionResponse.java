package com.example.ChatBot.App.dto;

import com.example.ChatBot.App.utils.Choice;
import com.example.ChatBot.App.utils.Usage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class CompletionResponse {
    private Usage usage;
    private List<Choice> choices;

    public Optional<String> getResponse() {
        if (Objects.isNull(choices) || choices.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(choices.get(0).getMessage().getContent());
    }
}
