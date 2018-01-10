package com.jsyunsi.mobile_manager.services;

import java.util.ArrayList;
import java.util.Iterator;

import com.jsyunsi.mobile_manager.dao.SMSHistoryDao;
import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.TransactionRecordDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.SMSHistoryDaoInter;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.TransactionRecordDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryRecordInter;
import com.jsyunsi.mobile_manager.vo.SMSHistory;
import com.jsyunsi.mobile_manager.vo.TransactionRecord;

public class QueryRecordService implements QueryRecordInter {
	TransactionRecordDaoInter transactionRecord = new TransactionRecordDao();
	SMSHistoryDaoInter SMSRecord = new SMSHistoryDao();
	UserDaoInter udao = new UserDao();
	SPDaoInter spdao = new SPDao();

	@Override
	public String transactionRecordQuery(String userID) {
		// TODO Auto-generated method stub
		String string = "交易记录：\n";
		ArrayList<TransactionRecord> list = transactionRecord.getRecord(userID);
		Iterator<TransactionRecord> iterator = list.iterator();
		while (iterator.hasNext()) {
			TransactionRecord record = (TransactionRecord) iterator.next();
			string = string + record.toString() + "\n";
		}
		return string;
	}

	@Override
	public String SMSHistoryQueryBySender(String senderID) {
		// TODO Auto-generated method stub
		String string = "发件人记录：\n";
		ArrayList<SMSHistory> list = SMSRecord.querySMSHistoryBySenderID(senderID);
		Iterator<SMSHistory> iterator = list.iterator();
		while (iterator.hasNext()) {
			SMSHistory record = (SMSHistory) iterator.next();
			string = string + record.toString() + "\n";
		}
		return string;
	}

	@Override
	public String SMSHistoryQueryByReceiver(String receiverID) {
		// TODO Auto-generated method stub
		String string = "收件人记录：\n";
		ArrayList<SMSHistory> list = SMSRecord.querySMSHistoryByReceiverID(receiverID);
		Iterator<SMSHistory> iterator = list.iterator();
		while (iterator.hasNext()) {
			SMSHistory record = (SMSHistory) iterator.next();
			string = string + record.toString() + "\n";
		}
		return string;
	}

	@Override
	public String SMSHistoryQuery(String userID) {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		String string1 = "发件人记录：\n";
		ArrayList<SMSHistory> list1 = SMSRecord.querySMSHistoryBySenderID(userID);
		Iterator<SMSHistory> iterator1 = list1.iterator();
		while (iterator1.hasNext()) {
			SMSHistory record = (SMSHistory) iterator1.next();
			string1 = string1 + record.toString() + "\n";
		}

		String string2 = "收件人记录：\n";
		ArrayList<SMSHistory> list2 = SMSRecord.querySMSHistoryByReceiverID(userID);
		Iterator<SMSHistory> iterator2 = list2.iterator();
		while (iterator2.hasNext()) {
			SMSHistory record = (SMSHistory) iterator2.next();
			string2 = string2 + record.toString() + "\n";
		}
		string.append(string1).append(string2);
		// System.out.println(string.toString());
		return string.toString();
	}

}
