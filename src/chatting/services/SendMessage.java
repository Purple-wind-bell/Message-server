package chatting.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import chatting.dao.UserDao;
import chatting.daoInter.UserDaoInter;
import chatting.util.Constant;
import chatting.util.FormatUtil;
import chatting.vo.FormatSMS;
import chatting.vo.User;

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
		User user = uDao.getUser(targetAddress);
		IP = user.getUserIP();
		if (IP.equals("0.0.0.0") || user.isFrozenStatus() || !user.isOnlineStatus()) {
			status = false;
		} else {
			try {
				socket = new Socket(IP, PORT);
				pWriter = new PrintWriter(socket.getOutputStream());
				String outString = FormatUtil.toStringSMS(sms);
				System.out.println(outString);
				pWriter.println(outString);// 发送
				pWriter.flush();
				// System.out.println("SendMessage:短信已发送");
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