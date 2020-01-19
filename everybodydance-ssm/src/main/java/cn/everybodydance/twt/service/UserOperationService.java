package cn.everybodydance.twt.service;

import java.util.Map;

/**
 * 管理员操作服务类
 * 
 * @author tanwentao
 *
 */
public interface UserOperationService {
	/**
	 * 更新密码
	 * 
	 * @return
	 */
	public Map<String, Object> updatePwd(String loginName,String newPassword);

	/**
	 * 插入新管理员
	 * 
	 * @return
	 */
	public Map<String, Object> insertUser(String loginName,String password);

	/**
	 * 删除管理员
	 * 
	 * @return
	 */
	public Map<String, Object> deleteUser(String loginName);
}
