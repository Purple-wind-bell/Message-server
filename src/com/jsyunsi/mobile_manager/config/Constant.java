package com.jsyunsi.mobile_manager.config;

/**
 * 参数配置
 * 
 * @author Administrator
 *
 */
public final class Constant {
	/** MySQL数据库连接 */
	static String mysqlUrl = "jdbc:mysql://localhost:3306/mobile_message";
	/** MySQL用户 */
	static String mysqlUser = "root";
	/** MySQL用户密码 */
	static String mysqlPasswd = "123456";
	/** 客户端接收端口 */
	static int clientPort = 5700;
	/** 服务器端口 */
	static int serverPort = 5600;

	private Constant() {
	}

	/**
	 * 获得数据库url
	 * 
	 * @return string类型的url
	 */
	public static String getMysqlUrl() {
		return mysqlUrl;
	}

	/**
	 * 获得MySQL用户名
	 * 
	 * @return 用户名
	 */
	public static String getMysqlUser() {
		return mysqlUser;
	}

	/**
	 * 获得MySQL用户密码
	 * 
	 * @return 密码
	 */
	public static String getMysqlPasswd() {
		return mysqlPasswd;
	}

	public static int getClientPort() {
		return clientPort;
	}

	public static int getServerPort() {
		return serverPort;
	}

}
