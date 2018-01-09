package com.jsyunsi.mobile_manager.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.util.Constant;
import com.jsyunsi.mobile_manager.util.FormatUtil;
import com.jsyunsi.mobile_manager.vo.FormatSMS;
import com.jsyunsi.mobile_manager.vo.User;

/**
 * 一次性发送socket，发送完成后释放
 * 
 * @author Administrator
 *
 */
public class SendMessage {
	/** 创建端口 */
	Socket socket = null;
	/** 端口号 */
	int PORT = Constant.getClientSMSPort();
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
	public SendMessage(FormatSMS formatSMS) {
		super();
		this.sms = formatSMS;
	}

	/**
	 * 短信发送
	 * 
	 * @return true-发送成功；false-发送失败，对方可能不在线
	 */
	public boolean send() {
		boolean status = false;
		String targetAddress = sms.getTargetAddress();
		System.out.println(targetAddress);
		User user = uDao.getUser(targetAddress);
		System.out.println(user.getUserID());
		IP = user.getUserIP();
		if (IP.equals("0.0.0.0") || user.isFrozenStatus() || !user.isOnlineStatus()) {
			status = false;
		} else {
			try {
				socket = new Socket(IP, PORT);
				pWriter = new PrintWriter(socket.getOutputStream());
				String outString = FormatUtil.toStringSMS(sms);
				pWriter.println(outString);// 发送
				pWriter.flush();
				System.out.println("SendMessage:短信已发送");
				status = true;
			} catch (Exception e) {
				e.printStackTrace();
				status = false;
			} finally {
				try {
					pWriter.close();// 关闭连接
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;
	}
}