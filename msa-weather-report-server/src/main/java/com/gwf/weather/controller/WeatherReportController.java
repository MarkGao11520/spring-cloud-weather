package com.gwf.weather.controller;

import com.gwf.weather.service.CityClient;
import com.gwf.weather.service.WeatherReportService;
import com.gwf.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather Report Controller.
 * 
 * @since 1.0.0 2017年11月24日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);  

	@Autowired
	private WeatherReportService weatherReportService;

	@Autowired
	private CityClient cityClient;

	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 获取城市ID列表
		List<City> cityList = null;

		try {
			cityList = cityClient.listCitys();
		} catch (Exception e) {
			logger.error("Exception!", e);
			//TODO 改为自定义API异常
			throw new RuntimeException("获取城市数据列表失败");
		}

		
		model.addAttribute("title", "MarkGao的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
