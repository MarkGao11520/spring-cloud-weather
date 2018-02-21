package com.gwf.gwf.weather.basic.controller;

import com.gwf.gwf.weather.basic.service.WeatherDataService;
import com.gwf.gwf.weather.basic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.controller
 * @describe 天气控制器
 * @date 2018/2/20
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable(name = "cityId")String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable(name = "cityName")String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }

}
