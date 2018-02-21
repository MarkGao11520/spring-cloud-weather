package com.gwf.weather.service;

/**
 * @author gaowenfeng
 * @package com.gwf.weather.service
 * @describe 天气数据采集接口
 * @date 2018/2/21
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市Id同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
