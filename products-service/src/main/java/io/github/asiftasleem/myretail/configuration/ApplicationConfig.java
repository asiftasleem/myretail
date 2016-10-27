package io.github.asiftasleem.myretail.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;
/**
 * @author muhammad.tasleem
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories("io.github.asiftasleem.myretail.repository")
@EnableCaching
public class ApplicationConfig {	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
