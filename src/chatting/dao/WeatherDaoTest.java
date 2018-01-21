package chatting.dao;

import org.junit.Test;

public class WeatherDaoTest {
	@Test
	public void test() {
		System.out.println(new WeatherDao().getRecord("2"));
	}
}
