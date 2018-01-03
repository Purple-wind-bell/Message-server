package com.jsyunsi.mobile_manager.daoInter;

/**
 * 充值卡管理接口
 * 
 * @author 紫风铃
 *
 */
public interface RechargeableCardDaoInter {

	/**
	 * 更新充值卡状态
	 *
	 * @param cardID
	 *            充值卡卡号
	 * @return true:更新成功
	 */
	boolean updateRechargeCardStatus(String cardID);

	/**
	 * 检测充值卡状态
	 * 
	 * @param cardID
	 *            充值卡卡号
	 * @return 充值卡状态：true-充值卡可用；false-充值卡已使用
	 */
	boolean getRechargeCardStatus(String cardID);

	/**
	 * 充值卡检查
	 * 
	 * @param cardID
	 *            充值卡卡号
	 * @param password
	 *            充值卡密码
	 * @return 检测状态码：1-充值卡不存在；2-密码错误；3-密码正确；
	 */
	int checkRechargeCard(String cardID, String password);

	/**
	 * 添加充值卡
	 * 
	 * @param cardID
	 *            卡号
	 * @param password
	 *            密码
	 * @return 状态码：1-添加成功；2-添加失败，卡号已存在
	 */
	int addRechargeCard(String cardID, String password);
}
