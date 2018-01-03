package com.jsyunsi.mobile_manager.servicesInter;

import com.jsyunsi.mobile_manager.vo.User;

/**
 * 用户登录检测
 * 
 * @author 紫风铃
 *
 */
public interface LoginRegisterInter {

	/**
	 * 用户登录检查
	 * 
	 * @param user
	 *            用户名
	 * @param passwd
	 *            密码
	 * @return 1：用户名不存在；2：密码错误； 3：密码正确；0：方法没有正确执行
	 */
	int LoginCheck(String userID, String passwd);

	/**
	 * 注册用户
	 * 
	 * @param user
	 *            用户
	 * @return true-注册成功；false-注册失败，用户已存在
	 */
	boolean registerUser(User user);
}