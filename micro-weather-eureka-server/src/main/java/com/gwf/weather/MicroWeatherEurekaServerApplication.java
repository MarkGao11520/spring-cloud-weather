package com.gwf.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 启动类
 * @author gaowenfeng
 *
 * @EnableEurekaServer  启用Eureka Server
 */
@SpringBootApplication
@EnableEurekaServer
public class MicroWeatherEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroWeatherEurekaServerApplication.class, args);
	}
}
