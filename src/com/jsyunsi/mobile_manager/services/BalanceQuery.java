package com.jsyunsi.mobile_manager.services;

import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.BalanceQueryInter;
import com.jsyunsi.mobile_manager.vo.User;

public class BalanceQuery implements BalanceQueryInter {

	@Override
	public float queryBalance(String userID) {
		// TODO Auto-generated method stub
		UserDaoInter userDao = new UserDao();
		User user = userDao.getUser(userID);
		return user.getBalance();
	}

}
