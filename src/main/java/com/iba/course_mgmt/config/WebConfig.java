package com.iba.course_mgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS for all endpoints
                .allowedOrigins("https://rehmatgul0.github.io/DevOpsDemoFE") // Allow specific origin (replace with your front-end URL)
                .allowedMethods("*") // Allow specific HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(false); // Allow credentials (cookies, HTTP authentication)
    }
}
