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

import cn.everybodydance.twt.service.LoginCheckService;
import cn.everybodydance.twt.service.SessionCheckService;

/**
 * 判断是否登陆控制器
 * 
 * @author tanwentao
 *
 */
@Controller
@RequestMapping("/html/login")
public class LoginCheckController {
	/**
	 * 日志类
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 注入登录校验服务
	 */
	@Autowired
	private LoginCheckService loginCheckServiceImpl;

	/**
	 * 注入session校验服务
	 */
	@Autowired
	private SessionCheckService sessionCheckServiceImpl;

	/**
	 * 后台校验用户名密码
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Controller层已转发请求:{}", "/html/login/loginCheck");
		Map<String, Object> result;
		result = loginCheckServiceImpl.loginCheckService(request);
		return result;
	}

	/**
	 * 后台校验
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sessionCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sessionCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Controller层已转发请求:{}", "/html/login/sessionCheck");
		Map<String, Object> result;
		result = sessionCheckServiceImpl.sessionCheckService(request);
		return result;

	}
}
