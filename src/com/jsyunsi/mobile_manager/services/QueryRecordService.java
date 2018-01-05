package com.jsyunsi.mobile_manager.services;

import java.util.ArrayList;
import java.util.Iterator;

import com.jsyunsi.mobile_manager.dao.SMSHistoryDao;
import com.jsyunsi.mobile_manager.dao.TransactionRecordDao;
import com.jsyunsi.mobile_manager.daoInter.SMSHistoryDaoInter;
import com.jsyunsi.mobile_manager.daoInter.TransactionRecordDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryRecordInter;
import com.jsyunsi.mobile_manager.vo.SMSHistory;
import com.jsyunsi.mobile_manager.vo.TransactionRecord;

public class QueryRecordService implements QueryRecordInter {
	TransactionRecordDaoInter transactionRecord = new TransactionRecordDao();
	SMSHistoryDaoInter SMSRecord = new SMSHistoryDao();

	@Override
	public String transactionRecordQuery(String userID) {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		ArrayList<TransactionRecord> list = transactionRecord.getRecord(userID);
		Iterator<TransactionRecord> iterator = list.iterator();
		while (iterator.hasNext()) {
			TransactionRecord record = (TransactionRecord) iterator.next();
			string.append(record.toString());
		}
		return string.toString();
	}

	@Override
	public String SMSHistoryQueryBySender(String senderID) {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		ArrayList<SMSHistory> list = SMSRecord.querySMSHistoryBySenderID(senderID);
		Iterator<SMSHistory> iterator = list.iterator();
		while (iterator.hasNext()) {
			SMSHistory record = (SMSHistory) iterator.next();
			string.append(record.toString());
		}
		return string.toString();
	}

	@Override
	public String SMSHistoryQueryByReceiver(String receiverID) {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		ArrayList<SMSHistory> list = SMSRecord.querySMSHistoryByReceiverID(receiverID);
		Iterator<SMSHistory> iterator = list.iterator();
		while (iterator.hasNext()) {
			SMSHistory record = (SMSHistory) iterator.next();
			string.append(record.toString());
		}
		return string.toString();
	}

	@Override
	public String SMSHistoryQuery(String userID) {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		string.append(this.SMSHistoryQueryBySender(userID));
		string.append(this.SMSHistoryQueryByReceiver(userID));
		return string.toString();
	}

}
