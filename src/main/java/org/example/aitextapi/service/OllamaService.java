package org.example.aitextapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OllamaService {
    public static final String OLLAMA_URL = "http://localhost:11434/api/generate";
    private final RestTemplate restTemplate = new  RestTemplate();

    public String generateText(String prompt, String model){

        Map<String,Object> body = new HashMap<>();
        body.put("prompt",prompt);
        body.put("model",model);
        body.put("stream", false);

        ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, body, Map.class);

        if( !response.getStatusCode().is2xxSuccessful() || response.getBody()==null ){
            throw new RuntimeException("Failed to generate text from Ollama");
        }

        return response.getBody().get("response").toString();
    }
}
