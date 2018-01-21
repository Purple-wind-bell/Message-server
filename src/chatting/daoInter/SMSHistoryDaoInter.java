package chatting.daoInter;

import java.util.ArrayList;

import chatting.vo.SMSHistory;

/**
 * SMS历史记录管理接口
 * 
 *
 */
public interface SMSHistoryDaoInter {

	/**
	 * 添加短信历史记录
	 * 
	 * @param smsHistory
	 *            sms历史记录
	 * @return true:添加成功
	 */
	boolean addSMSHistory(SMSHistory smsHistory);

	/**
	 * 根据发件人查询短信记录
	 * 
	 * @param senderID
	 *            发件人ID
	 * @return 短信记录的list
	 */
	ArrayList<SMSHistory> querySMSHistoryBySenderID(String senderID);

	/**
	 * 根据收件人查询短信记录
	 * 
	 * @param receiverID
	 *            收件人ID
	 * @return 短信记录的list
	 */
	ArrayList<SMSHistory> querySMSHistoryByReceiverID(String receiverID);
}
