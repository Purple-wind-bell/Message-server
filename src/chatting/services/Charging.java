package chatting.services;

import java.sql.Timestamp;
import java.util.Date;

import chatting.dao.SPDao;
import chatting.dao.TransactionRecordDao;
import chatting.dao.UserDao;
import chatting.daoInter.SPDaoInter;
import chatting.daoInter.TransactionRecordDaoInter;
import chatting.daoInter.UserDaoInter;
import chatting.vo.SP;
import chatting.vo.TransactionRecord;
import chatting.vo.User;

/**
 * SP服务扣费
 * 
 * @author Administrator
 *
 */
public class Charging {
	private UserDaoInter udao = new UserDao();
	private SPDaoInter spdao = new SPDao();

	/**
	 * SP服务扣费,同时添加记录
	 * 
	 * @param spID
	 * @param userID
	 */
	public void charge(String spID, String userID) {
		// - 扣费
		SP sp = spdao.getSP(spID);
		User user = udao.getUser(userID);
		if (sp != null && user != null) {
			// 用户账号扣费
			float balance = user.getBalance() - sp.getCharge();
			user.setBalance(balance);
			udao.updateUser(user.getUserID(), user);
			// 添加记录
			TransactionRecord record = new TransactionRecord();
			TransactionRecordDaoInter recordDao = new TransactionRecordDao();
			record.setUserID(userID);
			record.setSpID(sp.getID());
			// System.out.println("SP服务费：" + sp.getCharge());
			record.setCharge(-sp.getCharge());// 金额显示负的，表示扣费
			record.setTradingTime(new Timestamp(new Date().getTime()));
			record.setRemarks("SP服务" + spID + "消费" + Float.toString(sp.getCharge()) + "元");
			while (!recordDao.addRecord(record)) {
			}
		}
	}
}
