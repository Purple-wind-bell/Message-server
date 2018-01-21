package chatting.util;

/**
 * 消息检测类，主要用于生成消息校验码以及消息校验
 * 
 * @author 紫风铃
 *
 */
public class MessageCheck {
	private MessageCheck() {
	}

	/**
	 * 根据输入字符串，获得奇偶校验码，此处方法采用bit位1的奇校验， 判断字符串bit化后1的数目
	 * 
	 * @param messageString
	 *            输入的字符串
	 * @return 奇校验字符串，返回长度为1的的字符串， 返回值：messageString字符串bit化后1的数目为奇数，返回字符串"1"；
	 *         messageString字符串bit化后1的数目为偶数，返回字符串"0"；
	 */
	public static String getParityCode(String messageString) {
		byte[] b = messageString.getBytes();
		String bitStr;
		int num = 0;
		for (int i = 0; i < b.length; i++) {
			bitStr = byteToBit(b[i]);
			for (int j = 0; j < bitStr.length(); j++) {
				if (bitStr.charAt(j) == '1') {
					num++;
				}
			}
		}
		return num % 2 == 0 ? "0" : "1";

	}

	/**
	 * 将byte转换为一个字符串
	 * 
	 * @param b
	 *            输入byte
	 * @return String类型的bit数据，例如byte：1 ——>String："00000001"
	 * 
	 */
	private static String byteToBit(byte b) {
		return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1) + (byte) ((b >> 5) & 0x1)
				+ (byte) ((b >> 4) & 0x1) + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1) + (byte) ((b >> 1) & 0x1)
				+ (byte) ((b >> 0) & 0x1);
	}

	/**
	 * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
	 * 
	 * @param b
	 *            输入byte
	 * @return byte数组的bit数据,每个元素对应b的bit位数字
	 */
	@SuppressWarnings("unused")
	private static byte[] getBooleanArray(byte b) {
		byte[] array = new byte[8];
		for (int i = 7; i >= 0; i--) {
			array[i] = (byte) (b & 1);
			b = (byte) (b >> 1);
		}
		return array;
	}

}
