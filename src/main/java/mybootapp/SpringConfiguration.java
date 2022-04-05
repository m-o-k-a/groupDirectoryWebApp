package mybootapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mybootapp.service.DirectoryManager;
import mybootapp.service.SimpleSettlement;

/**
 * Configuration des services logiciels déployés par Spring
 */
@Configuration
@EntityScan(basePackages = {"mybootapp.repo", "mybootapp.service", "mybootapp.model", "mybootapp.web"})
public class SpringConfiguration {

	@Bean
	@Qualifier("simpleSettlementBean")
	public SimpleSettlement simpleSettelementBean() {
	    return new SimpleSettlement();
	}
	
	@Bean
	@Qualifier("directoryManagerBean")
	public DirectoryManager directoryManagerBean() {
		return new DirectoryManager();
	}
	
}


