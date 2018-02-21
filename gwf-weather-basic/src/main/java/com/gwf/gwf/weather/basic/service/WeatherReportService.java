package com.gwf.gwf.weather.basic.service;


import com.gwf.gwf.weather.basic.vo.Weather;

/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月24日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
