package chatting.daoInter;

import java.util.ArrayList;
import java.util.Date;

import chatting.vo.Weather;

/**
 * 天气数据管理接口
 * 
 *
 */
public interface WeatherDaoInter {
	/**
	 * 添加天气记录
	 * 
	 * @param weather
	 * @return true-添加成功
	 */
	boolean addRecord(Weather weather);

	/**
	 * 根据时间删除天气记录
	 * 
	 * @param date
	 * @return true-删除成功
	 */
	boolean delRecord(Date date);

	/**
	 * 通过城市ID查询天气
	 * 
	 * @param cityID
	 * @return 一段时间内天气的list
	 */
	ArrayList<Weather> getRecord(String cityID);
}
