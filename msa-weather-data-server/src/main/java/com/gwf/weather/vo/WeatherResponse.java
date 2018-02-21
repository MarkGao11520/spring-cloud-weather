package com.gwf.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Weather Response.
 * 
 * @since 1.0.0 2017年11月21日
 * @author gaowenfeng
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Weather data;
	private Integer status;
	private String desc;


	public Map<String, Object> toMap() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("status", status);
		result.put("desc", desc);
		result.put("data", data);
		return result;
	}
}
