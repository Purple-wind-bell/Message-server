package chatting.services;

import chatting.dao.UserDao;
import chatting.daoInter.UserDaoInter;
import chatting.servicesInter.QueryBalanceInter;
import chatting.vo.User;

public class QueryBalanceService implements QueryBalanceInter {
	UserDaoInter userDao = new UserDao();

	@Override
	public float queryBalance(String userID) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(userID);
		return user.getBalance();
	}

}
