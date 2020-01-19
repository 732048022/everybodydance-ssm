package cn.everybodydance.twt.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.everybodydance.twt.service.UserOperationService;

/**
 * 管理员操作控制器
 * 
 * @author tanwentao
 *
 */
@Controller
@RequestMapping("/html/user")
public class UserOperationController {
	/**
	 * 日志类
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 注入管理员操作服务
	 */
	@Autowired
	private UserOperationService userOperationServiceImpl;
	
	/**
	 * 新增用户
	 * @param request
	 * @param response
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insertUser(HttpServletRequest request,HttpServletResponse response,String loginName,String password) throws Exception{
		logger.info("Controller层已转发请求:{}","/html/user/insertUser");
		Map<String,Object> result;
		result=userOperationServiceImpl.insertUser(loginName, password);
		return result;
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @param loginName
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateUser(HttpServletRequest request,HttpServletResponse response,String welcomeName,String newPwd) throws Exception{
		logger.info("Controller层已转发请求:{}","/html/user/updateUser");
		Map<String,Object> result;
		result=userOperationServiceImpl.updatePwd(welcomeName, newPwd);
		return result;
	}
	
	@RequestMapping(value="deleteUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,String delUserName) throws Exception{
		logger.info("Controller层已转发请求:{}","/html/user/deleteUser");
		Map<String,Object> result;
		result=userOperationServiceImpl.deleteUser(delUserName);
		return result;
	}
}
