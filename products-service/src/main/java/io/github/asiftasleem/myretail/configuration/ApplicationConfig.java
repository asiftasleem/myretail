package io.github.asiftasleem.myretail.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author muhammad.tasleem
 *
 */
@Configuration
@EnableAutoConfiguration
public class ApplicationConfig {	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
