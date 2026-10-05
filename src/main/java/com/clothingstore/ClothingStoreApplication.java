package com.clothingstore;

import com.clothingstore.model.Product;
import com.clothingstore.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class ClothingStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothingStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(Arrays.asList(
                    new Product(
                        null,
                        "Oversized Cyberpunk Trench Coat",
                        "OUTERWEAR",
                        new BigDecimal("189.99"),
                        "Midnight Black",
                        "L",
                        "Streetwear",
                        "Winter",
                        "Architectural silhouette trench coat featuring waterproof technical poplin, futuristic magnetic closures, and deep ergonomic utility pockets.",
                        "https://images.unsplash.com/photo-1544441893-675973e31985?auto=format&fit=crop&w=800&q=80",
                        25,
                        4.9,
                        true
                    ),
                    new Product(
                        null,
                        "Silk Satin Evening Slip Dress",
                        "DRESSES",
                        new BigDecimal("145.00"),
                        "Emerald Green",
                        "M",
                        "Glam",
                        "All-Season",
                        "Luxurious Mulberry silk slip dress cut on the bias for a liquid drape, featuring fine cowl detail and delicate adjustable straps.",
                        "https://images.unsplash.com/photo-1595777457583-95e059d581b8?auto=format&fit=crop&w=800&q=80",
                        18,
                        4.8,
                        true
                    ),
                    new Product(
                        null,
                        "Heavyweight Organic Cotton Hoodie",
                        "TOPS",
                        new BigDecimal("85.50"),
                        "Heather Oat",
                        "M",
                        "Casual",
                        "All-Season",
                        "450GSM combed organic French terry cotton hoodie with custom custom drop shoulders and ribbed side panels.",
                        "https://images.unsplash.com/photo-1556905055-8f358a7a47b2?auto=format&fit=crop&w=800&q=80",
                        40,
                        4.7,
                        true
                    ),
                    new Product(
                        null,
                        "Tailored Wide-Leg Pleated Trousers",
                        "BOTTOMS",
                        new BigDecimal("110.00"),
                        "Charcoal Grey",
                        "32",
                        "Business",
                        "Spring/Fall",
                        "Precision-cut wool-blend tailored trousers with double front pleats, high waist, and fluid wide-leg drape.",
                        "https://images.unsplash.com/photo-1509631179647-0177331693ae?auto=format&fit=crop&w=800&q=80",
                        30,
                        4.6,
                        true
                    ),
                    new Product(
                        null,
                        "Chunky Chunky Leather Platform Boots",
                        "SHOES",
                        new BigDecimal("165.00"),
                        "Onyx Black",
                        "42",
                        "Streetwear",
                        "Winter",
                        "Handcrafted full-grain Italian calfskin platform chelsea boots with durable lugged Vibram sole and dual stretch goring.",
                        "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?auto=format&fit=crop&w=800&q=80",
                        15,
                        4.9,
                        true
                    ),
                    new Product(
                        null,
                        "Minimalist Cashmere Crewneck Sweater",
                        "TOPS",
                        new BigDecimal("195.00"),
                        "Cream Sand",
                        "S",
                        "Minimalist",
                        "Winter",
                        "100% Grade-A Mongolian cashmere knit sweater providing featherweight warmth, butter-soft texture, and timeless crew collar.",
                        "https://images.unsplash.com/photo-1576566588028-4147f3842f27?auto=format&fit=crop&w=800&q=80",
                        20,
                        4.9,
                        false
                    ),
                    new Product(
                        null,
                        "Sculptural Geometric Leather Crossbody",
                        "ACCESSORIES",
                        new BigDecimal("129.00"),
                        "Terracotta",
                        "Standard",
                        "Modern",
                        "All-Season",
                        "Architectural structured leather bag with brushed brass hardware, magnetic flap closure, and versatile detachable strap.",
                        "https://images.unsplash.com/photo-1584917865442-de89df76afd3?auto=format&fit=crop&w=800&q=80",
                        22,
                        4.7,
                        false
                    ),
                    new Product(
                        null,
                        "Linen Relaxed Resort Shirt",
                        "TOPS",
                        new BigDecimal("72.00"),
                        "Sky Blue",
                        "L",
                        "Casual",
                        "Summer",
                        "Breathable European flax linen shirt featuring camp collar, mother-of-pearl buttons, and lightweight boxy cut.",
                        "https://images.unsplash.com/photo-1598033129183-c4f50c736f10?auto=format&fit=crop&w=800&q=80",
                        35,
                        4.5,
                        false
                    )
                ));
            }
        };
    }
}
