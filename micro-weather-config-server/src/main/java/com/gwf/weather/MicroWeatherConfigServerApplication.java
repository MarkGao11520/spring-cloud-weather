package com.gwf.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Eureka 客户端启动类
 * @author gaowenfeng
 * 启用Eureka客户端
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class MicroWeatherConfigServerApplication {


	public static void main(String[] args) {
		SpringApplication.run(MicroWeatherConfigServerApplication.class, args);
	}
}
