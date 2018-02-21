package com.gwf.weather.schedule;

import com.gwf.weather.service.WeatherDataCollectionService;
import com.gwf.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author gaowenfeng
 * @package com.gwf.weather.schedule
 * @describe 定时同步天气
 * @date 2018/2/20
 */
@Service
@Slf4j
public class WeatherSchedule {

    private static final String LOG_PRE = "weather data sync job->";


    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;


    @Scheduled(cron = "0 0/5 * * * *")
    public void weatherDataSyncJob(){
        log.info(buildLog("start"));

        //TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;

        try {
            //TODO 改为由城市数据API微服务来提供数据
            cityList = new ArrayList<>();
            City city = City.builder().cityId("101280601").cityName("深圳").build();
            cityList.add(city);
        } catch (Exception e) {
            log.error("获取城市列表失败",e);
        }

        cityList.stream().forEach(city -> {
            String cityId = city.getCityId();
            log.info(buildLog("cityId:"+cityId));

            weatherDataCollectionService.syncDataByCityId(cityId);

        });

        log.info(buildLog("end"));
    }

    private String buildLog(String msg){
        return new StringBuilder().append(LOG_PRE).append(msg).toString();
    }
}
