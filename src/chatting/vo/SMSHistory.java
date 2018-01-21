package chatting.vo;

import java.sql.Timestamp;

/**
 * Message历史记录类
 * 
 * @author 紫风铃
 *
 * @param <T>
 *            消息内容类
 */
public class SMSHistory<T> {
	/** 发件人id，手机号 */
	String senderID;
	/** 收件人id，手机号 */
	String receiverID;
	/** 发件时间 */
	Timestamp sendTime;
	/** 短信内容 */
	T message;

	public SMSHistory() {
		super();
	}

	public SMSHistory(String senderID, String receiverID, Timestamp sendTime, T message) {
		super();
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.sendTime = sendTime;
		this.message = message;
	}

	public String getSenderID() {
		return senderID;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public T getMessage() {
		return message;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public void setMessage(T message) {
		this.message = message;
	}

}
