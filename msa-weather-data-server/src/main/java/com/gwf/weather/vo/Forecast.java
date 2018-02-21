package com.gwf.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 未来天气.
 * 
 * @since 1.0.0 2017年11月21日
 * @author gaowenfeng
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Forecast implements Serializable {

	private static final long serialVersionUID = 1L;
	private String date;
	private String high;
	private String fengli;
	private String low;
	private String fengxiang;
	private String type;

}
