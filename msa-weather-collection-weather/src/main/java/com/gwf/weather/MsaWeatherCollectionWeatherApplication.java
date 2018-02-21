package com.gwf.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author gaowenfeng
 */
@SpringBootApplication
@EnableScheduling
public class MsaWeatherCollectionWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaWeatherCollectionWeatherApplication.class, args);
	}
}
