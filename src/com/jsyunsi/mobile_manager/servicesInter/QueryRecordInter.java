package com.jsyunsi.mobile_manager.servicesInter;

/**
 * 记录查询接口
 * 
 * @author Administrator
 *
 */
public interface QueryRecordInter {

	/**
	 * 交易记录查询
	 * 
	 * @param userID
	 * @return 交易记录
	 */
	String transactionRecordQuery(String userID);

	/**
	 * 短信历史查询
	 * 
	 * @param userID
	 * @return 短信历史
	 */
	String SMSHistoryQueryBySender(String senderID);
	
	String SMSHistoryQueryByReceiver(String receiverID);
}
