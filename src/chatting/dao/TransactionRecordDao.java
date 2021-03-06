package chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chatting.daoInter.TransactionRecordDaoInter;
import chatting.util.DBUtil;
import chatting.vo.TransactionRecord;

public class TransactionRecordDao implements TransactionRecordDaoInter {

	@Override

	public boolean addRecord(TransactionRecord record) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "insert into transaction_record values(?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, record.getUserID());
			ps.setString(2, record.getSpID());
			ps.setFloat(3, record.getCharge());
			ps.setTimestamp(4, record.getTradingTime());
			ps.setString(5, record.getRemarks());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return i > 0;// 优化代码
	}

	@Override
	public ArrayList<TransactionRecord> getRecord(String userID) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getconnection();
		String sql = "select * from transaction_record where userID=?";
		TransactionRecord tr = null;
		/**
		 * 此处代码存在问题，已修改
		 * 
		 * @modifiedBy 紫风铃
		 */
		ArrayList<TransactionRecord> list = new ArrayList<TransactionRecord>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new TransactionRecord();
				tr.setUserID(rs.getString(1));
				tr.setSpID(rs.getString(2));
				tr.setCharge(rs.getFloat(3));
				tr.setTradingTime(rs.getTimestamp(4));
				tr.setRemarks(rs.getString(5));
				list.add(tr);
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
