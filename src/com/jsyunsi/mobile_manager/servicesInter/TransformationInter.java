package com.jsyunsi.mobile_manager.servicesInter;

import com.jsyunsi.mobile_manager.vo.FormatSMS;

/**
 * 格式化短信与字符串短信之间的转换
 * 
 * @author Administrator
 *
 */
public interface TransformationInter {

	/**
	 * 将字符串短信转换为格式化的短信对象
	 * 
	 * @param message
	 *            字符串短信
	 * @return 格式化的短信对象
	 */
	FormatSMS toFormatSMS(String message);

	/**
	 * 将格式化的短信对象转化为字符串短信
	 * 
	 * @param FormatSMS
	 *            格式化的短信对象
	 * @return 字符串短信
	 */
	String toStringSMS(FormatSMS formatSMS);
}
