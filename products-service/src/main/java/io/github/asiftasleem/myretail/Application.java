package io.github.asiftasleem.myretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * @author muhammad.tasleem
 *
 */
@EnableEurekaClient
@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
@PropertySource(value = { "classpath:/environment.properties" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


