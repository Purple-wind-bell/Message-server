package com.jsyunsi.mobile_manager.daoInter;

import com.jsyunsi.mobile_manager.vo.SP;

/**
 * SP服务管理接口
 * 
 * @author 紫风铃
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
	 * 查询SP服务名称
	 * 
	 * @param ID
	 *            SP服务ID
	 * @return
	 */
	String getName(String ID);

	/**
	 * 查询SP服务费
	 * 
	 * @param ID
	 *            SP服务ID
	 * @return 服务费
	 */
	float getCharge(String ID);

	/**
	 * 判断服务是否可用
	 * 
	 * @param ID
	 * @return true-可用
	 */
	String isAvaiable(String ID);

}
