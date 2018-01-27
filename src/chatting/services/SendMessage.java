package chatting.services;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;

import chatting.vo.Message;
import chatting.vo.UserOnline;

/**
 * udp穿透轮询发送消息
 * 
 * @author Administrator
 *
 */
public class SendMessage {
	private static HashMap<UserOnline, Message<?>> sendList;

	/**
	 * 外部调用的Message发送方法
	 * 
	 * @param userID
	 *            目标用户ID
	 * @param message
	 *            消息对象
	 * @return 第一次请求发送结果状态码，1---发送成功；2---发送失败，用户不存在，消息取消；3---发送失败，用户不在线，加入轮询表
	 */
	public static int callTransmitter(String userID, Message<?> message) {
		UserOnline uOnline = new UserOnline();
		sendList.put(uOnline, message);
		return 0;
	}

}