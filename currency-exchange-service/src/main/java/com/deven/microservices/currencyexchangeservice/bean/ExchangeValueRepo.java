package com.deven.microservices.currencyexchangeservice.bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
