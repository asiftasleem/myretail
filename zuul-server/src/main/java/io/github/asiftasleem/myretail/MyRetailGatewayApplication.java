package io.github.asiftasleem.myretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MyRetailGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailGatewayApplication.class, args);
	}
}
