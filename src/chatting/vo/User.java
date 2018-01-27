package chatting.vo;

/**
 * 用户数据类
 * 
 * @author 紫风铃
 *
 */
public class User {
	/** 用户id，手机号 */
	String userID;
	/** 是否被冻结 */
	boolean frozenStatus;
	/** 余额 */
	float balance;
	/** 是否开通SP服务 */
	boolean openSP;
	/** 密码 */
	String password;

	public User() {
		super();
	}

	public User(String userID, boolean frozenStatus, float balance, boolean openSP, String password) {
		super();
		this.userID = userID;
		this.frozenStatus = frozenStatus;
		this.balance = balance;
		this.openSP = openSP;
		this.password = password;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
