package com.jsyunsi.mobile_manager.services;

import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.vo.User;

/**
 * 用户登录检测实现
 * 
 * @author 紫风铃
 *
 */
public class LoginRegisterService {

	/**
	 * 登录检测
	 * 
	 * @param userID
	 *            用户名
	 * @param passwd
	 *            密码
	 * @return 状态码： 1-用户不存在；2-密码错误；3-密码正确
	 */
	public int login(String userID, String userIP, String passwd) {
		int status = 1;
		UserDaoInter userDao = new UserDao();
		User user = userDao.getUser(userID);
		if (user == null) {
			status = 1;// 用户不存在
		} else {
			String password = user.getPassword();
			if (password.equals(passwd)) {
				user.setOnlineStatus(true);
				user.setUserIP(userIP);
				userDao.updateUser(userID, user);
				status = 3;// 密码正确
			} else {
				status = 2;// 密码错误
			}
		}
		return status;
	}

	/**
	 * 注销服务
	 * 
	 * @param userID
	 * @return true:注销成功
	 */
	public boolean logout(String userID) {
		boolean status = false;
		UserDaoInter userDao = new UserDao();
		User user = userDao.getUser(userID);
		if (user == null) {
			status = false;// 注销失败
		} else {
			user.setOnlineStatus(false);
			user.setUserIP("0.0.0.0");
			status = userDao.updateUser(userID, user); // 注销成功
		}
		return status;
	}

	/**
	 * 注册服务
	 * 
	 * @param userID
	 * @param passwd
	 * @return true:注册成功
	 */
	public boolean registerUser(String userID, String passwd) {
		// TODO Auto-generated method stub
		boolean status = false;
		UserDaoInter userdao = new UserDao();
		User user = userdao.getUser(userID);
		if (user == null) {
			user = new User(userID, "0.0.0.0", false, false, 1, true, passwd);
			status = userdao.addUSer(user);
		} else {
			status = false;
		}
		return status;
	}
}