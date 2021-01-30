package com.deven.microservices.currencyexchangeservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-exchange-service")
public class Configuration {

}
