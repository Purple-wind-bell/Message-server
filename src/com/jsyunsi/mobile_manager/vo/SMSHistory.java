package com.jsyunsi.mobile_manager.vo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * SMS历史记录类
 * 
 * @author 紫风铃
 *
 */
public class SMSHistory {
	/** 发件人id，手机号 */
	String senderID;
	/** 收件人id，手机号 */
	String receiverID;
	/** 发件时间 */
	Timestamp sendTime;
	/** 短信内容 */
	String message;

	public SMSHistory() {
		super();
	}

	public SMSHistory(String senderID, String receiverID, Timestamp sendTime, String message) {
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

	public String getMessage() {
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

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "发件人:" + senderID + "\t收件人:" + receiverID + "\t发件时间:" + sendTime + "\t短信内容 :"
				+ message;
		return string;
	}

}
