package chatting.services;

import java.util.ArrayList;
import chatting.dao.SMSHistoryDao;
import chatting.dao.SPDao;
import chatting.dao.TransactionRecordDao;
import chatting.dao.UserDao;
import chatting.daoInter.SMSHistoryDaoInter;
import chatting.daoInter.SPDaoInter;
import chatting.daoInter.TransactionRecordDaoInter;
import chatting.daoInter.UserDaoInter;
import chatting.servicesInter.QueryRecordInter;
import chatting.vo.SMSHistory;
import chatting.vo.TransactionRecord;

public class QueryRecordService implements QueryRecordInter {
	TransactionRecordDaoInter transactionRecord = new TransactionRecordDao();
	SMSHistoryDaoInter SMSRecord = new SMSHistoryDao();
	UserDaoInter udao = new UserDao();
	SPDaoInter spdao = new SPDao();

	@Override
	public ArrayList<TransactionRecord> transactionRecordQuery(String userID) {
		// TODO Auto-generated method stub
		ArrayList<TransactionRecord> list = transactionRecord.getRecord(userID);
		return list;
	}

	@Override
	public ArrayList<SMSHistory<String>> SMSHistoryQueryBySender(String senderID) {
		// TODO Auto-generated method stub
		ArrayList<SMSHistory<String>> list = SMSRecord.querySMSHistoryBySenderID(senderID);
		return list;
	}

	@Override
	public ArrayList<SMSHistory<String>> SMSHistoryQueryByReceiver(String receiverID) {
		// TODO Auto-generated method stub
		ArrayList<SMSHistory<String>> list = SMSRecord.querySMSHistoryByReceiverID(receiverID);
		return list;
	}

	@Override
	public ArrayList<SMSHistory<String>> SMSHistoryQuery(String userID) {
		// TODO Auto-generated method stub
		ArrayList<SMSHistory<String>> list1 = SMSRecord.querySMSHistoryBySenderID(userID);
		ArrayList<SMSHistory<String>> list2 = SMSRecord.querySMSHistoryByReceiverID(userID);
		list1.addAll(list2);
		return list1;
	}

}
