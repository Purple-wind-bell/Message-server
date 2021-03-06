package chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chatting.daoInter.SPDaoInter;
import chatting.util.DBUtil;
import chatting.vo.SP;

public class SPDao implements SPDaoInter {

	@Override
	public boolean addSP(SP sp) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection connection = DBUtil.getconnection();
		String sql = "INSERT INTO sp_service VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, sp.getID());
			ps.setString(2, sp.getName());
			ps.setFloat(3, sp.getCharge());
			ps.setBoolean(4, sp.isAvaiable());
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
	public boolean deleteSP(String ID) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection connection = DBUtil.getconnection();
		String sql = "DELETE FROM sp_service WHERE ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ID);
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
	public boolean updateSP(String ID, SP sp) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection connection = DBUtil.getconnection();
		String sql = "UPDATE sp_service SET ID = ?, name = ?, charge = ?, avaiable = ? WHERE ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, sp.getID());
			ps.setString(2, sp.getName());
			ps.setFloat(3, sp.getCharge());
			ps.setBoolean(4, sp.isAvaiable());
			ps.setString(5, ID);
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
	public SP getSP(String ID) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		SP sp = null;
		Connection connection = DBUtil.getconnection();
		String sql = "SELECT * FROM sp_service WHERE ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ID);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String id1 = resultSet.getString(1);
				String name = resultSet.getString(2);
				float charge = resultSet.getFloat(3);
				boolean avaiable = resultSet.getBoolean(4);
				sp = new SP(id1, name, charge, avaiable);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return sp;
	}

}
