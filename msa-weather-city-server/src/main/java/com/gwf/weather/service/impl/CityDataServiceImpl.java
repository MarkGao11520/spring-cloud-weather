package com.gwf.weather.service.impl;

import com.gwf.weather.service.CityDataService;
import com.gwf.weather.util.XmlBuilter;
import com.gwf.weather.vo.City;
import com.gwf.weather.vo.CityList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaowenfeng
 * @package com.gwf.weather.service.impl
 * @describe 城市列表服务实现
 * @date 2018/2/21
 */
@Service
@Slf4j
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        /**
         * 读取XML文件
         * 将文件里的内容转换为java对象
         */
        CityList list = null;
        try {
            Resource resource = new ClassPathResource("citylist.xml");
            String xmlStr = FileUtils.readFileToString(resource.getFile(),"UTF-8");

            list = XmlBuilter.xmlStrToObject(CityList.class,xmlStr);
        } catch (Exception e) {
            // TODO 自定义异常
            throw new Exception("文件转换异常");
        }

        return list.getCityList();
    }
}
