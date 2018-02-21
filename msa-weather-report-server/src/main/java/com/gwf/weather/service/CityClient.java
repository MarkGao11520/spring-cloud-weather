package com.gwf.weather.service;

import com.gwf.weather.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author gaowenfeng
 * @package com.gwf.weather.service
 * @describe Feign访问城市数据API服务接口
 * @date 2018/2/21
 */
@FeignClient("msa-weather-city-server")
public interface CityClient {

    @GetMapping("cities")
    List<City> listCitys() throws Exception;
}
