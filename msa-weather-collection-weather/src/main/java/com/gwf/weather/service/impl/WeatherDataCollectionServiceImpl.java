package com.gwf.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwf.weather.service.WeatherDataCollectionService;
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
 * @package com.gwf.weather.service.impl
 * @describe 天气数据采集服务实现
 * @date 2018/2/21
 */
@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService{
    @Value("${weather.uri}")
    private String weatherUri;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Long TIME_OUT = 1800L;

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = buildUri(cityId, "citykey");
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
        ResponseEntity<String> respString = restTemplate.getForEntity(uri,String.class);

        String strBody = null;

        if(HttpStatus.OK.equals(respString.getStatusCode())){
            strBody = respString.getBody();
        }

        //TODO 对返回值做校验

        stringRedisTemplate.opsForValue().set(uri,strBody,TIME_OUT, TimeUnit.SECONDS);
        return strBody;
    }
}
