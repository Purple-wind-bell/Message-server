package chatting.servicesInter;

/**
 * 充值卡充值服务接口
 * 
 *
 */
public interface RechargeInter {

	/**
	 * 手机号充值，要完成充值卡数据库、交易记录数据库以及用户数据库更新
	 * 
	 * @param userID
	 *            用户ID
	 * @param cardID
	 *            充值卡卡号
	 * @param password
	 *            充值卡密码
	 * @return 状态码：1-充值成功；2-充值卡卡号不存在；3-密码错误；4-充值卡失效
	 */
	int recharge(String userID, String cardID, String password);

}
