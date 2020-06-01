package com.vivek.springboot.api.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiGatewayApplication.class, args); 
	}
	

	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder routeLocatorBuilder) {		
	 return	routeLocatorBuilder.routes()
		.route(p -> p
				.path("/get")
		.filters(f -> f.addRequestHeader("Hello", "World2"))
		.uri("http://httpbin.org:80")).build();
	
	}
}
