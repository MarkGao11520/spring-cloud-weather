package com.gwf.gwf.weather.basic.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @package com.gwf.gwf.weather.basic.vo
 * @describe 天气VO
 * @author gaowenfeng
 * @date 2018/2/20
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Weather implements Serializable{
    private static final long serialVersionUID = 1L;

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;

}

