package com.jsyunsi.mobile_manager.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class QueryWeatherServiceTest {

	@Test
	public void testQueryWeather() {
		System.out.println(new QueryWeatherService().queryWeather("2", new Date()));

	}

}
