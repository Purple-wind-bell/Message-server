package chatting.servicesInter;

/**
 * 余额查询服务接口
 * 
 *
 */
public interface QueryBalanceInter {

	/**
	 * 根据用户ID查询余额
	 * 
	 * @param userID
	 *            用户id
	 * @return 余额
	 */
	float queryBalance(String userID);
}
