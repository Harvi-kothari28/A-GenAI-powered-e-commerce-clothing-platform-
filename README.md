# 👗 AI-Powered Clothing Store

An AI-powered e-commerce clothing platform built with **Java and Spring Boot** that combines a digital clothing store with an intelligent AI stylist. Users can explore products, receive personalized fashion recommendations, and manage orders through a simple web application.

🌐 **Live Website:** https://a-genai-powered-e-commerce-clothing.onrender.com/

---

## ✨ Features

### 🤖 AI Fashion Stylist
- AI-powered outfit recommendations
- Personalized clothing suggestions based on user preferences
- Natural-language interaction with the AI stylist
- Intelligent fashion recommendations

### 🛍️ Product Management
- View available clothing products
- Product information and pricing
- REST APIs for product operations
- Product data management using Spring Boot

### 🛒 Order Management
- Create and manage orders
- Order item handling
- Order processing through REST APIs
- Service-based order architecture

### 🌐 Web Application
- Responsive web interface
- Static frontend served through Spring Boot
- Backend REST APIs
- Integrated AI functionality

### 🗄️ Database
- H2 database for application data
- JPA/Hibernate for database interaction
- Automatic database schema management
- H2 console available for development

### 🐳 Docker Support
- Multi-stage Docker build
- Separate build and runtime environments
- Lightweight Java runtime image
- Non-root application user for improved security

### ☁️ Cloud Deployment
- Deployed as a Docker-based Spring Boot application
- Hosted on Render
- Publicly accessible website
- Environment variables used for sensitive configuration

---

## 🏗️ Project Architecture

```text
AI-Powered Clothing Store
│
├── src
│   └── main
│       ├── java
│       │   └── com.clothingstore
│       │       │
│       │       ├── ai
│       │       │   ├── AiStylistService.java
│       │       │   └── FashionAIClient.java
│       │       │
│       │       ├── config
│       │       │   └── CorsConfig.java
│       │       │
│       │       ├── controller
│       │       │   ├── AiStylistController.java
│       │       │   ├── OrderController.java
│       │       │   └── ProductController.java
│       │       │
│       │       ├── model
│       │       │   ├── AiRecommendationRequest.java
│       │       │   ├── AiRecommendationResponse.java
│       │       │   ├── Order.java
│       │       │   ├── OrderItem.java
│       │       │   └── Product.java
│       │       │
│       │       ├── repository
│       │       │   ├── OrderRepository.java
│       │       │   └── ProductRepository.java
│       │       │
│       │       ├── service
│       │       │   ├── OrderService.java
│       │       │   └── ProductService.java
│       │       │
│       │       └── ClothingStoreApplication.java
│       │
│       └── resources
│           ├── static
│           └── application.properties
│
├── .github
│   └── workflows
│       └── deploy.yml
│
├── Dockerfile
├── pom.xml
├── .gitignore
└── README.md

## 👩‍💻 Author

**Harvi Kothari**  
B.Tech Computer Science & Engineering
