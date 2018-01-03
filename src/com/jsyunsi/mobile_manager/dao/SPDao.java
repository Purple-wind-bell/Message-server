package com.jsyunsi.mobile_manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.util.DBUtil;
import com.jsyunsi.mobile_manager.vo.SP;

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
				String ID1 = resultSet.getString(1);
				String name = resultSet.getString(2);
				float charge = resultSet.getFloat(3);
				boolean avaiable = resultSet.getBoolean(4);
				sp = new SP(ID1, name, charge, avaiable);
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
