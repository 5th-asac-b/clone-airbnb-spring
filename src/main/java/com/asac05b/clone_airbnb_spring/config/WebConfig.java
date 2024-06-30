package com.asac05b.clone_airbnb_spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000",
                        "https://clone-airbnb-nextjs-flax.vercel.app",
                        "https://clone-airbnb-nextjs-ten.vercel.app",
                        "http://clone-airbnb-nextjs-iixlwpcmw-thereisnames-projects.vercel.app",
                        "https://clone-airbnb-nextjs-iixlwpcmw-thereisnames-projects.vercel.app",
                        "https://clone-airbnb-nextjs-git-main-thereisnames-projects.vercel.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}