package chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import chatting.daoInter.SMSHistoryDaoInter;
import chatting.util.DBUtil;
import chatting.vo.SMSHistory;

public class SMSHistoryDao implements SMSHistoryDaoInter {

	@Override
	public boolean addSMSHistory(SMSHistory<String> smsHistory) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection connection = DBUtil.getconnection();
		String sql = "INSERT INTO sms_history VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, smsHistory.getSenderID());
			ps.setString(2, smsHistory.getReceiverID());

			ps.setTimestamp(3, smsHistory.getSendTime());

			// ps.setDate(3, new
			// Date(smsHistory.getSendTime().getTime()));//date:util->sql转换
			ps.setString(4, smsHistory.getMessage());
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
	public ArrayList<SMSHistory<String>> querySMSHistoryBySenderID(String senderID) {
		// TODO Auto-generated method stub
		ArrayList<SMSHistory<String>> list = new ArrayList<SMSHistory<String>>();
		SMSHistory<String> smsHistory;
		String sql = "SELECT * FROM sms_history WHERE senderID = ?";
		Connection connection = DBUtil.getconnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, senderID);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String senderID1 = resultSet.getString(1);
				String receiverID = resultSet.getString(2);
				Timestamp sendTime = resultSet.getTimestamp(3);
				String message = resultSet.getString(4);
				smsHistory = new SMSHistory<String>(senderID1, receiverID, sendTime, message);
				list.add(smsHistory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return list;
	}

	@Override
	public ArrayList<SMSHistory<String>> querySMSHistoryByReceiverID(String receiverID) {
		// TODO Auto-generated method stub
		ArrayList<SMSHistory<String>> list = new ArrayList<SMSHistory<String>>();
		SMSHistory<String> smsHistory;
		String sql = "SELECT * FROM sms_history WHERE senderID = ?";
		Connection connection = DBUtil.getconnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, receiverID);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String senderID = resultSet.getString(1);
				String receiverID1 = resultSet.getString(2);
				Timestamp sendTime = resultSet.getTimestamp(3);
				String message = resultSet.getString(4);
				smsHistory = new SMSHistory<String>(senderID, receiverID1, sendTime, message);
				list.add(smsHistory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return list;
	}

}
