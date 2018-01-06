package com.jsyunsi.mobile_manager.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.jsyunsi.mobile_manager.dao.WeatherDao;
import com.jsyunsi.mobile_manager.daoInter.WeatherDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryWeatherInter;
import com.jsyunsi.mobile_manager.vo.Weather;

public class QueryWeatherService implements QueryWeatherInter {
	WeatherDaoInter weatherDao = new WeatherDao();

	@Override
	public String queryWeather(String cityID, Date date) {
		// TODO Auto-generated method stub
		ArrayList<Weather> list = weatherDao.getRecord(cityID);
		String result = "无天气记录";
		Iterator<Weather> iterator = list.iterator();
		while (iterator.hasNext()) {
			Weather w = (Weather) iterator.next();
			// if (w.getDate().equals(date)) {
			result = w.getStatus();
			// }
		}
		return result;
	}

}
