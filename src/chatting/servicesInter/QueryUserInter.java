package chatting.servicesInter;

import chatting.vo.User;

/**
 * 余额查询服务接口
 * 
 *
 */
public interface QueryUserInter {

	/**
	 * 根据用户ID查询余额
	 * 
	 * @param userID
	 *            用户id
	 * @return 余额
	 */
	float queryBalance(String userID);

	/**
	 * 根据用户id查询用户信息，不包含密码，余额等敏感信息
	 * 
	 * @param userID
	 *            用户id
	 * @return User对象
	 */
	User queryUser(String userID);

	/**
	 * 根据用户ID查询密码
	 * 
	 * @param userID
	 *            用户id
	 * @return 密码字符串，注意所有密码均已经结果MD5加密
	 */
	String queryPassword(String userID);
}
