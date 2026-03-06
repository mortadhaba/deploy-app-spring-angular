package com.oauth.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Autorise localhost:4201 (ton frontend Angular)
        config.addAllowedOrigin("http://localhost:4201");
        // Autorise tous les headers
        config.addAllowedHeader("*");
        // Autorise toutes les méthodes (GET, POST, DELETE, etc.)
        config.addAllowedMethod("*");
        // Autorise les cookies/credentials
        config.setAllowCredentials(true);
        
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}