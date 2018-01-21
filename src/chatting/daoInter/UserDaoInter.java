package chatting.daoInter;

import java.util.ArrayList;

import chatting.vo.User;

/**
 * 用户数据管理接口
 * 
 *
 */
public interface UserDaoInter {

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	boolean addUSer(User user);

	/**
	 * 删除用户
	 * 
	 * @param userID
	 * @return
	 */
	boolean delUser(String userID);

	/**
	 * 设置用户信息
	 * 
	 * @param userID
	 * @param user
	 * @return
	 */
	boolean updateUser(String userID, User user);

	/**
	 * 获得用户信息
	 * 
	 * @param userID
	 * @return 用户不存在返回null
	 */
	User getUser(String userID);

	/**
	 * 获得所有用户ID
	 * 
	 * @return
	 */
	ArrayList<User> getAllUser();
}
