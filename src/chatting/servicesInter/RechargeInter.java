package chatting.servicesInter;

/**
 * 充值服务接口
 * 
 *
 */
public interface RechargeInter {

	/**
	 * 账户充值，要完成交易记录数据库以及用户数据库更新
	 * 
	 * @param userID
	 *            用户ID
	 * 
	 * @param payment
	 *            充值金额
	 * @return 状态码：true-充值成功；false-充值失败
	 */
	boolean recharge(String userID, float payment);

}
