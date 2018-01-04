package com.jsyunsi.mobile_manager.services;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * 一次性发送socket，发送完成后释放
 * 
 * @author Administrator
 *
 */
public class SMSForwardSocket extends Thread {
	/** 创建端口 */
	Socket socket = null;
	/** 端口号 */
	int PORT = 5600;
	/** IP地址 */
	String IP = "127.0.0.1";
	/** SMS */
	String sms = null;
	PrintWriter pWriter = null;

	public SMSForwardSocket(String ip, String sms) {
		super();
		this.IP = ip;
		this.sms = sms;
		try {
			socket = new Socket(IP, PORT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			pWriter = new PrintWriter(socket.getOutputStream());
			pWriter.println(sms);// 发送
			pWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}