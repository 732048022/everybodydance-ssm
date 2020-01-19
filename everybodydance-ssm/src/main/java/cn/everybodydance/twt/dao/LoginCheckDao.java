package cn.everybodydance.twt.dao;

import org.apache.ibatis.annotations.Param;

public interface LoginCheckDao {

	/**
	 * 查询用户是否存在
	 * @param loginName
	 * @return
	 */
	String selectUserIfExist(String loginName);
	/**
	 * 根据账号查找密码
	 * 
	 * @param loginName 用户名
	 * @return
	 */
	String selectPasswordByLoginName(String loginName);
	
	/**
	 * 插入后管账号
	 * @param loginName 用户名
	 * @param password 密码（已加密）
	 */
	void insertUser(@Param("loginName")String loginName,@Param("password")String password);
	
	/**
	 * 删除后管账号
	 * @param loginName 用户名
	 */
	void deleteUser(String loginName);
	
	/**
	 * 修改后管账号的密码
	 * @param newPassword 新密码
	 * @param loginName 用户名
	 */
	void updateUser(@Param("newPassword")String newPassword,@Param("loginName")String loginName);
}
