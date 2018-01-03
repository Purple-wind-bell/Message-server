package com.jsyunsi.mobile_manager.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.LoginRegisterInter;
import com.jsyunsi.mobile_manager.util.DBUtil;
import com.jsyunsi.mobile_manager.vo.User;

/**
 * 用户登录检测实现
 * 
 * @author 紫风铃
 *
 */
public class LoginRegisterService implements LoginRegisterInter {

	@Override
	public int LoginCheck(String userID, String passwd) {
		// 方法2-数据库查询
		int status = 0;
		ResultSet resultSet = null;
		String sql = "SELECT password FROM user WHERE userID = ?";
		Connection connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userID);
			resultSet = ps.executeQuery();
			if (!resultSet.next()) {
				status = 1;// 用户不存在
			} else {
				String password = resultSet.getString("password");
				if (password.equals(passwd)) {
					status = 3;// 密码正确
				} else {
					status = 2;// 密码错误
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = 0;
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return status;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		boolean status = false;
		UserDaoInter userdao = null;
		User u = userdao.getUser(user.getUserID());
		if (u == null) {
			status = userdao.addUSer(user);
		}
		return status;
	}
}