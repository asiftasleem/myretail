/**
 * 
 */
package io.github.asiftasleem.myretail.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author muhammad.tasleem
 *
 */
@Configuration
@EnableCaching
public class CachingConfig {
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		return ehCacheManagerFactoryBean;
	}
}
