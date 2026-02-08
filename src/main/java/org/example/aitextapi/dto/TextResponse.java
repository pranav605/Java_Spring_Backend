package org.example.aitextapi.dto;

public class TextResponse {

    private String prompt;
    private String model;
    private String generatedText;

    public TextResponse(String prompt, String model, String generatedText) {
        this.prompt = prompt;
        this.model = model;
        this.generatedText = generatedText;
    }

    public String getModel() {
        return model;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getGeneratedText() {
        return generatedText;
    }
}
