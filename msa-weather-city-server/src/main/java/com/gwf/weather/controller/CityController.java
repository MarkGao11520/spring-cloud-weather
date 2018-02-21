package com.gwf.weather.controller;

import com.gwf.weather.service.CityDataService;
import com.gwf.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gaowenfeng
 * @package com.gwf.weather.controller
 * @describe 城市服务
 * @date 2018/2/21
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @RequestMapping
    public List<City> listCity(){
        try {
            return cityDataService.listCity();
        } catch (Exception e) {
            // TODO 封装成自定义API异常
            throw new RuntimeException(e);
        }
    }
}
