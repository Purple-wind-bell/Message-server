package com.jsyunsi.mobile_manager.services;

import java.util.Date;
import com.jsyunsi.mobile_manager.dao.SMSHistoryDao;
import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.SMSHistoryDaoInter;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.SMSForwardInter;
import com.jsyunsi.mobile_manager.util.Client;
import com.jsyunsi.mobile_manager.util.FormatService;
import com.jsyunsi.mobile_manager.util.SMSForwardSocket;
import com.jsyunsi.mobile_manager.vo.FormatSMS;
import com.jsyunsi.mobile_manager.vo.SMSHistory;
import com.jsyunsi.mobile_manager.vo.SP;
import com.jsyunsi.mobile_manager.vo.User;

public class SMSForward implements SMSForwardInter {
	UserDaoInter udao = new UserDao();
	SPDaoInter spdao = new SPDao();
	SMSHistoryDaoInter smsHistoryDao = new SMSHistoryDao();

	@Override
	public boolean forward(FormatSMS formatSMS) {
		boolean status = false;
		String receiverID = formatSMS.getTargetAddress();
		User reveicer = udao.getUser(receiverID);
		if (reveicer != null) {
			boolean onLine = reveicer.isOnlineStatus();
			if (onLine) {
				String sms = FormatService.toStringSMS(formatSMS);// 转发信息
				String ip = reveicer.getUserIP();
				new SMSForwardSocket(ip, sms).start();
				// 扣费
				SP sp = spdao.getSP("000");
				String senderID = formatSMS.getSourceAddress();
				User sender = udao.getUser(senderID);
				float balance = sender.getBalance() - sp.getCharge();
				sender.setBalance(balance);
				while (!udao.updateUser(sender.getUserID(), sender)) {
				}
				// 添加历史记录
				SMSHistory smsHistory = new SMSHistory(senderID, receiverID, new Date(), formatSMS.getSMSContent());
				while (!smsHistoryDao.addSMSHistory(smsHistory)) {
				}
				status = true;
			} else {
				status = false;
			}
		} else {
			status = false;
		}
		return status;
	}
}
