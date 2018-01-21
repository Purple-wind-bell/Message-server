package chatting.daoInter;

import chatting.vo.SP;

/**
 * SP服务管理接口
 * 
 *
 */
public interface SPDaoInter {
	/**
	 * 添加SP服务
	 * 
	 * @param spService
	 * @return true-添加成功
	 */
	boolean addSP(SP sp);

	/**
	 * 删除SP服务
	 * 
	 * @param ID
	 *            SP服务ID
	 * @return true-删除成功
	 */
	boolean deleteSP(String ID);

	/**
	 * 更新SP服务信息
	 * 
	 * @param ID
	 * @param spService
	 * @return
	 */
	boolean updateSP(String ID, SP sp);

	/**
	 * 查询SP服务信息
	 * 
	 * @param ID
	 *            SP服务ID
	 * @return
	 */
	SP getSP(String ID);

}
