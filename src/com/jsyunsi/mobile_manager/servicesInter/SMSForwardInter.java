package com.jsyunsi.mobile_manager.servicesInter;

import com.jsyunsi.mobile_manager.vo.FormatSMS;

/**
 * 短信转发服务
 * 
 * @author Administrator
 *
 */
public interface SMSForwardInter {

	/**
	 * 短信转发
	 * 
	 * @param formatSMS
	 * @return true:转发成功
	 */
	boolean forward(FormatSMS formatSMS);

}