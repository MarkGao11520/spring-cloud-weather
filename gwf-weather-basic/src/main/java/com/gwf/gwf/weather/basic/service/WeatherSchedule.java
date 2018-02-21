package com.gwf.gwf.weather.basic.service;

import com.gwf.gwf.weather.basic.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.service
 * @describe 定时同步天气
 * @date 2018/2/20
 */
@Service
@Slf4j
public class WeatherSchedule {

    private static final String LOG_PRE = "weather data sync job->";

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Scheduled(cron = "0 0/5 * * * *")
    public void weatherDataSyncJob(){
        log.info(buildLog("start"));

        List<City> cityList = null;

        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            log.error("获取城市列表失败",e);
        }

        cityList.stream().forEach(city -> {
            String cityId = city.getCityId();
            log.info(buildLog("cityId:"+cityId));

            weatherDataService.syncDataByCityName(cityId);

        });

        log.info(buildLog("end"));
    }

    private String buildLog(String msg){
        return new StringBuilder().append(LOG_PRE).append(msg).toString();
    }
}
