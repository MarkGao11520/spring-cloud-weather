package com.gwf.gwf.weather.basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gwf.gwf.weather.basic.service.WeatherDataService;
import com.gwf.gwf.weather.basic.service.WeatherReportService;
import com.gwf.gwf.weather.basic.vo.Forecast;
import com.gwf.gwf.weather.basic.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月26日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {


	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		return weatherDataService.getDataByCityId(cityId).getData();
	}

}
