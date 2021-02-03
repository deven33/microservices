package com.deven.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter( RouteLocatorBuilder builder) {
		//Pre and Post Filters provided by Spring Cloud Gateway
		/* if request comes to /currency-exchange/ then it will
		redirect to naming server service name currency-exchange-service */
		System.out.println("ENTRY::"+"ApiGatewayConfiguration");
		return builder
				.routes()
				.route(p -> p.path("/currency-exchange/**")
							.filters( f -> f.addRequestHeader("MyHeader", "MyURI")
										.addRequestParameter("param", "myparam"))
						.uri("lb://currency-exchange-service"))
				.route(p -> p.path("/currency-conversion/**")
							.filters(f -> f.addRequestHeader("MyHeader2", "MyURL2")
									 	   .addRequestParameter("para2", "v2"))
				.uri("lb://currency-conversion-service"))
				.build();
	}

}
