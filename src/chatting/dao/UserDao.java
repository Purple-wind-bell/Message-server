package chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chatting.daoInter.UserDaoInter;
import chatting.util.DBUtil;
import chatting.vo.User;

public class UserDao implements UserDaoInter {

	@Override
	public boolean addUSer(User user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "insert into user values(?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserID());
			ps.setBoolean(2, user.isFrozenStatus());
			ps.setFloat(3, user.getBalance());
			ps.setBoolean(4, user.isOpenSP());
			ps.setString(5, user.getPassword());
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
		String sql = "update user set userID= ?, frozenStatus = ?,"
				+ " balance = ?, openSP = ?, password = ? where userID= ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserID());
			ps.setBoolean(2, user.isFrozenStatus());
			ps.setFloat(3, user.getBalance());
			ps.setBoolean(4, user.isOpenSP());
			ps.setString(5, user.getPassword());
			ps.setString(6, userID);
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
				u = new User(rs.getString(1), rs.getBoolean(2), rs.getFloat(3), rs.getBoolean(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return u;
	}

}
