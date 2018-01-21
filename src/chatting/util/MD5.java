package chatting.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类，该加密一般用于密码加密处理，加密过程不可逆，无法解密
 * 
 * @author 紫风铃
 *
 */
public class MD5 {

	private MD5() {
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
