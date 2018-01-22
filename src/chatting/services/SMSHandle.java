package chatting.services;

import java.sql.Timestamp;
import java.util.Date;
import chatting.dao.SMSHistoryDao;
import chatting.dao.SPDao;
import chatting.dao.UserDao;
import chatting.daoInter.SMSHistoryDaoInter;
import chatting.daoInter.SPDaoInter;
import chatting.daoInter.UserDaoInter;
import chatting.servicesInter.QueryUserInter;
import chatting.servicesInter.QueryRecordInter;
import chatting.servicesInter.QueryWeatherInter;
import chatting.servicesInter.RechargeInter;
import chatting.vo.Message;
import chatting.vo.SMSHistory;
import chatting.vo.User;

/**
 * 处理接收的短信，进行相应的处理，包括生成回复短信
 * 
 * @author 紫风铃
 *
 */
public class SMSHandle {
	private QueryUserInter bQuery = new QueryUserService();
	private LoginRegisterService lrService = new LoginRegisterService();
	private RechargeInter recharge = new RechargeService();
	private QueryWeatherInter weatherQuery = new QueryWeatherService();
	private QueryRecordInter queryRecord = new QueryRecordService();
	UserDaoInter udao = new UserDao();
	SPDaoInter spdao = new SPDao();
	SMSHistoryDaoInter smsHistoryDao = new SMSHistoryDao();
	String status = "0001";// 默认返回状态码
	String smsContent = "0";// 默认返回短信内容
	String cmd = "CMD002";// 默认命令

}
