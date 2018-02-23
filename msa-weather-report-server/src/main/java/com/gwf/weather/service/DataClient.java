package com.gwf.weather.service;

import com.gwf.weather.vo.City;
import com.gwf.weather.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author gaowenfeng
 * @package com.gwf.weather.service
 * @describe Feign访问城市数据API服务接口
 * @date 2018/2/21
 */
@FeignClient("micro-weather-eureka-client")
public interface DataClient {

    /**
     * 访问 micro-weather-eureka-client API网关获取城市数据
     * @return
     * @throws Exception
     */
    @GetMapping("city/cities")
    List<City> listCities() throws Exception;

    /**
     * 访问micro-weather-eureka-client API网关 获取天气数据
     * @param cityId
     * @return
     */
    @GetMapping("data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}
