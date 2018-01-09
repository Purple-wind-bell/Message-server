package com.jsyunsi.mobile_manager.services;

import java.sql.Timestamp;
import java.util.Date;
import com.jsyunsi.mobile_manager.dao.SMSHistoryDao;
import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.SMSHistoryDaoInter;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryBalanceInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryRecordInter;
import com.jsyunsi.mobile_manager.servicesInter.RechargeInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryWeatherInter;
import com.jsyunsi.mobile_manager.vo.FormatSMS;
import com.jsyunsi.mobile_manager.vo.SMSHistory;
import com.jsyunsi.mobile_manager.vo.User;

/**
 * 处理接收的短信，进行相应的处理，包括生成回复短信
 * 
 * @author 紫风铃
 *
 */
public class SMSHandleService {
	private QueryBalanceInter bQuery = new QueryBalanceService();
	private LoginRegisterService lrService = new LoginRegisterService();
	private RechargeInter recharge = new CardRechargeService();
	private QueryWeatherInter weatherQuery = new QueryWeatherService();
	private QueryRecordInter queryRecord = new QueryRecordService();
	UserDaoInter udao = new UserDao();
	SPDaoInter spdao = new SPDao();
	SMSHistoryDaoInter smsHistoryDao = new SMSHistoryDao();
	String status = "0001";// 默认返回状态码
	String smsContent = "0";// 默认返回短信内容
	String cmd = "CMD002";// 默认命令

	/**
	 * 登录注册处理
	 * 
	 * @param formatSMS
	 *            接收的短信
	 * @return 回复的短信
	 */
	private FormatSMS loginRegisterHandle(FormatSMS fSMS) {
		String cmd = fSMS.getCmd();
		String targetAddress = fSMS.getTargetAddress();
		String sourceAddress = fSMS.getSourceAddress();
		String status = "0001";// 默认返回状态码
		String smsContent = "";// 默认返回短信内容
		String s = fSMS.getContent().substring(0, 2);// 获取服务类型
		String pass = fSMS.getContent().substring(2, 8);// 获取密码
		switch (s.toUpperCase()) {
		case "DL":// 用户登陆
			if (pass.length() == 6) {
				String ip = fSMS.getContent().substring(8);// 获取客户端ip
				int s1 = lrService.login(sourceAddress, ip, pass);
				switch (s1) {
				case 1:
					status = "3000";
					smsContent = "用户不存在";
					break;
				case 2:
					status = "3001";
					smsContent = "密码错误";
					break;
				case 3:
					status = "0000";
					smsContent = "登录成功";
					break;
				default:
					status = "0001";
					smsContent = "未知错误";
					break;
				}
			} else {
				status = "0001";
				smsContent = "密码长度错误";
			}
			break;
		case "ZC":// 用户注册
			if (pass.length() == 6 && lrService.registerUser(sourceAddress, pass)) {
				status = "0000";
				smsContent = "注册成功";
			} else {
				status = "0001";
				smsContent = "注册失败";
			}
			break;
		default:
			status = "0001";
			smsContent = "未知错误";
			break;
		}
		return new FormatSMS(cmd, targetAddress, sourceAddress, status, smsContent);
	}

	/**
	 * 注销短信处理
	 * 
	 * @param fSMS
	 *            接收的短信
	 * @return 回复短信
	 */
	private FormatSMS logoutHandle(FormatSMS fSMS) {
		String cmd = fSMS.getCmd();
		String targetAddress = fSMS.getTargetAddress();
		String sourceAddress = fSMS.getSourceAddress();
		String status = "0001";// 默认返回状态码
		String smsContent = "";// 默认返回短信内容
		if (lrService.logout(sourceAddress)) {
			status = "0000";
			smsContent = "注销成功";
		} else {
			status = "0001";
			smsContent = "注销失败";
		}
		return new FormatSMS(cmd, targetAddress, sourceAddress, status, smsContent);
	}

	/**
	 * 普通短信处理
	 * 
	 * @param fSMS
	 *            接收的短信
	 * @return 回复短信
	 */
	private FormatSMS SMSHandle(FormatSMS fSMS) {
		cmd = fSMS.getCmd();
		String targetAddress = fSMS.getTargetAddress();
		String sourceAddress = fSMS.getSourceAddress();
		User sender = udao.getUser(sourceAddress);
		if (sender != null && sender.isOnlineStatus() && !sender.isFrozenStatus()) {// 发件人在数据库中以及发件人状态检查
			if (targetAddress.substring(0, 8).equals("00000000")) {
				// SP服务
				switch (targetAddress.substring(8, 11)) {
				case "001":// 余额查询
					if (udao.getUser(sourceAddress).getBalance() > 0) {// 余额充足
						float balance = bQuery.queryBalance(sourceAddress);
						status = "0000";
						smsContent = "当前手机余额：" + Float.toString(balance) + "元";
						// - 扣费
						new Charging().charge("001", sourceAddress);
					} else {
						status = "0001";
						smsContent = "余额不足！";
					}
					break;
				case "002":// 天气查询
					if (udao.getUser(sourceAddress).getBalance() > 0) {// 余额充足
						String cityID = fSMS.getContent().substring(2);
						status = "0000";
						smsContent = weatherQuery.queryWeather(cityID, new Date());
						// - 扣费
						new Charging().charge("002", sourceAddress);
					} else {
						status = "0001";
						smsContent = "余额不足！";
					}
					break;
				case "003":// 充值
					String cardID = fSMS.getContent().substring(0, 10);
					String password = fSMS.getContent().substring(11, 17);
					int s1 = recharge.recharge(sourceAddress, cardID, password);
					// 1-充值成功；2-充值卡卡号不存在；3-密码错误；4-充值卡失效
					switch (s1) {
					case 1:
						status = "0000";
						smsContent = "充值成功";
						// - 扣费
						new Charging().charge("003", sourceAddress);
						break;
					case 2:
						status = "5001";
						smsContent = "充值卡卡号不存在";
						break;
					case 3:
						status = "5001";
						smsContent = "密码错误";
						break;
					case 4:
						status = "5001";
						smsContent = "充值卡失效";
						break;
					default:
						break;
					}
					break;
				case "004":// 查询
					if (udao.getUser(sourceAddress).getBalance() > 0) {// 余额充足
						String func = fSMS.getContent().substring(0, 4);
						if (func.equals("DXJL")) {
							status = "0000";// 查询短信记录
							smsContent = queryRecord.SMSHistoryQuery(sourceAddress);
						} else if (func.equals("JYJL")) {
							status = "0000";// 查询交易记录
							smsContent = queryRecord.transactionRecordQuery(sourceAddress);
						}
						// - 扣费
						new Charging().charge("004", sourceAddress);
					} else {
						status = "0001";
						smsContent = "余额不足！";
					}
					break;
				default:
					status = "0001";
					smsContent = "未知错误";
					break;
				}
			} else {// 转发短信
				System.out.println("转发短信处理");
				if (udao.getUser(sourceAddress).getBalance() > 0) {// 余额充足
					if (this.forward(fSMS)) {
						status = "0000";// 转发成功
						smsContent = "向" + targetAddress + "发送短信成功。";
					} else {
						status = "0001";// 转发失败
						smsContent = "向" + targetAddress + "发送短信失败。";
					}
					new Charging().charge("000", sourceAddress);
				} else {
					status = "0001";
					smsContent = "余额不足！";
				}
				// - 扣费
				new Charging().charge("000", sourceAddress);
			}
		} else {
			status = "3000";
			smsContent = "用户不存在或状态错误！";
		}
		return new FormatSMS(cmd, targetAddress, sourceAddress, status, smsContent);
	}

	/**
	 * 短信转发
	 * 
	 * @param formatSMS
	 * @return true:转发成功
	 */
	private boolean forward(FormatSMS formatSMS) {
		boolean s = false;
		String receiverID = formatSMS.getTargetAddress();
		String senderID = formatSMS.getSourceAddress();
		User reveicer = udao.getUser(receiverID);
		if (reveicer != null) {
			s = new SendMessage(formatSMS).send();// 转发短信
			// System.out.println("已经向" + receiverID + "转发短信");
			s = true;
		} else {
			s = false;
		}
		// -------添加短信历史记录
		SMSHistory smsHistory = new SMSHistory(senderID, receiverID, new Timestamp(new Date().getTime()),
				formatSMS.getContent());
		while (!smsHistoryDao.addSMSHistory(smsHistory)) {
		}
		System.out.println("添加短信历史记录");
		return s;
	}

	/**
	 * 短信处理
	 * 
	 * @param formatSMS
	 *            接收的短信
	 * @return 要发送回去的短信
	 */
	public FormatSMS process(FormatSMS inFormatSMS) {
		FormatSMS outFormatSMS = null;// 发送回去的短信
		String cmd = inFormatSMS.getCmd();
		String targetAddress = inFormatSMS.getTargetAddress();
		String sourceAddress = inFormatSMS.getSourceAddress();
		String status = "0001";// 默认返回状态码
		String smsContent = "0";// 默认返回短信内容
		switch (inFormatSMS.getCmd()) {
		case "CMD001":// 登录注册
			outFormatSMS = this.loginRegisterHandle(inFormatSMS);
			break;
		case "CMD002":// 注销
			outFormatSMS = this.logoutHandle(inFormatSMS);
			break;
		case "CMD003":// 短信服务
			outFormatSMS = this.SMSHandle(inFormatSMS);
			break;
		default:
			status = "0001";
			smsContent = "未知错误";
			outFormatSMS = new FormatSMS(cmd, targetAddress, sourceAddress, status, smsContent);
			break;
		}
		return outFormatSMS;
	}
}
