package com.gwf.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author gaowenfeng
 * @package com.gwf.weather.vo
 * @describe 天气实体类与xml映射
 * @date 2018/2/20
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;
}
