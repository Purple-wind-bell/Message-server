package com.jsyunsi.mobile_manager.services;

import com.jsyunsi.mobile_manager.dao.UserDao;
import com.jsyunsi.mobile_manager.daoInter.UserDaoInter;
import com.jsyunsi.mobile_manager.servicesInter.QueryBalanceInter;
import com.jsyunsi.mobile_manager.vo.User;

public class QueryBalanceService implements QueryBalanceInter {
	UserDaoInter userDao = new UserDao();

	@Override
	public float queryBalance(String userID) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(userID);
		return user.getBalance();
	}

}
