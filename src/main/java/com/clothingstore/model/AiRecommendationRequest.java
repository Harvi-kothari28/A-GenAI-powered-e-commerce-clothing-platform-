package com.clothingstore.model;

import java.math.BigDecimal;

public class AiRecommendationRequest {

    private String prompt;
    private String occasion; // Casual, Business, Gala, Date Night, Beach, Workout
    private String season;   // Summer, Winter, Spring, Fall
    private String preferredStyle; // Streetwear, Classic, Vintage, Minimalist, Glam
    private BigDecimal maxBudget;
    private String genderCategory; // Men, Women, Unisex

    public AiRecommendationRequest() {}

    public AiRecommendationRequest(String prompt, String occasion, String season, String preferredStyle, BigDecimal maxBudget, String genderCategory) {
        this.prompt = prompt;
        this.occasion = occasion;
        this.season = season;
        this.preferredStyle = preferredStyle;
        this.maxBudget = maxBudget;
        this.genderCategory = genderCategory;
    }

    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }

    public String getOccasion() { return occasion; }
    public void setOccasion(String occasion) { this.occasion = occasion; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public String getPreferredStyle() { return preferredStyle; }
    public void setPreferredStyle(String preferredStyle) { this.preferredStyle = preferredStyle; }

    public BigDecimal getMaxBudget() { return maxBudget; }
    public void setMaxBudget(BigDecimal maxBudget) { this.maxBudget = maxBudget; }

    public String getGenderCategory() { return genderCategory; }
    public void setGenderCategory(String genderCategory) { this.genderCategory = genderCategory; }
}
