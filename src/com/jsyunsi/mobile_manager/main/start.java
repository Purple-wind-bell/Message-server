package com.jsyunsi.mobile_manager.main;

import com.jsyunsi.mobile_manager.services.RegisterServer;
import com.jsyunsi.mobile_manager.services.SMSServer;

/**
 * 服务器启动
 * 
 * @author Administrator
 *
 */
public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("开始监听注册服务器...");
		new RegisterServer().start();
		System.out.println("开始监听消息服务器...");
		new SMSServer().start();
	}
}
