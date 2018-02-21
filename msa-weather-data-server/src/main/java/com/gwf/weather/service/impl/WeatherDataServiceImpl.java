package com.gwf.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwf.weather.service.WeatherDataService;
import com.gwf.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
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
public class WeatherDataServiceImpl implements WeatherDataService {

    @Value("${weather.uri}")
    private String weatherUri;

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


    private String buildUri(String param, String s) {
        return new StringBuilder().append(weatherUri).append(s).append("=").append(param).toString();
    }


    /**
     * 获取天气数据
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) {

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse response;
        String strBody;
        if (stringRedisTemplate.hasKey(uri)) {
            strBody = stringRedisTemplate.opsForValue().get(uri);
        } else {
            log.error("查询数据不存在,key:"+uri);
            // TODO 自定义异常
            throw new RuntimeException("查询数据不存在");
        }

        try {
            response = objectMapper.readValue(strBody,WeatherResponse.class);
        } catch (IOException e) {
            log.error("数据转换异常",e);
            // TODO 自定义异常
            throw new RuntimeException("数据转换异常");
        }

        return response;
    }

}
