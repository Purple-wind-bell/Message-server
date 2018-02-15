package chatting.util;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	/**
	 * 将字符串进行MD5加密
	 * 
	 * @param string
	 *            要加密的字符串
	 * @return 经过MD5加密得到的结果，以16进制字符串形式返回
	 */
	public static String toMD5(String string) {
		// TODO Auto-generated method stub
		MessageDigest mDigest;
		String result = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
			mDigest.update(string.getBytes());
			result = new BigInteger(mDigest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
