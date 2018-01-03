package com.jsyunsi.mobile_manager.daoInter;

import java.util.ArrayList;

import com.jsyunsi.mobile_manager.vo.TransactionRecord;

/**
 * 交易记录管理接口
 * 
 * @author 紫风铃
 *
 */
public interface TransactionRecordDaoInter {

	/**
	 * 添加交易记录
	 * 
	 * @param record
	 *            交易记录
	 * @return true-添加成功
	 */
	boolean addRecord(TransactionRecord record);

	/**
	 * 查询用户交易记录
	 * 
	 * @param userID
	 *            用户ID
	 * @return 交易记录的list
	 */
	ArrayList<TransactionRecord> geRecord(String userID);
}
