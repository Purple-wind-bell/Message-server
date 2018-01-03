package com.jsyunsi.mobile_manager.daoInter;

import com.jsyunsi.mobile_manager.vo.User;

/**
 * 用户数据管理接口
 * 
 * @author 紫风铃
 *
 */
public interface UserDaoInter {

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	boolean addUSer(User user);

	/**
	 * 删除用户
	 * 
	 * @param userID
	 * @return
	 */
	boolean delUser(String userID);

	/**
	 * 设置用户注册IP
	 * 
	 * @param userID
	 * @param userIP
	 * @return
	 */
	boolean setUserIP(String userID, String userIP);

	/**
	 * 设置用户在线状态
	 * 
	 * @param userID
	 * @param status
	 * @return
	 */
	boolean setOnlineStatus(String userID, boolean status);

	/**
	 * 设置用户余额
	 * 
	 * @param userID
	 * @param balance
	 * @return
	 */
	boolean setBalance(String userID, float balance);

	/**
	 * 获得用户信息
	 * 
	 * @param userID
	 * @return 用户不存在返回null
	 */
	 User getUser(String userID);
}
