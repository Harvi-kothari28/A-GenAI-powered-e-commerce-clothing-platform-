package com.clothingstore.controller;

import com.clothingstore.ai.AiStylistService;
import com.clothingstore.model.AiRecommendationRequest;
import com.clothingstore.model.AiRecommendationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiStylistController {

    private final AiStylistService aiStylistService;

    @Autowired
    public AiStylistController(AiStylistService aiStylistService) {
        this.aiStylistService = aiStylistService;
    }

    @PostMapping("/recommend")
    public ResponseEntity<AiRecommendationResponse> getStyleRecommendations(@RequestBody AiRecommendationRequest request) {
        AiRecommendationResponse response = aiStylistService.getRecommendations(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/chat")
    public ResponseEntity<AiRecommendationResponse> chatWithStylist(@RequestBody Map<String, String> payload) {
        String prompt = payload.getOrDefault("prompt", "Recommend a stylish modern outfit");
        AiRecommendationResponse response = aiStylistService.getVirtualStylistChatResponse(prompt);
        return ResponseEntity.ok(response);
    }
}
