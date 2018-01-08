package com.jsyunsi.mobile_manager.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.dao.WeatherDao;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.daoInter.WeatherDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryWeatherInter;
import com.jsyunsi.mobile_manager.vo.Weather;

public class QueryWeatherService implements QueryWeatherInter {
	WeatherDaoInter weatherDao = new WeatherDao();
	SPDaoInter spdao = new SPDao();
	UserDaoInter userDao = new UserDao();

	@Override
	public String queryWeather(String userID, String cityID, Date date) {
		// TODO Auto-generated method stub
		ArrayList<Weather> list = weatherDao.getRecord(cityID);
		String result = "无天气记录";
		Iterator<Weather> iterator = list.iterator();
		while (iterator.hasNext()) {
			Weather w = (Weather) iterator.next();
			result = w.getStatus();
		}
		return result;
	}

}
