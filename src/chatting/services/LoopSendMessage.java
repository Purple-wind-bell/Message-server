package chatting.services;

import java.util.HashMap;
import java.util.Map.Entry;

import chatting.util.UDPSender;
import chatting.vo.Message;
import chatting.vo.UserOnline;

/**
 * udp穿透轮询发送消息
 * 
 * @author Administrator
 *
 */
public class LoopSendMessage {
	private static HashMap<UserOnline, Message<?>> sendList;

	static {
		// 创建线程轮询发送信息
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					// //通过Map.entrySet遍历key和value
					for (Entry<UserOnline, Message<?>> entry : sendList.entrySet()) {
						UserOnline key = entry.getKey();// 获得键
						Message<?> value = entry.getValue();// 获得值
						if (UDPSender.sendPackage(key, value)) {
							sendList.remove(key, value);// 发送成功，从轮询列表中删除该消息
						}
					}
					// 休眠
					try {
						new Thread();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}).start();
	}

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
		// 获取目标用户在线信息
		UserOnline uOnline = new UserOnline();
		int status = 2;
		// 查询用户在线信息
		if (uOnline == null) {
			// 用户不存在
			status = 2;
		} else {
			// 发送信息
			if (uOnline.isOnlineStatus() == true && UDPSender.sendPackage(uOnline, message)) {
				status = 1;// 在线发送成功
			} else {
				sendList.put(uOnline, message);// 不在线， 加入轮询表
				status = 3;
			}
		}

		return status;
	}

}