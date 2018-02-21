package com.gwf.gwf.weather.basic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwf.gwf.weather.basic.service.WeatherDataService;
import com.gwf.gwf.weather.basic.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.service.impl
 * @describe 获取天气数据实现类
 * @date 2018/2/20
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService{

    @Value("${weather.uri}")
    private String weatherUri;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Long TIME_OUT = 1800L;


    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = buildUri(cityId, "citykey");
        return doGetWeather(uri);
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = buildUri(cityName, "city");
        return doGetWeather(uri);
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = buildUri(cityId, "citykey");
        saveWeatherData(uri);
    }

    @Override
    public void syncDataByCityName(String cityName) {
        String uri = buildUri(cityName, "city");
        saveWeatherData(uri);
    }

    private String buildUri(String param, String s) {
        return new StringBuilder().append(weatherUri).append(s).append("=").append(param).toString();
    }

    /**
     * 将数据放在缓存中
     * @param uri
     */
    private String saveWeatherData(String uri){
        String strBody = null;

        ResponseEntity<String> respString = restTemplate.getForEntity(uri,String.class);

        if(HttpStatus.OK.equals(respString.getStatusCode())){
            strBody = respString.getBody();
        }

        stringRedisTemplate.opsForValue().set(uri,strBody,TIME_OUT, TimeUnit.SECONDS);
        return strBody;
    }

    /**
     * 获取天气数据
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) {

        WeatherResponse response;
        response = null;
        String strBody = null;
        if (stringRedisTemplate.hasKey(uri)) {
            strBody = stringRedisTemplate.opsForValue().get(uri);
        } else {
            strBody = saveWeatherData(uri);
        }

        try {
            response = objectMapper.readValue(strBody,WeatherResponse.class);
        } catch (IOException e) {
            log.error("获取城市数据异常",e);
        }

        return response;
    }

}
