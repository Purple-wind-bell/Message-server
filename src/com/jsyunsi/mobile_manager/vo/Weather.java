package com.jsyunsi.mobile_manager.vo;

import java.util.Date;

/**
 * 天气类
 * 
 * @author 紫风铃
 *
 */
public class Weather {
	/** 城市id */
	String cityID;
	/** 城市名称 */
	String cityName;
	/** 日期 */
	Date date;
	/** 天气状态 */
	String status;

	public Weather() {
		super();
	}

	public Weather(String cityID, String cityName, Date date, String status) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
		this.date = date;
		this.status = status;
	}

	public String getCityID() {
		return cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public Date getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
