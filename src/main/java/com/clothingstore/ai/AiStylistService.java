package com.clothingstore.ai;

import com.clothingstore.model.AiRecommendationRequest;
import com.clothingstore.model.AiRecommendationResponse;
import com.clothingstore.model.Product;
import com.clothingstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiStylistService {

    private final ProductRepository productRepository;
    private final FashionAiClient fashionAiClient;

    @Autowired
    public AiStylistService(ProductRepository productRepository, FashionAiClient fashionAiClient) {
        this.productRepository = productRepository;
        this.fashionAiClient = fashionAiClient;
    }

    public AiRecommendationResponse getRecommendations(AiRecommendationRequest request) {
        List<Product> catalog = productRepository.findAll();
        return fashionAiClient.generateRecommendation(request, catalog);
    }

    public AiRecommendationResponse getVirtualStylistChatResponse(String userPrompt) {
        AiRecommendationRequest request = new AiRecommendationRequest();
        request.setPrompt(userPrompt);
        request.setOccasion("Custom Query");
        request.setPreferredStyle("Trendy");

        List<Product> catalog = productRepository.findAll();
        return fashionAiClient.generateRecommendation(request, catalog);
    }
}
