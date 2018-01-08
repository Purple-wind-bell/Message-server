package com.jsyunsi.mobile_manager.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * 参数配置
 * 
 * @author Administrator
 *
 */
public final class Constant {
	/** MySQL数据库连接 */
	static String mysqlUrl;
	/** MySQL用户 */
	static String mysqlUser;
	/** MySQL用户密码 */
	static String mysqlPasswd;
	/** 客户端普通短信接收端口 */
	static int clientSMSPort;
	/** 服务器普通短信收发端口 */
	static int serverSMSPort;
	/** 服务器注册登录端口 */
	static int registerPort;

	static {
		Properties p = new Properties();
		InputStream in = Constant.class.getClassLoader().getResourceAsStream("mobile.properties");
		try {
			p.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mysqlUrl = p.getProperty("mysqlUrl");
		mysqlUser = p.getProperty("mysqlUser");
		mysqlPasswd = p.getProperty("mysqlPasswd");
		clientSMSPort = Integer.parseInt(p.getProperty("clientSMSPort"));
		serverSMSPort = Integer.parseInt(p.getProperty("serverSMSPort"));
		registerPort = Integer.parseInt(p.getProperty("registerPort"));
	}

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
