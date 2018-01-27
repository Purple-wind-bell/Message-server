package chatting.vo;

/**
 * 存储用户udp穿透信息
 * 
 * @author 紫风铃
 *
 */
public class UserOnline {
	/** 用户id，手机号 */
	String userID;
	/** 在线状态 */
	boolean onlineStatus;
	/** 登录的公网IP */
	String userIP;
	/** 穿透端口 */
	int port;

	public UserOnline() {
		super();
	}

	public UserOnline(String userID, boolean onlineStatus, String userIP, int port) {
		super();
		this.userID = userID;
		this.onlineStatus = onlineStatus;
		this.userIP = userIP;
		this.port = port;
	}

	public String getUserID() {
		return userID;
	}

	public boolean isOnlineStatus() {
		return onlineStatus;
	}

	public String getUserIP() {
		return userIP;
	}

	public int getPort() {
		return port;
	}

}
