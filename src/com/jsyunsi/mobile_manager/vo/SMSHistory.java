package com.jsyunsi.mobile_manager.vo;

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
	Date sendTime;
	/** 短信内容 */
	String message;

	public SMSHistory() {
		super();
	}

	public SMSHistory(String senderID, String receiverID, Date sendTime, String message) {
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

	public Date getSendTime() {
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

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "发件人:" + senderID + "\n收件人:" + receiverID + "\n发件时间:" + sendTime + "\n短信内容 :"
				+ message + "\n";
		return string;
	}

}
