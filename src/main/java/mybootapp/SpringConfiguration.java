package mybootapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mybootapp.service.SimpleSettlement;

/**
 * Configuration des services logiciels déployés par Spring
 */
@Configuration
public class SpringConfiguration {
	
	@Bean
	@Qualifier("simpleSettlementBean")
	public SimpleSettlement simpleSettelementBean() {
	    return new SimpleSettlement();
	}
	
}


