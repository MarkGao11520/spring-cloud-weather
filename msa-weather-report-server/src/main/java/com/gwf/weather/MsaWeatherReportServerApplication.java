package com.gwf.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 启动类
 * @author gaowenfeng
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsaWeatherReportServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaWeatherReportServerApplication.class, args);
	}
}
