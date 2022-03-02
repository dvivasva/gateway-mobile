package com.dvivasva.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration;

@SpringBootApplication
public class GatewayMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayMobileApplication.class, args);
	}

}
