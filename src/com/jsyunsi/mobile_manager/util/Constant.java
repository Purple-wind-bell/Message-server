package com.jsyunsi.mobile_manager.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 参数配置
 * 
 * @author Administrator
 *
 */
public final class Constant {
	/** MySQL数据库连接 */
	private static String mysqlUrl = "jdbc:mysql://192.168.3.30:3306/mobile_message";
	/** MySQL用户 */
	private static String mysqlUser = "root";
	/** MySQL用户密码 */
	private static String mysqlPasswd = "123456";
	/** 客户端普通短信接收端口 */
	private static int clientSMSPort = 5700;
	/** 服务器普通短信收发端口 */
	private static int serverSMSPort = 5600;
	/** 服务器注册登录端口 */
	private static int registerPort = 5650;

	// static {
	// Properties p = new Properties();
	// // com/jsyunsi/mobile_manager/config/
	// InputStream in =
	// Constant.class.getClassLoader().getResourceAsStream("mobile.properties");
	// try {
	// p.load(in);
	// in.close();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// mysqlUrl = p.getProperty("mysqlUrl");
	// mysqlUser = p.getProperty("mysqlUser");
	// mysqlPasswd = p.getProperty("mysqlPasswd");
	// clientSMSPort = Integer.parseInt(p.getProperty("clientSMSPort"));
	// serverSMSPort = Integer.parseInt(p.getProperty("serverSMSPort"));
	// registerPort = Integer.parseInt(p.getProperty("registerPort"));
	// }

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

	public static int getClientSMSPort() {
		return clientSMSPort;
	}

	public static int getServerSMSPort() {
		return serverSMSPort;
	}

	public static int getRegisterPort() {
		return registerPort;
	}

}
