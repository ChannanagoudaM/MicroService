package com.example.OrderService.Config;


import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {


    @Bean
    @LoadBalanced
   public Feign.Builder feign()
    {
        return Feign.builder();
    }
}
