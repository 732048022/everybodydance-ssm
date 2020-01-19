package cn.everybodydance.twt.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.everybodydance.twt.dao.LoginCheckDao;
import cn.everybodydance.twt.service.UserOperationService;
import cn.everybodydance.twt.util.AESUtil;

/**
 * 管理员操作相关实现类
 * 
 * @author tanwentao
 *
 */
@Service
public class UserOperationServiceImpl implements UserOperationService {
	/**
	 * 日志类
	 */
	Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 注入数据库操作
	 */
	@Autowired
	private LoginCheckDao loginCheckDao;

	@Override
	public Map<String, Object> updatePwd(String loginName, String newPassword) {
		Map<String, Object> result = new HashMap();
		// 对密码进行AES加密入库
		newPassword = AESUtil.encrypt(newPassword);
		try {
			loginCheckDao.updateUser(newPassword, loginName);
			logger.info("Dao层:管理员{}的密码更新成功......", loginName);
			result.put("success", "true");
		} catch (Exception e) {
			logger.error("修改密码操作异常:{}", e.getMessage());
			result.put("success", "false");
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}

	@Override
	public Map<String, Object> insertUser(String loginName, String password) {
		Map<String, Object> result = new HashMap();
		// 对密码进行AES加密入库
		password = AESUtil.encrypt(password);
		try {
			String flagNum = loginCheckDao.selectUserIfExist(loginName);
			if ("1".equals(flagNum)) {
				logger.error("管理员账号已存在！请重新输入！");
				result.put("success", "false");
				result.put("errorMessage", "无管理员账号已存在！请重新输入！");
			} else {
				loginCheckDao.insertUser(loginName, password);
				logger.info("Dao层:新管理员{}信息入库成功......", loginName);
				result.put("success", "true");
			}
		} catch (Exception e) {
			logger.error("新增管理员异常:{}", e.getMessage());
			result.put("success", "false");
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}

	@Override
	public Map<String, Object> deleteUser(String loginName) {
		Map<String, Object> result = new HashMap();
		try {
			String flagNum = loginCheckDao.selectUserIfExist(loginName);
			if (!"1".equals(flagNum)) {
				logger.error("管理员账号不存在或已删除！");
				result.put("success", "false");
				result.put("errorMessage", "管理员账号不存在或已删除！");
			} else {
				loginCheckDao.deleteUser(loginName);
				logger.info("Dao层:管理员{}已被删除......", loginName);
				result.put("success", "true");
			}
		} catch (Exception e) {
			logger.error("删除管理员异常:{}", e.getMessage());
			result.put("success", "false");
			result.put("errorMessage", e.getMessage());
		}
		return result;
	}

}
