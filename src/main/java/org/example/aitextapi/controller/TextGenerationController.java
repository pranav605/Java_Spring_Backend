package org.example.aitextapi.controller;


import org.example.aitextapi.dto.TextRequest;
import org.example.aitextapi.dto.TextResponse;
import org.example.aitextapi.service.OllamaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TextGenerationController {

    private final OllamaService ollamaService;

    public TextGenerationController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/generate")
    public ResponseEntity<TextResponse> generate(@Valid @RequestBody TextRequest request) {
        String result = ollamaService.generateText(request.getPrompt(), request.getModel());
        return ResponseEntity.ok(new TextResponse(request.getModel(), request.getPrompt(), result));
    }
}
