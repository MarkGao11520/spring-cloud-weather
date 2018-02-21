package com.gwf.weather;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author gaowenfeng
 * @package com.gwf.weather.service
 * @describe Feign访问城市数据API服务接口
 * @date 2018/2/21
 */
@FeignClient("msa-weather-city-server")
public interface CityClient {

    @GetMapping("cities")
    String listCitys();
}
