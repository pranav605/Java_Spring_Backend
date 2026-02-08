package org.example.aitextapi.dto;

import jakarta.validation.constraints.NotBlank;

public class TextRequest {

    @NotBlank(message = "Prompt cannot be empty")
    private String prompt;

    private String model = "tinyllama";

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
