package cn.everybodydance.twt.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;

import cn.everybodydance.twt.dao.LoginCheckDao;
import cn.everybodydance.twt.service.AllCheckService;
import cn.everybodydance.twt.service.impl.AllCheckServiceImpl;

/**
 * 验证码控制器
 * 
 * @author tanwentao
 *
 */
@Controller
@RequestMapping("/html/code")
public class AllCheckController {
	/**
	 * 日志类
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 注入校验服务
	 */
	@Autowired
	private AllCheckService allCheckServiceImpl;

	/**
	 * 后台校验用户名密码
	 * 
	 * @param loginName 用户名
	 * @param password  密码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/allCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> allCheck(String kaptchaCode, String loginName, String password,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Controller层已转发请求:{}","/html/code/allCheck");
		Map<String, Object> result;

		result = allCheckServiceImpl.allCheckService(kaptchaCode, loginName, password, request);
		return result;
	}
}
