package com.deven.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deven.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsConfiguration() {
		return new LimitConfiguration(configuration.getMax(), configuration.getMin());
	}
}
