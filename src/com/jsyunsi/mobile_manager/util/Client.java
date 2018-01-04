package com.jsyunsi.mobile_manager.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
	/** 创建端口 */
	Socket socket = null;
	/** 端口号 */
	int PORT = 5600;
	/** IP地址 */
	String IP = "127.0.0.1";
	/** SMS */
	String sms = null;
	BufferedReader bReader = null;
	PrintWriter pWriter = null;

	public Client(String ip, String sms) {
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
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pWriter = new PrintWriter(socket.getOutputStream());
			String get = bReader.readLine();
			while (true) {
				if (get != null & get.length() > 0) {
					pWriter.println(get);
					pWriter.flush();
				}
				if (bReader != null) {
					String line = bReader.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}