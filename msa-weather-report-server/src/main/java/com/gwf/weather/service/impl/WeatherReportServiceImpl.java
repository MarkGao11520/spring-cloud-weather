package com.gwf.weather.service.impl;

import com.gwf.weather.service.WeatherDataClient;
import com.gwf.weather.service.WeatherReportService;
import com.gwf.weather.vo.Forecast;
import com.gwf.weather.vo.Weather;
import com.gwf.weather.vo.WeatherResponse;
import com.gwf.weather.vo.Yesterday;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月26日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
@Slf4j
public class WeatherReportServiceImpl implements WeatherReportService {

	private static final int SUCCESS_CODE = 1000;

	@Autowired
	private WeatherDataClient weatherDataClient;


	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse response = weatherDataClient.getDataByCityId(cityId);

		if(SUCCESS_CODE!=response.getStatus()){
			log.error("获取天气数据失败,失败原因:"+response.getDesc());
			throw new RuntimeException("获取天气数据失败");
		}
		Weather data = response.getData();
		return data;
	}

}
