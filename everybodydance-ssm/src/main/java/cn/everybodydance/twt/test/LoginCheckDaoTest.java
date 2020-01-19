package cn.everybodydance.twt.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.everybodydance.twt.dao.LoginCheckDao;

/**
 * 测试类测试登录
 * 
 * @author tanwentao
 *
 */
public class LoginCheckDaoTest extends BaseTest {
	/**
	 * 注入handleVideoDao
	 */
	@Autowired
	private LoginCheckDao loginCheckDao;
	/**
	 * 添加日志类
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 测试查询是否存在用户
	 * @throws Exception
	 */
	@Test
	public void selectUserIfExist() throws Exception{
			String flag=loginCheckDao.selectUserIfExist("11");
			System.out.println(flag);
	}
	/**
	 * 测试根据用户名查询密码
	 * 
	 * @throws Exception
	 */
	@Test
	public void selectPasswordByLoginNameTest() throws Exception {
		String loginName = "admin";
		String password = loginCheckDao.selectPasswordByLoginName(loginName);
		logger.info("测试密码为:{}", password);
	}
	
	/**
	 * 测试插入后管用户
	 * @throws Exception
	 */
	@Test
	public void insertUserTest() throws Exception{
		String loginName="admin1";
		String password="123456";
		loginCheckDao.insertUser(loginName, password);
	}
	
	/**
	 * 测试删除后管用户
	 * @throws Exception
	 */
	@Test
	public void deleteUserTest() throws Exception{
		String loginName="admin1";
		loginCheckDao.deleteUser(loginName);
	}
	/**
	 * 测试修改后管用户
	 * @throws Exception
	 */
	@Test
	public void updateUserTest() throws Exception{
		String loginName="admin1";
		String newPassword="1111111";
		loginCheckDao.updateUser(newPassword, loginName);
	}
	
}
