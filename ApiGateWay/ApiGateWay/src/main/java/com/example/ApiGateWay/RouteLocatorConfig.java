package com.example.ApiGateWay;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder)
    {
      return  builder.routes()
                .route("ORDERSERVICE",r->r.path("/order")
                        .uri("http://ORDERSERVICE"))
                .build();
    }
}
