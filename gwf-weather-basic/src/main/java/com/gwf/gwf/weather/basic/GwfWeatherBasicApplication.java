package com.gwf.gwf.weather.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @describe 启动类
 * @package com.gwf.gwf.weather.basic
 * @author gaowenfeng
 * @date 2018-02-21
 */
@SpringBootApplication
@EnableScheduling
public class GwfWeatherBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(GwfWeatherBasicApplication.class, args);
	}
}
