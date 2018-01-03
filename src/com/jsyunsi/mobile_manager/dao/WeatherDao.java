package com.jsyunsi.mobile_manager.dao;

import java.util.ArrayList;
import java.util.Date;

import com.jsyunsi.mobile_manager.daoInter.WeatherDaoInter;
import com.jsyunsi.mobile_manager.vo.Weather;

public class WeatherDao implements WeatherDaoInter {

	@Override
	public boolean addRecord(Weather weather) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delRecord(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Weather> getRecord(String cityID) {
		// TODO Auto-generated method stub
		return null;
	}

}
