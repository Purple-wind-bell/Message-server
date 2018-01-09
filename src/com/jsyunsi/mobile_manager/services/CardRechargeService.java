package com.jsyunsi.mobile_manager.services;

import java.sql.Timestamp;
import java.util.Date;
import com.jsyunsi.mobile_manager.dao.RechargeableCardDao;
import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.TransactionRecordDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.RechargeableCardDaoInter;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.TransactionRecordDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.RechargeInter;
import com.jsyunsi.mobile_manager.vo.SP;
import com.jsyunsi.mobile_manager.vo.TransactionRecord;
import com.jsyunsi.mobile_manager.vo.User;

public class CardRechargeService implements RechargeInter {
	private UserDaoInter uDao = new UserDao();
	private RechargeableCardDaoInter rCardDao = new RechargeableCardDao();
	private SPDaoInter spdao = new SPDao();

	@Override
	public int recharge(String userID, String cardID, String password) {
		// TODO Auto-generated method stub
		int status = 3;// 默认密码错误
		int s = rCardDao.checkRechargeCard(cardID, password);// 检测充值卡
		switch (s) {
		case 1:
			status = 2;
			break;
		case 2:
			status = 3;
			break;
		case 3:
			boolean b = rCardDao.getRechargeCardStatus(cardID);
			if (b) {
				User user = uDao.getUser(userID);
				SP sp = spdao.getSP("003");
				float balance = user.getBalance() + rCardDao.getDenomination(cardID);
				user.setBalance(balance);
				// 充值以及更新充值卡信息
				boolean b1 = false;
				boolean b2 = false;
				while (!b1 || !b2) {
					b1 = rCardDao.updateRechargeCardStatus(cardID, false);
					b2 = uDao.updateUser(userID, user);
				}
				// 添加充值交易记录
				TransactionRecord record = new TransactionRecord();
				TransactionRecordDaoInter recordDao = new TransactionRecordDao();
				record.setUserID(userID);
				record.setSpID(sp.getID());
				record.setCharge(rCardDao.getDenomination(cardID));
				record.setTradingTime(new Timestamp(new Date().getTime()));
				record.setRemarks("账号充值" + Float.toString(rCardDao.getDenomination(cardID)) + "元");
				while (!recordDao.addRecord(record)) {
				}
				status = 1;
			} else {
				status = 4;
			}
			break;
		default:
			status = 3;
			break;
		}
		return status;
	}
}
