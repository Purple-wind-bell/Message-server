package com.jsyunsi.mobile_manager.servicesInter;

/**
 * 余额查询服务接口
 * 
 *
 */
public interface BalanceQueryInter {

	/**
	 * 根据用户ID查询余额
	 * 
	 * @param userID
	 *            用户id
	 * @return 余额
	 */
	float queryBalance(String userID);
}
