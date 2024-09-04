package com.example.OrderService.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


    @Bean
    public WebClient.Builder webclient()
    {
        return  WebClient.builder();
    }

}
