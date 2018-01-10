package com.jsyunsi.mobile_manager.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 工具类
 * 
 * @author Administrator
 *
 */
public class Tools {

	private Tools() {
	}

	/**
	 * 判断是否是IP
	 * 
	 * @param ip
	 * @return
	 */
	public static boolean isIp(String ip) {
		boolean b = false;
		ip = ip.trim();
		if (ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
			String s[] = ip.split("\\.");
			if (Integer.parseInt(s[0]) < 255 && Integer.parseInt(s[1]) < 255 && Integer.parseInt(s[2]) < 255
					&& Integer.parseInt(s[3]) < 255) {
				b = true;
			}
		}
		return b;
	}

	/**
	 * 判断host是否可以连接
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public static boolean isHostConnectable(String host, int port) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
