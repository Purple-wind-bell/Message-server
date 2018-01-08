package com.jsyunsi.mobile_manager.servicesInter;

import java.util.Date;

/**
 * 天气查询服务接口
 * 
 *
 */
public interface QueryWeatherInter {

	/**
	 * 查询天气
	 * 
	 * @param userID
	 * 
	 * @param cityID
	 *            城市ID
	 * @param date
	 *            时间
	 * @return 天气字符串
	 */
	String queryWeather(String userID, String cityID, Date date);
}
