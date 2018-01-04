package com.jsyunsi.mobile_manager.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.jsyunsi.mobile_manager.servicesInter.BalanceQueryInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryRecordInter;
import com.jsyunsi.mobile_manager.servicesInter.RechargeInter;
import com.jsyunsi.mobile_manager.servicesInter.SMSForwardInter;
import com.jsyunsi.mobile_manager.servicesInter.WeatherQueryInter;
import com.jsyunsi.mobile_manager.util.FormatService;
import com.jsyunsi.mobile_manager.vo.FormatSMS;

/**
 * 服务器服务监听及处理
 * 
 * @author Administrator
 *
 */
public class ProcessService extends Thread {
	/** 创建端口 */
	ServerSocket server = null;
	/** 端口号 */
	int PORT = 5600;
	Socket socket = null;

	public ProcessService() {
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 信息处理
	 */
	public void run() {
		while (true) {
			try {
				socket = server.accept();// 每个请求交给一个线程去处理
				ServerThread th = new ServerThread(socket);
				th.start();
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 内部类，创建进程处理短信
	 * 
	 * @author Administrator
	 *
	 */
	class ServerThread extends Thread {
		Socket socket = null;
		/** 接收的SMS */
		String insms = null;
		/** 发送的SMS */
		String outsms = null;
		/** 当前用户 */
		String userID = "00000000000";
		BufferedReader bReader = null;
		PrintWriter pWriter = null;
		BalanceQueryInter bQuery = new BalanceQuery();
		LoginRegisterService lrService = new LoginRegisterService();
		RechargeInter recharge = new RechargeService();
		WeatherQueryInter weatherQuery = new WeatherQueryService();
		SMSForwardInter sForward = new SMSForward();
		QueryRecordInter queryRecord = null;

		public ServerThread(Socket sk) {
			this.socket = sk;
		}

		public void run() {
			FormatSMS outFormatSMS = null;// 发送回去的短信
			String smsContent = "";
			try {
				pWriter = new PrintWriter(socket.getOutputStream());
				bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				insms = bReader.readLine();
				// 格式化信息
				FormatSMS inFormatSMS = FormatService.toFormatSMS(insms);
				switch (inFormatSMS.getCmd()) {
				case "CMD001":
					break;
				case "CMD002":
					break;
				case "CMD003":
					String targetAddress = inFormatSMS.getTargetAddress();
					String sourceAddress = inFormatSMS.getSourceAddress();
					if (targetAddress.substring(0, 8).equals("0000000")) {
						// SP服务
						switch (targetAddress.substring(8, 11)) {
						case "001":// 余额查询
							float balance = bQuery.queryBalance(sourceAddress);
							smsContent = "当前手机余额：" + Float.toString(balance) + "元";
							outFormatSMS = new FormatSMS("CMD003", targetAddress, sourceAddress, "0000", smsContent);
							outsms = FormatService.toStringSMS(outFormatSMS);
							break;
						case "002":// 天气查询
							String cityID = inFormatSMS.getContent().substring(2);
							String weather = weatherQuery.queryWeather(cityID, new Date());
							outFormatSMS = new FormatSMS("CMD003", targetAddress, sourceAddress, "0000", weather);
							outsms = FormatService.toStringSMS(outFormatSMS);
							break;
						case "003":// 充值
							String cardID = inFormatSMS.getContent().substring(0, 10);
							String password = inFormatSMS.getContent().substring(10, 16);
							int s = recharge.recharge(sourceAddress, cardID, password);
							// 1-充值成功；2-充值卡卡号不存在；3-密码错误；4-充值卡失效
							switch (s) {
							case 1:
								smsContent = "充值成功";
								break;
							case 2:
								smsContent = "充值卡卡号不存在";
								break;
							case 3:
								smsContent = "密码错误";
								break;
							case 4:
								smsContent = "充值卡失效";
								break;
							default:
								break;
							}
							String status = "000" + Integer.toString(s);
							outFormatSMS = new FormatSMS("CMD003", targetAddress, sourceAddress, status, smsContent);
							outsms = FormatService.toStringSMS(outFormatSMS);
							break;
						case "004":// 查询
							String func = inFormatSMS.getContent().substring(0, 4);
							String id = inFormatSMS.getContent().substring(4, 15);
							if (func.equals("DXJL")) {
								smsContent = queryRecord.SMSHistoryQueryBySender(id);// 查询短信记录
							} else if (func.equals("JYJL")) {
								smsContent = queryRecord.transactionRecordQuery(id);// 查询交易记录
							}
							outFormatSMS = new FormatSMS("CMD003", targetAddress, sourceAddress, "0000", smsContent);
							outsms = FormatService.toStringSMS(outFormatSMS);
							break;
						default:
							break;
						}

					} else {
						sForward.forward(inFormatSMS);// 转发短信
					}
					break;
				default:
					break;
				}
				pWriter.println(outsms);
				pWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
