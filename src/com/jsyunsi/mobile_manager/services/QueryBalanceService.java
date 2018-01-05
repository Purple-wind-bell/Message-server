package com.jsyunsi.mobile_manager.services;

import com.jsyunsi.mobile_manager.dao.SPDao;
import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.SPDaoInter;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryBalanceInter;
import com.jsyunsi.mobile_manager.vo.SP;
import com.jsyunsi.mobile_manager.vo.User;

public class QueryBalanceService implements QueryBalanceInter {

	@Override
	public float queryBalance(String userID) {
		// TODO Auto-generated method stub
		SPDaoInter spdao = new SPDao();
		SP sp = spdao.getSP("001");
		UserDaoInter userDao = new UserDao();
		User user = userDao.getUser(userID);
		float balance = user.getBalance() - sp.getCharge();
		user.setBalance(balance);
		userDao.updateUser(userID, user);
		return user.getBalance();
	}

}
