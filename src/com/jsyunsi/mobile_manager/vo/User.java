package com.jsyunsi.mobile_manager.vo;

/**
 * 用户数据类
 * 
 * @author 紫风铃
 *
 */
public class User {
	/** 用户id，手机号 */
	String userID;
	/** 手机号注册IP */
	String userIP;
	/** 在线状态 */
	boolean onlineStatus;
	/** 手机号是否被冻结 */
	boolean frozenStatus;
	/** 手机号余额 */
	float balance;
	/** 是否开通SP服务 */
	boolean openSP;

	public User() {
		super();
	}

	public User(String userID, String userIp, boolean onlineStatus, boolean frozenStatus, float balance,
			boolean openSP) {
		super();
		this.userID = userID;
		this.userIP = userIp;
		this.onlineStatus = onlineStatus;
		this.frozenStatus = frozenStatus;
		this.balance = balance;
		this.openSP = openSP;
	}

	public String getUserID() {
		return userID;
	}

	public String getUserIP() {
		return userIP;
	}

	public boolean isOnlineStatus() {
		return onlineStatus;
	}

	public boolean isFrozenStatus() {
		return frozenStatus;
	}

	public float getBalance() {
		return balance;
	}

	public boolean isOpenSP() {
		return openSP;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	public void setOnlineStatus(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public void setFrozenStatus(boolean frozenStatus) {
		this.frozenStatus = frozenStatus;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public void setOpenSP(boolean openSP) {
		this.openSP = openSP;
	}

}
