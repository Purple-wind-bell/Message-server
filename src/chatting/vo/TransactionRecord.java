package chatting.vo;

import java.sql.Timestamp;

/**
 * 交易记录类
 * 
 * @author 紫风铃
 *
 */
public class TransactionRecord {
	/** 用户id */
	String userID;
	/** SP服务id */
	String spID;
	/** 业务服务费 */
	float charge;
	/** 交易时间 */
	Timestamp tradingTime;
	/** 交易备注 */
	String remarks;

	public TransactionRecord() {
		super();
	}

	public TransactionRecord(String userID, String spID, float charge, Timestamp tradingTime, String remarks) {
		super();
		this.userID = userID;
		this.spID = spID;
		this.charge = charge;
		this.tradingTime = tradingTime;
		this.remarks = remarks;
	}

	public String getUserID() {
		return userID;
	}

	public String getSpID() {
		return spID;
	}

	public float getCharge() {
		return charge;
	}

	public Timestamp getTradingTime() {
		return tradingTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setSpID(String spID) {
		this.spID = spID;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

	public void setTradingTime(Timestamp tradingTime) {
		this.tradingTime = tradingTime;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "用户:" + userID + "\tSP服务id:" + spID + "\t业务服务费: " + Float.toString(charge) + "\t交易时间: "
				+ tradingTime.toString() + "\t交易备注: " + remarks;
		return string;
	}

}
