package chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chatting.daoInter.RechargeableCardDaoInter;
import chatting.util.DBUtil;

public class RechargeableCardDao implements RechargeableCardDaoInter {

	@Override
	public boolean updateRechargeCardStatus(String cardID, boolean usable) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getconnection();
		int rows = 0;
		String sql = "UPDATE rechargeable_card SET usable = ? WHERE cardID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, usable);
			ps.setString(2, cardID);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return rows > 0;
	}

	@Override
	public boolean getRechargeCardStatus(String cardID) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getconnection();
		ResultSet resultSet = null;
		boolean usable = false;
		String sql = "SELECT usable FROM rechargeable_card WHERE cardID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cardID);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				usable = resultSet.getBoolean(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return usable;
	}

	@Override
	public int checkRechargeCard(String cardID, String password) {
		// TODO Auto-generated method stub
		int status = 1;
		String pass = null;
		ResultSet resultSet = null;
		Connection connection = DBUtil.getconnection();
		String sql = "SELECT password FROM rechargeable_card WHERE cardID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cardID);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				pass = resultSet.getString(1);
			}
			if (pass.equals(password)) {
				status = 3;
			} else {
				status = 2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}

		return status;
	}

	@Override
	public int addRechargeCard(String cardID, String password, float denomination) {
		// TODO Auto-generated method stub
		int status = 2;
		int existStatus = this.checkRechargeCard(cardID, password);
		if (existStatus == 1) {
			int rows = 0;
			Connection connection = DBUtil.getconnection();
			String sql = "INSERT INTO rechargeable_card VALUES(?, ?, ?, ?)";
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, cardID);
				ps.setString(2, password);
				ps.setDouble(3, denomination);
				ps.setBoolean(4, true);
				rows = ps.executeUpdate();
				status = rows > 0 ? 1 : 2;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.releaseConnection(connection);
			}
		} else {
			status = 2;
		}
		return status;
	}

	@Override
	public float getDenomination(String cardID) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getconnection();
		ResultSet resultSet = null;
		float denomination = 0L;
		String sql = "SELECT denomination FROM rechargeable_card WHERE cardID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cardID);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				denomination = resultSet.getFloat("denomination");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return denomination;
	}

}
