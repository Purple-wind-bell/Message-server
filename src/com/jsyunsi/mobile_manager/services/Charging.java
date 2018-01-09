package com.jsyunsi.mobile_manager.services;

import java.sql.Timestamp;
import java.util.Date;

import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.TransactionRecordDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.TransactionRecordDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.vo.SP;
import com.jsyunsi.mobile_manager.vo.TransactionRecord;
import com.jsyunsi.mobile_manager.vo.User;

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
			System.out.println("SP服务费：" + sp.getCharge());
			record.setCharge(-sp.getCharge());// 金额显示负的，表示扣费
			record.setTradingTime(new Timestamp(new Date().getTime()));
			record.setRemarks("SP服务" + spID + "消费" + Float.toString(sp.getCharge()) + "元");
			while (!recordDao.addRecord(record)) {
			}
		}
	}
}
