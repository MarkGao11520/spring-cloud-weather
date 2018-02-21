package com.gwf.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Eureka 客户端启动类
 * @author gaowenfeng
 * 启用Eureka客户端
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class MicroWeatherEurekaClientApplication {

	@Autowired
	private CityClient cityClient;

	@RequestMapping("test")
	public String test(){
		return cityClient.listCitys();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroWeatherEurekaClientApplication.class, args);
	}
}
