package com.deven.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger =  LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api-retry", fallbackMethod = "hardCodedResponse")
	@CircuitBreaker(name = "sample-api-retry", fallbackMethod = "hardCodedResponse")
	public String sampleApi() {
		logger.info("Sample API call received");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost/dummy-url", String.class);
		return entity.getBody();
	}

	public String hardCodedResponse(Exception ex) {
		return "hard coded response";
	}
}

