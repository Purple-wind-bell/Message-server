package com.jsyunsi.mobile_manager.services;

import java.util.Date;

import com.jsyunsi.mobile_manager.servicesInter.BalanceQueryInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryRecordInter;
import com.jsyunsi.mobile_manager.servicesInter.RechargeInter;
import com.jsyunsi.mobile_manager.servicesInter.SMSForwardInter;
import com.jsyunsi.mobile_manager.servicesInter.WeatherQueryInter;
import com.jsyunsi.mobile_manager.vo.FormatSMS;

/**
 * 处理接收的短信，进行相应的处理，包括生成回复短信
 * 
 * @author 紫风铃
 *
 */
public class SMSHandleService {
	private FormatSMS inFormatSMS = null;// 接收的短信
	private BalanceQueryInter bQuery = new BalanceQuery();
	private LoginRegisterService lrService = new LoginRegisterService();
	private RechargeInter recharge = new RechargeService();
	private WeatherQueryInter weatherQuery = new WeatherQueryService();
	private SMSForwardInter sForward = new SMSForward();
	private QueryRecordInter queryRecord = null;

	/**
	 * 短信处理
	 * 
	 * @param formatSMS
	 *            接收的短信
	 * @return 要发送回去的短信
	 */
	public FormatSMS process(FormatSMS formatSMS) {
		FormatSMS outFormatSMS = null;// 发送回去的短信
		String cmd = inFormatSMS.getCmd();
		String targetAddress = inFormatSMS.getTargetAddress();
		String sourceAddress = inFormatSMS.getSourceAddress();
		String status = "0001";// 默认返回状态码
		String smsContent = "";// 默认返回短信内容
		switch (inFormatSMS.getCmd()) {
		case "CMD001":
			String s = inFormatSMS.getContent().substring(0, 2);// 获取服务类型
			String pass = inFormatSMS.getContent().substring(2, 8);// 获取密码
			switch (s) {
			case "DL":// 用户登陆
				if (pass.length() == 6) {
					String ip = inFormatSMS.getContent().substring(8);// 获取客户端ip
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
			// outFormatSMS = new FormatSMS("CMD001", targetAddress, sourceAddress, status,
			// smsContent);
			break;
		case "CMD002":// 注销
			if (lrService.logout(sourceAddress)) {
				status = "0000";
				smsContent = "注销成功";
			} else {
				status = "0001";
				smsContent = "注销失败";
			}
			// outFormatSMS = new FormatSMS("CMD002", targetAddress, sourceAddress, status,
			// smsContent);
			break;
		case "CMD003":// 短信服务
			if (targetAddress.substring(0, 8).equals("0000000")) {
				// SP服务
				switch (targetAddress.substring(8, 11)) {
				case "001":// 余额查询
					float balance = bQuery.queryBalance(sourceAddress);
					status = "0000";
					smsContent = "当前手机余额：" + Float.toString(balance) + "元";
					break;
				case "002":// 天气查询
					String cityID = inFormatSMS.getContent().substring(2);
					status = "0000";
					smsContent = weatherQuery.queryWeather(cityID, new Date());
					break;
				case "003":// 充值
					String cardID = inFormatSMS.getContent().substring(0, 10);
					String password = inFormatSMS.getContent().substring(10, 16);
					int s1 = recharge.recharge(sourceAddress, cardID, password);
					// 1-充值成功；2-充值卡卡号不存在；3-密码错误；4-充值卡失效
					switch (s1) {
					case 1:
						status = "0000";
						smsContent = "充值成功";
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
					String func = inFormatSMS.getContent().substring(0, 4);
					if (func.equals("DXJL")) {
						status = "0000";// 查询短信记录
						smsContent = queryRecord.SMSHistoryQuery(sourceAddress);
					} else if (func.equals("JYJL")) {
						status = "0000";// 查询交易记录
						smsContent = queryRecord.transactionRecordQuery(sourceAddress);
					}
					break;
				default:
					status = "0001";
					smsContent = "未知错误";
					break;
				}
				// outFormatSMS = new FormatSMS("CMD003", targetAddress, sourceAddress, status,
				// smsContent);
			} else {// 转发短信
				sForward.forward(inFormatSMS);
				status = "0000";
				sourceAddress = "00000000000";
				smsContent = "向" + targetAddress + "发送短信成功。";
				// outFormatSMS = new FormatSMS("CMD003", sourceAddress, sourceAddress, status,
				// smsContent);
			}
			break;
		default:
			status = "0001";
			smsContent = "未知错误";
			break;
		}
		outFormatSMS = new FormatSMS(cmd, sourceAddress, sourceAddress, status, smsContent);
		return outFormatSMS;

	}
}
