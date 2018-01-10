package com.jsyunsi.mobile_manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.util.DBUtil;
import com.jsyunsi.mobile_manager.vo.User;

public class UserDao implements UserDaoInter {

	@Override
	public boolean addUSer(User user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getUserIP());
			ps.setBoolean(3, user.isOnlineStatus());
			ps.setBoolean(4, user.isFrozenStatus());
			ps.setFloat(5, user.getBalance());
			ps.setBoolean(6, user.isOpenSP());
			ps.setString(7, user.getPassword());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return i > 0;
	}

	@Override
	public boolean delUser(String userID) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "delete from user where userID=?";
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userID);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return i > 0;
	}

	@Override
	public boolean updateUser(String userID, User user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		int i = 0;
		String sql = "update user set userID= ?, userIP = ?, onlineStatus = ?, frozenStatus = ?,"
				+ " balance = ?, openSP = ?, password = ? where userID= ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getUserIP());
			ps.setBoolean(3, user.isOnlineStatus());
			ps.setBoolean(4, user.isFrozenStatus());
			ps.setFloat(5, user.getBalance());
			ps.setBoolean(6, user.isOpenSP());
			ps.setString(7, user.getPassword());
			ps.setString(8, userID);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return i > 0;
	}

	@Override
	public User getUser(String userID) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "select * from user where userID=?";
		User u = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getBoolean(4), rs.getFloat(5),
						rs.getBoolean(6), rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return u;
	}

	@Override
	public ArrayList<User> getAllUser() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "select * from user where 1 = 1";
		ArrayList<User> list = new ArrayList<User>();
		User user = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getBoolean(4), rs.getFloat(5),
						rs.getBoolean(6), rs.getString(7));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return list;
	}

}
