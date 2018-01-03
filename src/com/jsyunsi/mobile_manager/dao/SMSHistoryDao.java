package com.jsyunsi.mobile_manager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jsyunsi.mobile_manager.daoInter.SMSHistoryDaoInter;
import com.jsyunsi.mobile_manager.util.DBUtil;
import com.jsyunsi.mobile_manager.vo.SMSHistory;

public class SMSHistoryDao implements SMSHistoryDaoInter {

	@Override
	public boolean addSMSHistory(SMSHistory smsHistory) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection connection = DBUtil.getconnection();
		String sql = "INSERT INTO sms_history VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, smsHistory.getSenderID());
			ps.setString(2, smsHistory.getReceiverID());
			ps.setDate(3, (Date) smsHistory.getSendTime());
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
	public ArrayList<SMSHistory> querySMSHistoryBySenderID(String senderID) {
		// TODO Auto-generated method stub
		ArrayList<SMSHistory> list = new ArrayList<SMSHistory>();
		SMSHistory smsHistory;
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
				Date sendTime = resultSet.getDate(3);
				String message = resultSet.getString(4);
				smsHistory = new SMSHistory(senderID1, receiverID, sendTime, message);
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
	public ArrayList<SMSHistory> querySMSHistoryByReceiverID(String receiverID) {
		// TODO Auto-generated method stub
		ArrayList<SMSHistory> list = new ArrayList<SMSHistory>();
		SMSHistory smsHistory;
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
				Date sendTime = resultSet.getDate(3);
				String message = resultSet.getString(4);
				smsHistory = new SMSHistory(senderID, receiverID1, sendTime, message);
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
