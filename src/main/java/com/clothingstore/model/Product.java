package com.clothingstore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category; // e.g., TOPS, BOTTOMS, OUTERWEAR, DRESSES, SHOES, ACCESSORIES

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be positive")
    private BigDecimal price;

    private String color;

    private String size; // e.g., XS, S, M, L, XL, Standard

    private String style; // e.g., Casual, Formal, Streetwear, Elegant, Bohemian, Sporty

    private String season; // e.g., Summer, Winter, All-Season, Spring/Fall

    @Column(length = 2000)
    private String description;

    private String imageUrl;

    private Integer stock;

    private Double rating;

    private Boolean featured;

    public Product() {}

    public Product(Long id, String name, String category, BigDecimal price, String color, String size, 
                   String style, String season, String description, String imageUrl, Integer stock, Double rating, Boolean featured) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.color = color;
        this.size = size;
        this.style = style;
        this.season = season;
        this.description = description;
        this.imageUrl = imageUrl;
        this.stock = stock;
        this.rating = rating;
        this.featured = featured;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Boolean getFeatured() { return featured; }
    public void setFeatured(Boolean featured) { this.featured = featured; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
