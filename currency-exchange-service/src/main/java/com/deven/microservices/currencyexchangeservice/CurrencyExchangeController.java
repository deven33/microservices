package com.deven.microservices.currencyexchangeservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deven.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.deven.microservices.currencyexchangeservice.bean.ExchangeValueRepo;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	ExchangeValueRepo exchangeValueRepo;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	

	/**
	 * @param from
	 * @param to
	 * @return
	 */
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		logger.info("retrieveExchangeValue called with {} to {}"+from, to);
		
		ExchangeValue exchangeValue = 
				exchangeValueRepo.findByFromAndTo(from, to);
		// Read port from Property file
		exchangeValue.setPort(
				Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

}
