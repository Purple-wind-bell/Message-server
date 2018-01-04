package com.jsyunsi.mobile_manager.util;

import com.jsyunsi.mobile_manager.vo.FormatSMS;

/**
 * 格式化短信与字符串短信之间的转换
 * 
 * @author Administrator
 *
 */
public class FormatService {

	private FormatService() {

	}

	/**
	 * 将字符串短信转换为格式化的短信对象
	 * 
	 * @param message
	 *            字符串短信
	 * @return 格式化的短信对象
	 */
	public static FormatSMS toFormatSMS(String message) {
		// TODO Auto-generated method stub
		StringBuilder sms = new StringBuilder(message);
		String cmd = sms.substring(0, 6);
		String sourceAddress = sms.substring(6, 17);
		String targetAddress = sms.substring(17, 28);
		String status = sms.substring(28, 32);
		String SMSContent = sms.substring(32);
		return new FormatSMS(cmd, sourceAddress, targetAddress, status, SMSContent);
	}

	/**
	 * 将格式化的短信对象转化为字符串短信
	 * 
	 * @param FormatSMS
	 *            格式化的短信对象
	 * @return 字符串短信
	 */
	public static String toStringSMS(FormatSMS formatSMS) {
		// TODO Auto-generated method stub
		StringBuilder SMSString = new StringBuilder();
		SMSString.append(formatSMS.getCmd());
		SMSString.append(formatSMS.getSourceAddress());
		SMSString.append(formatSMS.getTargetAddress());
		SMSString.append(formatSMS.getStatus());
		SMSString.append(formatSMS.getSMSContent());
		return SMSString.toString();
	}
}
