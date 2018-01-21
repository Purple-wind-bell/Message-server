package chatting.servicesInter;

import java.util.ArrayList;

import chatting.vo.SMSHistory;
import chatting.vo.TransactionRecord;

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
	ArrayList<TransactionRecord> transactionRecordQuery(String userID);

	/**
	 * 根据发件人查询短信历史
	 * 
	 * @param userID
	 * @return 短信历史
	 */
	ArrayList<SMSHistory<String>> SMSHistoryQueryBySender(String senderID);

	/**
	 * 根据收件人查询短信历史
	 * 
	 * @param userID
	 * @return 短信历史
	 */
	ArrayList<SMSHistory<String>> SMSHistoryQueryByReceiver(String receiverID);

	/**
	 * 查询短信收发历史
	 * 
	 * @param userID
	 * @return 短信历史
	 */
	ArrayList<SMSHistory<String>> SMSHistoryQuery(String receiverID);
}
