package com.jsyunsi.mobile_manager.services;

import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.vo.SP;
import com.jsyunsi.mobile_manager.vo.User;

/**
 * SP服务扣费
 * 
 * @author Administrator
 *
 */
public class Charging {
	private UserDaoInter udao = new UserDao();
	private SPDaoInter spdao = new SPDao();

	/**
	 * SP服务扣费
	 * 
	 * @param spID
	 * @param userID
	 */
	public void charge(String spID, String userID) {
		// - 扣费
		SP sp = spdao.getSP(spID);
		User user = udao.getUser(userID);
		float balance = user.getBalance() - sp.getCharge();
		user.setBalance(balance);
		udao.updateUser(user.getUserID(), user);
	}
}
