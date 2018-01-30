package chatting.util;

import chatting.vo.UserOnline;

/**
 * 发送udp报文
 * 
 * @author 紫风铃
 *
 */
public class UDPSender {

	/**
	 * udp 报文发送方法
	 * 
	 * @param uOnline
	 *            目标地址信息
	 * @param t
	 * @return true--收到回复信息；false--未收到回复信息
	 */
	public static <T> boolean sendPackage(UserOnline uOnline, T t) {
		return false;

	}
}
