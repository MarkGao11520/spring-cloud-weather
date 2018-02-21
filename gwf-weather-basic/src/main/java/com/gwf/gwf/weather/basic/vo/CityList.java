package com.gwf.gwf.weather.basic.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.vo
 * @describe 城市列表结合
 * @date 2018/2/21
 */
@Data
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;
}
