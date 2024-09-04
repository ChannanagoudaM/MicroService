package com.example.ApiGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayApplication.class, args);
	}
		@Bean
		public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
			return builder.routes()
					.route("ORDERSERVICE", r -> r.path("/order")
							.uri("http://ORDERSERVICE"))
					.build();
		}
	}


