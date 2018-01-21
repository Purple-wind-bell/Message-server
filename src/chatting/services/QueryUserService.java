package chatting.services;

import chatting.dao.UserDao;
import chatting.daoInter.UserDaoInter;
import chatting.servicesInter.QueryUserInter;
import chatting.vo.User;

public class QueryUserService implements QueryUserInter {
	UserDaoInter userDao = new UserDao();

	@Override
	public float queryBalance(String userID) {
		// TODO Auto-generated method stub
		User user = userDao.getUser(userID);
		return user.getBalance();
	}

	@Override
	public User queryUser(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryPassword(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
