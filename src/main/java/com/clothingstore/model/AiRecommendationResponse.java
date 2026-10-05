package com.clothingstore.model;

import java.util.List;

public class AiRecommendationResponse {

    private String adviceSummary;
    private String styleVibe;
    private List<Product> recommendedProducts;
    private List<String> stylingTips;
    private Double confidenceScore;

    public AiRecommendationResponse() {}

    public AiRecommendationResponse(String adviceSummary, String styleVibe, List<Product> recommendedProducts, List<String> stylingTips, Double confidenceScore) {
        this.adviceSummary = adviceSummary;
        this.styleVibe = styleVibe;
        this.recommendedProducts = recommendedProducts;
        this.stylingTips = stylingTips;
        this.confidenceScore = confidenceScore;
    }

    public String getAdviceSummary() { return adviceSummary; }
    public void setAdviceSummary(String adviceSummary) { this.adviceSummary = adviceSummary; }

    public String getStyleVibe() { return styleVibe; }
    public void setStyleVibe(String styleVibe) { this.styleVibe = styleVibe; }

    public List<Product> getRecommendedProducts() { return recommendedProducts; }
    public void setRecommendedProducts(List<Product> recommendedProducts) { this.recommendedProducts = recommendedProducts; }

    public List<String> getStylingTips() { return stylingTips; }
    public void setStylingTips(List<String> stylingTips) { this.stylingTips = stylingTips; }

    public Double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(Double confidenceScore) { this.confidenceScore = confidenceScore; }
}
