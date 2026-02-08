package org.example.aitextapi.controller;


import org.example.aitextapi.dto.TextRequest;
import org.example.aitextapi.dto.TextResponse;
import org.example.aitextapi.service.OllamaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Text generation API", description = "Generate text using Ollama LLM")
public class TextGenerationController {

    private final OllamaService ollamaService;

    public TextGenerationController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/generate")
    @Operation(summary = "Generate a text from a prompt", description = "Send a prompt and receive generated text from the local LLM")
    public ResponseEntity<TextResponse> generate(@Valid @RequestBody TextRequest request) {
        String result = ollamaService.generateText(request.getPrompt(), request.getModel());
        return ResponseEntity.ok(new TextResponse(request.getModel(), request.getPrompt(), result));
    }
}
