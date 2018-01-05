package com.jsyunsi.mobile_manager.services;

import java.io.PrintWriter;
import java.net.Socket;

import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.vo.FormatSMS;

/**
 * 一次性发送socket，发送完成后释放
 * 
 * @author Administrator
 *
 */
public class SendSocket extends Thread {
	/** 创建端口 */
	Socket socket = null;
	/** 端口号 */
	int PORT = 5600;
	/** IP地址 */
	String IP = "127.0.0.1";
	/** SMS */
	FormatSMS sms = null;
	PrintWriter pWriter = null;
	UserDaoInter uDao = new UserDao();

	/**
	 * 发送短信
	 * 
	 * @param ip
	 *            目标
	 * @param formatSMS
	 *            短信
	 */
	public SendSocket(FormatSMS formatSMS) {
		super();
		this.sms = formatSMS;
		String targetAddress = formatSMS.getTargetAddress();
		IP = uDao.getUser(targetAddress).getUserIP();
	}

	@Override
	public void run() {
		try {
			socket = new Socket(IP, PORT);
			pWriter = new PrintWriter(socket.getOutputStream());
			String outString = FormatService.toStringSMS(sms);
			outString = outString + "\n";
			pWriter.println(outString);// 发送
			pWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}