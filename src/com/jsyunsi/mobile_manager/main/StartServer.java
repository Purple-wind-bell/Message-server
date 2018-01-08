package com.jsyunsi.mobile_manager.main;

/**
 * 服务器启动
 * 
 * @author Administrator
 *
 */
public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterServer().start();
		System.out.println("启动注册服务器...");
		new SMSServer().start();
		System.out.println("启动消息服务器...");
	}

}
