package com.gwf.gwf.weather.basic.service;


import com.gwf.gwf.weather.basic.vo.WeatherResponse;

/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.service
 * @describe WeatherDataService
 * @date 2018/2/20
 */
public interface WeatherDataService {
	/**
	 * 根据城市ID查询天气数据
	 * 
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);

	/**
	 * 根据城市名称查询天气数据
	 * 
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);

	/**
	 * 根据城市Id来同步数据
	 * @param cityId
	 */
	void syncDataByCityId(String cityId);

	/**
	 * 根据城市名称来同步数据
	 * @param cityName
	 */
	void syncDataByCityName(String cityName);
	
}
