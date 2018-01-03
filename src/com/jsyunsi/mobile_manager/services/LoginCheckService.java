package com.jsyunsi.mobile_manager.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsyunsi.mobile_manager.util.DBUtil;

/**
 * 用户登录检测实现
 * 
 * @author 紫风铃
 *
 */
public class LoginCheckService {

	/**
	 * 用户登录检查
	 * 
	 * @param user
	 *            用户名
	 * @param passwd
	 *            密码
	 * @return 1：用户名不存在；2：密码错误； 3：密码正确；0：方法没有正确执行
	 */
	public int check(String user, String passwd) {
		// 方法2-数据库查询
		int status = 0;
		ResultSet resultSet = null;
		String sql = "SELECT password FROM user WHERE userID = ?";
		Connection connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user);
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
}